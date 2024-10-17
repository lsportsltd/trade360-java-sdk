package com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import org.jetbrains.annotations.NotNull;

/**
 * Interface for registering entity handlers.
 */
public interface EntityRegister {

    /**
     * Registers the entity handler.
     *
     * @param entityHandler The entity handler to register
     * @throws RabbitMQFeedException if the entity handler already exists
     */
    public void setEntityHandler(@NotNull EntityHandler entityHandler) throws RabbitMQFeedException;
}