package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * Configuration properties for RabbitMQ connection.
 */
@Validated
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
     * The base customer api url
     */
    @NotNull
    public String base_customers_api;

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

    // --- Added getters for use in handlers ---
    public String getBaseCustomersApi() {
        return base_customers_api;
    }
    public int getPackageId() {
        return package_id;
    }
    public String getUserName() {
        return user_name;
    }
    public String getPassword() {
        return password;
    }

    // --- Added setters for use in tests ---
    public void setName(String name) { this.name = name; }
    public void setPackageId(int package_id) { this.package_id = package_id; }
    public void setHost(String host) { this.host = host; }
    public void setPort(int port) { this.port = port; }
    public void setVirtualHost(String virtual_host) { this.virtual_host = virtual_host; }
    public void setUserName(String user_name) { this.user_name = user_name; }
    public void setPassword(String password) { this.password = password; }
    public void setPrefetchCount(int prefetch_count) { this.prefetch_count = prefetch_count; }
    public void setAutoAck(boolean auto_ack) { this.auto_ack = auto_ack; }
    public void setNetwork_recovery_interval(long network_recovery_interval) { this.network_recovery_interval = network_recovery_interval; }
    public void setBase_customers_api(String base_customers_api) { this.base_customers_api = base_customers_api; }
    public void setRetryAttempts(int retry_attempts) { this.retry_attempts = retry_attempts; }
    public void setRetryInitialInterval(int retry_initial_interval) { this.retry_initial_interval = retry_initial_interval; }
    public void setRetryMultiple(double retry_multiple) { this.retry_multiple = retry_multiple; }
    public void setRetry_max_interval(int retry_max_interval) { this.retry_max_interval = retry_max_interval; }
    public void setConcurrent_consumers(int concurrent_consumers) { this.concurrent_consumers = concurrent_consumers; }
    public void setMaxConcurrentConsumers(int max_concurrent_consumers) { this.max_concurrent_consumers = max_concurrent_consumers; }
    public void setRabbitListenerContainerFactoryName(String rabbit_listener_container_factory_name) { this.rabbit_listener_container_factory_name = rabbit_listener_container_factory_name; }
    public void setRequestedHeartBeat(int requestedHeartBeat) { this.requestedHeartBeat = requestedHeartBeat; }
}