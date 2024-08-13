package com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.LivescoreUpdate;
import org.springframework.stereotype.Component;

@Component
public interface EntityHandling<T> {
    void Process(T entity);

    int GetEntityKey();
}
