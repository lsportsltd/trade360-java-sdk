package com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface EntityHandling<T> {
    void process(T entity);

    int getEntityKey();
}
