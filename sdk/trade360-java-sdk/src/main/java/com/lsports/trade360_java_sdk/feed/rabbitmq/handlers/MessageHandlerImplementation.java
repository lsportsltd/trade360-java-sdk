package com.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lsports.trade360_java_sdk.common.entities.enums.MessageType;
import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.MessageHandler;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@Component
public class MessageHandlerImplementation implements MessageHandler {
    private final EntityRegistry entityRegister;
    private final static String messageTypeClassPath = "com.lsports.trade360_java_sdk.common.entities.message_types.";
    private final static String typeIdPropertyHeaderName = "Type";
    private final ObjectMapper objectMapper;

      public MessageHandlerImplementation(EntityRegistry entityRegistry){
          entityRegister = entityRegistry;
          objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
    }

    @Override
    public void process(Message message) throws Exception {

        int typeId = getTypeIdFromMessage(message);
        Class<?> msgType = getMessageType(typeId);
        String body = getBodyFromMessage(message);
        Object msg = parseMessage(body,msgType);
        Map<String,String> header = getHeaderFromMessage(message);
        EntityHandler handler = entityRegister.getEntityByTypeId(typeId);
        
        handler.process(msg, header);
    }

    private @NotNull Class<?> getMessageType(final int typeId ) throws ClassNotFoundException, RabbitMQFeedException {
        val className = MessageType.findMessageType(typeId);

        if (className == null)
            throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize '{0}' entity",typeId));
        else
            return Class.forName(messageTypeClassPath + className);
    }

    private int getTypeIdFromMessage(final @NotNull Message message) throws RabbitMQFeedException, IOException {
        val map = objectMapper.readValue(message.getBody(), Map.class);
        val typeIdHeaderValue =((Map)map.get("Header")).get(typeIdPropertyHeaderName).toString();

        if (typeIdHeaderValue == null || typeIdHeaderValue.isEmpty())
            throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize '{0}' entity, Due to: Wrong or lack of 'type' property in Rabbit message header.",typeIdHeaderValue));
        else
            return Integer.parseInt(typeIdHeaderValue);
    }

    private String getBodyFromMessage(final @NotNull Message message) throws RabbitMQFeedException, IOException {
        val body = objectMapper.readValue(message.getBody(), Map.class).get("Body");
        return objectMapper.writeValueAsString(body);
    }

    private Map<String,String> getHeaderFromMessage(final @NotNull Message message) throws RabbitMQFeedException, IOException {
        Map<String,String> map = new HashMap<String,String>();
        val header = (Map)objectMapper.readValue(message.getBody(), HashMap.class).get("Header");
        return header;
    }

    private Object parseMessage(final String json, final Class<?> clazz) throws Exception {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (final Exception ex) {
            throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize '{0}' entity", clazz.getSimpleName()));
        }
    }
}
