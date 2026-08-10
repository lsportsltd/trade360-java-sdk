package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

/**
 * Validates RabbitMQ connection configuration before connecting.
 */
public final class RabbitMqConnectionConfigurationValidator {

    /** Minimum network recovery interval in milliseconds (5 seconds; matches .NET floor). */
    static final long MIN_NETWORK_RECOVERY_INTERVAL_MS = 5_000L;

    private RabbitMqConnectionConfigurationValidator() {
    }

    static void validate(RabbitConnectionConfiguration configuration) {
        validateNetworkRecoveryInterval(configuration);
        validateQueueConfiguration(configuration);
    }

    private static void validateNetworkRecoveryInterval(RabbitConnectionConfiguration configuration) {
        long networkRecoveryInterval = configuration.getNetworkRecoveryInterval();
        if (networkRecoveryInterval < MIN_NETWORK_RECOVERY_INTERVAL_MS) {
            throw new IllegalStateException(
                    "network_recovery_interval must be at least "
                            + MIN_NETWORK_RECOVERY_INTERVAL_MS
                            + " milliseconds (5 seconds).");
        }
    }

    private static void validateQueueConfiguration(RabbitConnectionConfiguration configuration) {
        if (configuration.getPackageId() < 0) {
            throw new IllegalStateException("package_id cannot be negative.");
        }

        if (configuration.getPackageId() == 0 && !isNotBlank(configuration.getCustomQueueName())) {
            throw new IllegalStateException(
                    "package_id is required when custom_queue_name is not set, "
                            + "or set custom_queue_name when package_id is omitted.");
        }

        if (isNotBlank(configuration.getCustomQueueName())
                && configuration.getCustomQueueName().trim().length()
                        > RabbitMqConsumeQueueNameResolver.CONSUME_QUEUE_NAME_MAX_LENGTH) {
            throw new IllegalStateException(String.format(
                    "custom_queue_name must be at most %d characters.",
                    RabbitMqConsumeQueueNameResolver.CONSUME_QUEUE_NAME_MAX_LENGTH));
        }

        String queueName = RabbitMqConsumeQueueNameResolver.resolve(configuration);
        if (queueName.isEmpty()) {
            throw new IllegalStateException(
                    "The effective queue name is empty. Check custom_queue_name and package_id.");
        }

        if (queueName.length() > RabbitMqConsumeQueueNameResolver.CONSUME_QUEUE_NAME_MAX_LENGTH) {
            throw new IllegalStateException(String.format(
                    "The effective queue name exceeds %d characters. Shorten custom_queue_name.",
                    RabbitMqConsumeQueueNameResolver.CONSUME_QUEUE_NAME_MAX_LENGTH));
        }
    }

    private static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
