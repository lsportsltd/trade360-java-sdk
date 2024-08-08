package com.lsports.trade360feedexample;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lsports.trade360_java_sdk.common.entities.enums.MessageTypes;
import com.lsports.trade360_java_sdk.common.entities.livescore.LivescoreEvent;
import com.lsports.trade360_java_sdk.common.entities.messagetypes.LivescoreUpdate;
import com.lsports.trade360_java_sdk.common.entities.messagetypes.MarketUpdate;
import com.lsports.trade360_java_sdk.common.models.TestClass;
import com.lsports.trade360_java_sdk.feed.rabbitmq.EventUtility;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.SimpleErrors;
import org.springframework.validation.Validator;
import org.springframework.web.client.RestClient;

import java.util.Map;


@Slf4j
@Service

public class RabbitMQFeed {


@RabbitListener(queues = "_${rabbitmq.inplay.package_id}_")
    public void processEmailNotificationListenerId(final Message message) throws Exception {
        String typeIdHeaderValue = message.getMessageProperties().getHeader(typeIdPropertyHeaderName);
        int typeId = Integer.parseInt(typeIdHeaderValue);
        val className = MessageTypes.finMessageType(typeId).toString();
        parse(message, Class.forName(className));

    }

    private final String typeIdPropertyHeaderName = "type";

    private <T> T parse(final Message message, final Class<T> clazz) throws Exception {
        val messageId = EventUtility.messageId(message);

        final ObjectMapper objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                       .configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                       .registerModule(new JavaTimeModule());

        try {
            val value = objectMapper.readValue(message.getBody(), clazz);

            return value;
        } catch (final Exception ex) {
            throw new Exception("Failed to parse event message");
        }
    }
}

