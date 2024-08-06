package com.lsports.trade360feedexample;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.MarketUpdate;
import com.lsports.trade360_java_sdk.common.models.TestClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RabbitListener(queues =  "_${rabbitmq.inplay.package_id}_")
public class RabbitMQFeed {

    @Value("_${rabbitmq.inplay.package_id}_")
    private String packageId = "_${packageId}_";

    @RabbitHandler
   // @RabbitListener(queues =  "_${rabbitmq.inplay.package_id}_")
   // public void processOrder(String message) {
    public void processOrder(@Header("amqp_receivedRoutingKey") String header, @Payload MarketUpdate message) {
    //public void processOrder(    @Payload String message, @Header("amqp_consumerQueue") String queue,  @Header("TypeId") String typeId)  {
        log.info("Received message [{}]", message);
        log.info("header: " +  header );
        //log.info("Queue: " +  queue + " TypeId: " + typeId);
    }

    @RabbitHandler
    public void processOrder(@Payload MarketUpdate message)  {
        log.info("Message Type: " + message.getClass() + " Received message [{}]", message);
    }

    @RabbitHandler()
    public void processOrder(@Payload TestClass message) {
        log.info("Message Type: " + message.getClass() + " Received message [{}]", message);
    }

    @RabbitHandler(isDefault = true)
     public void processOrder(@Payload String message, @Header("amqp_receivedRoutingKey") String header) {
        log.info("Default RabbitHandler! : Received message [{}]", message);
        log.info("Default RabbitHandler! : Received header [{}]", header);
    }
}