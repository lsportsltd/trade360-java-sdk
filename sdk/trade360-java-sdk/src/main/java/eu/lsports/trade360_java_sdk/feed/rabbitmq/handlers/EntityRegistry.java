package eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityRegister;
import org.jetbrains.annotations.NotNull;
import java.text.MessageFormat;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Registry for managing entity handlers.
 */
public class EntityRegistry implements EntityRegister {
    private final ConcurrentHashMap<Integer, EntityHandler> entityMap = new ConcurrentHashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEntityHandler(@NotNull EntityHandler entityHandler) throws RabbitMQFeedException {
        if (entityMap.containsKey(entityHandler.getEntityKey())) {
            throw new RabbitMQFeedException(
                    MessageFormat.format("Provided EntityHandler already exists! - {0} - {1}",
                            entityHandler.getEntityKey(),
                            entityHandler.getClass().toString()
                    ));
        } else {
            entityMap.put(entityHandler.getEntityKey(), entityHandler);
        }
    }

    /**
     * Gets the entity handler by type ID.
     *
     * @param typeId The type ID of the entity
     * @return The entity handler
     */
    public EntityHandler getEntityByTypeId(int typeId) {
        return entityMap.get(typeId);
    }
}