package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

/**
 * Resolves the RabbitMQ queue name to consume from connection settings.
 */
public final class RabbitMqConsumeQueueNameResolver {

    public static final int CONSUME_QUEUE_NAME_MAX_LENGTH = 255;

    private RabbitMqConsumeQueueNameResolver() {
    }

    /**
     * Returns {@code customQueueName} (trimmed) when set, otherwise {@code _{packageId}_} when
     * {@code packageId > 0}, otherwise an empty string.
     */
    public static String resolve(RabbitConnectionConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("configuration is required");
        }

        if (isNotBlank(configuration.getCustomQueueName())) {
            return configuration.getCustomQueueName().trim();
        }

        if (configuration.getPackageId() > 0) {
            return "_" + configuration.getPackageId() + "_";
        }

        return "";
    }

    private static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
