package com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import java.util.Map;

public interface EntityHandler<T> {
    void process(T entity, Map<String, String> messageProperties);

    int getEntityKey();
}
