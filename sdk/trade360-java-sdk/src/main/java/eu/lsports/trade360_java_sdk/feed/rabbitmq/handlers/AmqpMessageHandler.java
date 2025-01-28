package eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import eu.lsports.trade360_java_sdk.common.entities.enums.MessageType;
import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.MessageHandler;

import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles AMQP messages by processing them and delegating to the appropriate entity handler.
 */
@Component
public class AmqpMessageHandler implements MessageHandler {
    private final EntityRegistry entityRegister;
    private final String messageTypeClassPath = "eu.lsports.trade360_java_sdk.common.entities.message_types.";
    private final String typeIdPropertyHeaderName = "Type";
    private final String headerPropertyName = "Header";
    private final String bodyPropertyName = "Body";
    private final ObjectMapper objectMapper;

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
        Class<?> msgType = getMessageType(typeId);
        String body = getBodyFromMessage(amqpMessage);
        Object msg = parseMessage(body, msgType);
        Map<String, String> header = getHeaderFromMessage(amqpMessage);
        EntityHandler handler = getEntityHandler(typeId);

        handler.process(msg, header);
    }

    private @NotNull Class<?> getMessageType(final int typeId) throws ClassNotFoundException, RabbitMQFeedException {
        MessageType className;
        className = MessageType.findMessageType(typeId);
        if (className == null)
            throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize typeId: {0} entity", typeId));
        else
            return Class.forName(messageTypeClassPath + className);
    }

    private int getTypeIdFromMessage(final @NotNull Message message) throws RabbitMQFeedException, IOException {
        val map = objectMapper.readValue(message.getBody(), Map.class);
        val typeIdHeaderValue = ((Map) map.get(headerPropertyName)).get(typeIdPropertyHeaderName).toString();

        if (typeIdHeaderValue == null || typeIdHeaderValue.isEmpty())
            throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize {0} entity, Due to: Wrong or lack of 'type' property in Rabbit message header.", typeIdHeaderValue));
        else
            return Integer.parseInt(typeIdHeaderValue);
    }

    private String getBodyFromMessage(final @NotNull Message message) throws RabbitMQFeedException, IOException {
        val body = objectMapper.readValue(message.getBody(), Map.class).get(bodyPropertyName);
        return objectMapper.writeValueAsString(body);
    }

    private Map<String, String> getHeaderFromMessage(final @NotNull Message message) throws RabbitMQFeedException, IOException {
        val header = (Map) objectMapper.readValue(message.getBody(), HashMap.class).get(headerPropertyName);
        return header;
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