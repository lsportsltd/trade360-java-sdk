package com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

public interface EntityHandler<T> {
    void process(T entity);

    int getEntityKey();
}
