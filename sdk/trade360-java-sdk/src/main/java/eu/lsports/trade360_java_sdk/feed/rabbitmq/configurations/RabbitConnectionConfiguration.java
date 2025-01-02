package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * Configuration properties for RabbitMQ connection.
 */
@Validated
@Data
public class RabbitConnectionConfiguration {

    /**
     * The name of the connection.
     */
    public String name;

    /**
     * The ID of the package.
     */
    @NotNull
    public int package_id;

    /**
     * The host of the RabbitMQ server.
     */
    @NotBlank
    public String host = "localhost";

    /**
     * The port of the RabbitMQ server.
     */
    @NotNull
    public int port = 5672;

    /**
     * The virtual host to use.
     */
    @NotBlank
    public String virtual_host = "/";

    /**
     * The username for authentication.
     */
    @NotBlank
    public String user_name = "guest";

    /**
     * The password for authentication.
     */
    @NotBlank
    public String password = "guest";

    /**
     * The prefetch count for the connection.
     */
    @NotNull
    public int prefetch_count;

    /**
     * Indicates whether automatic acknowledgment is enabled.
     */
    @NotNull
    public boolean auto_ack = true;

    /**
     * The network recovery interval in milliseconds.
     */
    @NotNull
    public long network_recovery_interval = 3000;

    /**
     * The number of retry attempts.
     */
    @NotNull
    public int retry_attempts = 3;

    /**
     * The initial interval for retries in milliseconds.
     */
    @NotNull
    public int retry_initial_interval = 1000;

    /**
     * The multiplier for the retry interval.
     */
    @NotNull
    public double retry_multiple = 2;

    /**
     * The maximum interval for retries in milliseconds.
     */
    @NotNull
    public int retry_max_interval = 5000;

    /**
     * The number of concurrent consumers.
     */
    @NotNull
    public int concurrent_consumers = 1;

    /**
     * The maximum number of concurrent consumers.
     */
    @NotNull
    public int max_concurrent_consumers = 20;

    /**
     * The name of the Rabbit listener container factory.
     */
    @NotBlank
    public String rabbit_listener_container_factory_name;

    /**
     * The requested heartbeat interval in seconds.
     */
    @NotNull
    public int requestedHeartBeat = 30;
}