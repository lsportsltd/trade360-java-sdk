package eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import eu.lsports.trade360_java_sdk.common.entities.enums.MessageType;
import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.common.models.TransportMessageHeaders;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.MessageHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;
import java.text.MessageFormat;
import java.util.Map;

/**
 * Handles AMQP messages by processing them and delegating to the appropriate entity handler.
 */
@Component
public class AmqpMessageHandler implements MessageHandler {

    private final String messageTypeClassPath = "eu.lsports.trade360_java_sdk.common.entities.message_types.";
    private final String typeIdPropertyHeaderName = "Type";
    private final String headerPropertyName = "Header";
    private final String bodyPropertyName = "Body";

    private final EntityRegistry entityRegister;
    private final ObjectMapper objectMapper;
    protected final Logger logger = LogManager.getLogger();

    /**
     * Constructs a new AmqpMessageHandler with the given entity registry.
     *
     * @param entityRegistry The registry for entity handlers
     */
    public AmqpMessageHandler(EntityRegistry entityRegistry) {
        entityRegister = entityRegistry;
        objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void process(Message amqpMessage) throws Exception {
        // Parse the message body only once to avoid redundant JSON deserialization
        Map<String, Object> parsedMessage = parseMessageOnce(amqpMessage);
        
        int typeId = getTypeIdFromParsedMessage(parsedMessage);
        MessageType messageType = getMessageType(typeId);
        Class<?> msgType = messageType.getMessageClass();
        Object msg = null;

        if (messageType.hasBody()){
            String body = getBodyFromParsedMessage(parsedMessage);
            msg = parseMessage(body, msgType);
        }

        Map<String, String> header = getHeaderFromParsedMessage(parsedMessage);
        Map<String, String> transportHeaders = TransportMessageHeaders.createFromProperties(amqpMessage.getMessageProperties().getHeaders()).getAsMap();
        EntityHandler handler = getEntityHandler(typeId);

        handler.process(msg, header, transportHeaders);
    }

    private @NotNull MessageType getMessageType(final int typeId) throws RabbitMQFeedException {
        try {
            return MessageType.findMessageType(typeId);
        } catch (ClassNotFoundException e) {
            throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize typeId: {0} entity", typeId), e);
        }
    }

    private Map<String, Object> parseMessageOnce(final @NotNull Message message) throws RabbitMQFeedException {
        try {
            return objectMapper.readValue(message.getBody(), Map.class);
        } catch (Exception ex) {
            throw new RabbitMQFeedException("Failed to parse message.", ex);
        }
    }

    private int getTypeIdFromParsedMessage(final @NotNull Map<String, Object> parsedMessage) throws RabbitMQFeedException {
        try {
            Map<String, Object> headerMap = (Map<String, Object>) parsedMessage.get(headerPropertyName);
            if (headerMap == null) {
                throw new RabbitMQFeedException("Message header is missing.");
            }
            
            Object typeIdHeaderValueObj = headerMap.get(typeIdPropertyHeaderName);
            String typeIdHeaderValue = (typeIdHeaderValueObj != null) ? typeIdHeaderValueObj.toString() : null;

            if (typeIdHeaderValue == null || typeIdHeaderValue.isEmpty())
                throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize {0} entity, Due to: Wrong or lack of 'type' property in Rabbit message header.", typeIdHeaderValue));
            else
                return Integer.parseInt(typeIdHeaderValue);
        } catch (Exception ex) {
            throw new RabbitMQFeedException("Failed to parse typeId from message.", ex);
        }
    }

    private String getBodyFromParsedMessage(final @NotNull Map<String, Object> parsedMessage) throws RabbitMQFeedException {
        try {
            if (!parsedMessage.containsKey(bodyPropertyName) || parsedMessage.get(bodyPropertyName) == null) {
                throw new RabbitMQFeedException("Message body is missing or null.");
            }
            Object body = parsedMessage.get(bodyPropertyName);
            return objectMapper.writeValueAsString(body);
        } catch (Exception ex) {
            throw new RabbitMQFeedException("Failed to parse body from message.", ex);
        }
    }

    private Map<String, String> getHeaderFromParsedMessage(final @NotNull Map<String, Object> parsedMessage) throws RabbitMQFeedException {
        try {
            Map<String, String> header = (Map<String, String>) parsedMessage.get(headerPropertyName);
            if (header == null) {
                throw new RabbitMQFeedException("Message header is missing.");
            }
            return header;
        } catch (Exception ex) {
            throw new RabbitMQFeedException("Failed to parse header from message.", ex);
        }
    }

    private Object parseMessage(final String json, final Class<?> clazz) throws Exception {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (final Exception ex) {
            throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize {0} entity.", clazz.getSimpleName()), ex);
        }
    }

    private EntityHandler getEntityHandler(int typeId) {
        EntityHandler entityHandler = entityRegister.getEntityByTypeId(typeId);
        if (entityHandler == null)
            throw new Trade360Exception(MessageFormat.format("Entity Handler not found - please register it for typeId: {0} with EntityRegistry.setEntityHandler() method.", typeId));
        return entityHandler;
    }
}