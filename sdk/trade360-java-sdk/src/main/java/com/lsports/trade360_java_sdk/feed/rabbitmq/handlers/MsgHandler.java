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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MsgHandler implements MessageHandler {
    private ConcurrentHashMap<Integer, EntityHandler> entityMap;
    private final static String messageTypeClassPath = "com.lsports.trade360_java_sdk.common.entities.message_types.";
    private final static String typeIdPropertyHeaderName = "Type";
    private final ObjectMapper objectMapper;

      public MsgHandler(){
          entityMap = new ConcurrentHashMap<>();
          objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
    }

    @Override
    public void process(Message message) throws Exception {

        val typeId = getTypeIdFromMessage(message);
        val msgType = getMessageType(typeId);
        val body = getBodyFromMessage(message);
        val msg = parseMessage(body,msgType);
        val handler = entityMap.get(typeId);
        handler.process(msg);
    }

    public void registerEntityHandler(EntityHandler entityHandler) throws RabbitMQFeedException {

        if ( entityMap.containsKey(entityHandler.getEntityKey()))
            throw new RabbitMQFeedException(MessageFormat.format("Provided EntityHandler already exists! - {0} - {1}", entityHandler.getEntityKey(), entityHandler.getClass().toString() ));
        else
            entityMap.put(entityHandler.getEntityKey(), entityHandler);
    }

    private Class<?> getMessageType(final int typeId ) throws ClassNotFoundException, RabbitMQFeedException {
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

    private Object parseMessage(final String json, final Class<?> clazz) throws Exception {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (final Exception ex) {
            throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize '{0}' entity", clazz.getSimpleName()));
        }
    }
}
