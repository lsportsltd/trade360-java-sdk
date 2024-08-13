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
import java.text.MessageFormat;
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

        val msgType = getMsgType(message);
        val msg = parseMessage(message,msgType);
        val typeId = getTypeIdFromMessage(message);
        val handler = entityMap.get(typeId);
        handler.Process(msg);
    }

    public void RegisterEntityHandler(EntityHandling entityHandling){
        entityMap.put(entityHandling.GetEntityKey(),entityHandling);
    }
    private Class<?> getMsgType(final Message message) throws ClassNotFoundException, RabbitMQFeedException {

        val typeId = getTypeIdFromMessage(message);
        val className = MessageType.finMessageType(typeId);

        if (className == null)
            throw new RabbitMQFeedException(MessageFormat.format("Message TypeId: {0} not registered in enum MessageTypes or wrong or not provided in message.", typeId));
        else
            return Class.forName(messageTypeClassPath + className);
    }

    private int getTypeIdFromMessage(final @NotNull Message message) throws RabbitMQFeedException {
        String typeIdHeaderValue = message.getMessageProperties().getHeader(typeIdPropertyHeaderName);

        if (typeIdHeaderValue == null || typeIdHeaderValue.isEmpty())
            throw new RabbitMQFeedException("Wrong or lack of 'type' property in Rabbit message header.");
        else
            return Integer.parseInt(typeIdHeaderValue);
    }

    private Object parseMessage(final Message message, final Class<?> clazz) throws Exception {
        try {
            return objectMapper.readValue(message.getBody(), clazz);
        } catch (final Exception ex) {
            throw new Exception("Failed to parse event message");
        }
    }
}
