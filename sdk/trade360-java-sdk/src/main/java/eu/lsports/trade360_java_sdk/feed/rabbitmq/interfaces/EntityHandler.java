package eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import java.util.Map;

/**
 * Handles entities of a specific type.
 *
 * @param <T> The type of the entity
 */
public interface EntityHandler<T> {

    /**
     * Processes the given entity with the provided message properties.
     *
     * @param entity The entity to process
     * @param messageHeaders The headers of the message
     * @param transportMessageHeaders The headers of the transport message
     */
    void process(T entity, Map<String, String> messageHeaders, Map<String, String> transportMessageHeaders);

    /**
     * Returns the key of the handled entity.
     *
     * @return The unique key
     */
    int getEntityKey();
}