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
import java.util.HashMap;
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
        int typeId = getTypeIdFromMessage(amqpMessage);
        MessageType messageType = getMessageType(typeId);
        Class<?> msgType = messageType.getMessageClass();
        String body = "";
        Object msg = null;

        if (messageType.hasBody()){
            body = getBodyFromMessage(amqpMessage);
            msg = parseMessage(body, msgType);
        }

        Map<String, String> header = getHeaderFromMessage(amqpMessage);
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

    private int getTypeIdFromMessage(final @NotNull Message message) throws RabbitMQFeedException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = objectMapper.readValue(message.getBody(), Map.class);
            Map<String, Object> headerMap = (Map<String, Object>) map.get(headerPropertyName);
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

    private String getBodyFromMessage(final @NotNull Message message) throws RabbitMQFeedException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = objectMapper.readValue(message.getBody(), Map.class);
            if (!map.containsKey(bodyPropertyName) || map.get(bodyPropertyName) == null) {
                throw new RabbitMQFeedException("Message body is missing or null.");
            }
            Object body = map.get(bodyPropertyName);
            return objectMapper.writeValueAsString(body);
        } catch (Exception ex) {
            throw new RabbitMQFeedException("Failed to parse body from message.", ex);
        }
    }

    private Map<String, String> getHeaderFromMessage(final @NotNull Message message) throws RabbitMQFeedException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = objectMapper.readValue(message.getBody(), HashMap.class);
            Map<String, String> header = (Map<String, String>) map.get(headerPropertyName);

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