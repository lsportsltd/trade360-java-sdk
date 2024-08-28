package com.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityRegister;
import org.jetbrains.annotations.NotNull;
import java.text.MessageFormat;
import java.util.concurrent.ConcurrentHashMap;

public class EntityRegistry implements EntityRegister {
    private final ConcurrentHashMap<Integer, EntityHandler> entityMap = new ConcurrentHashMap<>();

    public void setEntityHandler(@NotNull EntityHandler entityHandler) throws RabbitMQFeedException {

        if ( entityMap.containsKey(entityHandler.getEntityKey()))
            throw new RabbitMQFeedException(MessageFormat.format("Provided EntityHandler already exists! - {0} - {1}", entityHandler.getEntityKey(), entityHandler.getClass().toString() ));
        else
            entityMap.put(entityHandler.getEntityKey(), entityHandler);
    }

    public EntityHandler getEntityByTypeId(int typeId)
    {
        return entityMap.get(typeId);
    }
}
