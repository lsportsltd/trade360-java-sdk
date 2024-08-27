package com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import org.jetbrains.annotations.NotNull;

public interface EntityRegister {
    public void registerEntityHandler(@NotNull EntityHandler entityHandler) throws RabbitMQFeedException;
}
