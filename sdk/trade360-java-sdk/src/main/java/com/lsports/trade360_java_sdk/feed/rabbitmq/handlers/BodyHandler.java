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
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.text.MessageFormat;

@Component
public class BodyHandler<T extends EntityHandling> implements BodyHandling {
    //@Autowired
   // private final EntityHandling<T> entityHandling;
    private final String messageTypePath = "com.lsports.trade360_java_sdk.common.entities.messagetypes.";
    private final String typeIdPropertyHeaderName = "type";
    private final ObjectMapper objectMapper;

  //  public BodyHandler(EntityHandling<T> entityHandler) {
      public BodyHandler(){

        //this.entityHandling = entityHandler;
        objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
    }

    @Override
    public void Process(Message message) throws Exception {

        val msgType = getMsgType(message);
        val msg = parseMessage(message,msgType);
        msg.Process();
        ((T)msg).Process();
    }

    private Class<?> getMsgType(final Message message) throws ClassNotFoundException, RabbitMQFeedException {

        val typeId = getTypeIdFromMessage(message);
        val className = MessageType.finMessageType(typeId);

        if (className == null)
            throw new RabbitMQFeedException(MessageFormat.format("Message TypeId: {0} not registered in enum MessageTypes or wrong or not provided in message.", typeId));
        else
            return Class.forName(messageTypePath + className);
    }

    private int getTypeIdFromMessage(final Message message) throws RabbitMQFeedException {
        String typeIdHeaderValue = message.getMessageProperties().getHeader(typeIdPropertyHeaderName);

        if (typeIdHeaderValue == null || typeIdHeaderValue.isEmpty())
            throw new RabbitMQFeedException("Wrong or lack of 'type' property in Rabbit message header.");
        else
            return Integer.parseInt(typeIdHeaderValue);
    }

    private T parseMessage(final Message message, final Class<?> clazz) throws Exception {
        try {
            val value = objectMapper.readValue(message.getBody(), clazz);
            return (T)value;
        } catch (final Exception ex) {
            throw new Exception("Failed to parse event message");
        }
    }
}
