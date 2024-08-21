package com.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lsports.trade360_java_sdk.common.entities.enums.MessageType;
import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.BodyHandling;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class BodyHandler implements BodyHandling {
    ConcurrentHashMap<Integer, EntityHandling> entityMap;
    private final static String messageTypeClassPath = "com.lsports.trade360_java_sdk.common.entities.messagetypes.";
    private final static String typeIdPropertyHeaderName = "type";
    private final ObjectMapper objectMapper;

      public BodyHandler(){
          entityMap = new ConcurrentHashMap<>();
          objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
    }

    @Override
    public void Process(Message message) throws Exception {

        val typeId = getTypeIdFromMessage(message);
        val msgType = getMsgType(typeId);
        val msg = parseMessage(message,msgType);
        val handler = entityMap.get(typeId);
        handler.Process(msg);
    }

    public void RegisterEntityHandler(EntityHandling entityHandling){
        entityMap.put(entityHandling.GetEntityKey(),entityHandling);
    }

    private Class<?> getMsgType(final int typeId ) throws ClassNotFoundException, RabbitMQFeedException {
        val className = MessageType.finMessageType(typeId);

        if (className == null)
            throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize '{0}' entity",typeId));
        else
            return Class.forName(messageTypeClassPath + className);
    }

    private int getTypeIdFromMessage(final @NotNull Message message) throws RabbitMQFeedException, IOException {
        val map = objectMapper.readValue(message.getBody(), Map.class);
        val typeIdHeaderValue =((Map)map.get("Header")).get("Type").toString();

        if (typeIdHeaderValue == null || typeIdHeaderValue.isEmpty())
            throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize '{0}' entity, Due to: Wrong or lack of 'type' property in Rabbit message header.",typeIdHeaderValue));
        else
            return Integer.parseInt(typeIdHeaderValue);
    }

    private Object parseMessage(final Message message, final Class<?> clazz) throws Exception {
        try {
            return objectMapper.readValue(message.getBody(), clazz);
        } catch (final Exception ex) {
            throw new RabbitMQFeedException(MessageFormat.format("Failed to deserialize '{0}' entity", clazz.getSimpleName()));
        }
    }
}
