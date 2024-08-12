package com.lsports.trade360feedexample;

import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.BodyHandling;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class RabbitMQFeed {

    private final BodyHandling bodyHandling;

    public RabbitMQFeed(BodyHandling bodyHandling) {
        this.bodyHandling = bodyHandling;
    }

    @RabbitListener(queues = "_${rabbitmq.inplay.package_id}_")
    public void processMessage(final Message message) throws Exception {

        bodyHandling.Process(message);
    }
}

