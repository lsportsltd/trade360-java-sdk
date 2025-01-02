package eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

/**
 * Represents an entity with a unique key.
 */
public interface Entity {
    /**
     * Gets the unique key of the entity.
     *
     * @return The unique key
     */
    int getEntityKey();
}