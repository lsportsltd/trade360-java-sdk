package com.lsports.trade360feedexample;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lsports.trade360_java_sdk.common.entities.enums.MessageType;
import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;
import lombok.val;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import java.text.MessageFormat;

@Service
public class RabbitMQFeed {

    private final String messageTypePath = "com.lsports.trade360_java_sdk.common.entities.messagetypes.";
    private final String typeIdPropertyHeaderName = "type";
    private final ObjectMapper objectMapper;
    private final EntityHandling entityHandling;

    public RabbitMQFeed(EntityHandling entityHandling) {

        this.entityHandling = entityHandling;
        objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
    }

    @RabbitListener(queues = "_${rabbitmq.inplay.package_id}_")
    public void processMessage(final Message message) throws Exception {

        Class<?> msgType = getMsgType(message);
        val msg = parseMessage(message,msgType);
        entityHandling.Process(msg);
    }

   private Class<?> getMsgType(final Message message) throws ClassNotFoundException, RabbitMQFeedException {

       val typeId = getTypeIdFromMessage(message);
       val className = MessageType.finMessageType(typeId);

       if (className == null)
         throw new RabbitMQFeedException(MessageFormat.format("Message TypeId: {0} not registered in enum MessageTypes or wrong or not provided in message.", typeId));
       else
         return  Class.forName(messageTypePath + className);
   }

    private int getTypeIdFromMessage(final Message message) throws RabbitMQFeedException {
        String typeIdHeaderValue = message.getMessageProperties().getHeader(typeIdPropertyHeaderName);

        if (typeIdHeaderValue == null || typeIdHeaderValue.isEmpty())
            throw new RabbitMQFeedException("Wrong or lack of 'type' property in Rabbit message header.");
        else
            return Integer.parseInt(typeIdHeaderValue);
    }

    private <T> T parseMessage(final Message message, final Class<T> clazz) throws Exception {
        try {
            val value = objectMapper.readValue(message.getBody(), clazz);
            return value;
        } catch (final Exception ex) {
            throw new Exception("Failed to parse event message");
        }
    }
}

