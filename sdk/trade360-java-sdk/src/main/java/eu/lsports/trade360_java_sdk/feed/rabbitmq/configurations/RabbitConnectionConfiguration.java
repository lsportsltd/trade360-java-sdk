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
    private String name;

    /**
     * The ID of the package.
     */
    @NotNull
    private int packageId;

    /**
     * The host of the RabbitMQ server.
     */
    @NotBlank
    private String host = "localhost";

    /**
     * The port of the RabbitMQ server.
     */
    @NotNull
    private int port = 5672;

    /**
     * The virtual host to use.
     */
    @NotBlank
    private String virtualHost = "/";

    /**
     * The username for authentication.
     */
    @NotBlank
    private String userName = "guest";

    /**
     * The password for authentication.
     */
    @NotBlank
    private String password = "guest";

    /**
     * The prefetch count for the connection.
     */
    @NotNull
    private int prefetchCount;

    /**
     * Indicates whether automatic acknowledgment is enabled.
     */
    @NotNull
    private boolean autoAck = true;

    /**
     * The network recovery interval in milliseconds.
     */
    @NotNull
    private long networkRecoveryInterval = 3000;

    /**
     * The base customer api url
     */
    @NotNull
    private String baseCustomersApi;

    /**
     * The number of retry attempts.
     */
    @NotNull
    private int retryAttempts = 3;

    /**
     * The initial interval for retries in milliseconds.
     */
    @NotNull
    private int retryInitialInterval = 1000;

    /**
     * The multiplier for the retry interval.
     */
    @NotNull
    private double retryMultiple = 2;

    /**
     * The maximum interval for retries in milliseconds.
     */
    @NotNull
    private int retryMaxInterval = 5000;

    /**
     * The number of concurrent consumers.
     */
    @NotNull
    private int concurrentConsumers = 1;

    /**
     * The maximum number of concurrent consumers.
     */
    @NotNull
    private int maxConcurrentConsumers = 20;

    /**
     * The name of the Rabbit listener container factory.
     */
    @NotBlank
    private String rabbitListenerContainerFactoryName;

    /**
     * The requested heartbeat interval in seconds.
     */
    @NotNull
    private int requestedHeartBeat = 30;

    public String getName() { return name; }
    public int getPort() { return port; }
    public String getBaseCustomersApi() { return baseCustomersApi; }
    public int getPackageId() { return packageId; }
    public String getUserName() { return userName; }
    public String getPassword() { return password; }
    public String getVirtualHost() { return virtualHost; }
    public String getHost() { return host; }
    public int getRequestedHeartBeat() { return requestedHeartBeat; }
    public int getRetryAttempts() { return retryAttempts; }
    public int getRetryInitialInterval() { return retryInitialInterval; }
    public double getRetryMultiple() { return retryMultiple; }
    public int getRetryMaxInterval() { return retryMaxInterval; }
    public boolean isAutoAck() { return autoAck; }
    public int getConcurrentConsumers() { return concurrentConsumers; }
    public int getMaxConcurrentConsumers() { return maxConcurrentConsumers; }
    public int getPrefetchCount() { return prefetchCount; }
    public long getNetworkRecoveryInterval() { return networkRecoveryInterval; }
    public String getRabbitListenerContainerFactoryName() { return rabbitListenerContainerFactoryName; }

    public void setName(String name) { this.name = name; }
    public void setPackageId(int packageId) { this.packageId = packageId; }
    public void setHost(String host) { this.host = host; }
    public void setPort(int port) { this.port = port; }
    public void setVirtualHost(String virtualHost) { this.virtualHost = virtualHost; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(String password) { this.password = password; }
    public void setPrefetchCount(int prefetchCount) { this.prefetchCount = prefetchCount; }
    public void setAutoAck(boolean autoAck) { this.autoAck = autoAck; }
    public void setNetworkRecoveryInterval(long networkRecoveryInterval) { this.networkRecoveryInterval = networkRecoveryInterval; }
    public void setRetryAttempts(int retryAttempts) { this.retryAttempts = retryAttempts; }
    public void setRetryInitialInterval(int retryInitialInterval) { this.retryInitialInterval = retryInitialInterval; }
    public void setRetryMultiple(double retryMultiple) { this.retryMultiple = retryMultiple; }
    public void setRetryMaxInterval(int retryMaxInterval) { this.retryMaxInterval = retryMaxInterval; }
    public void setBaseCustomersApi(String baseCustomersApi) { this.baseCustomersApi = baseCustomersApi; }
    public void setConcurrentConsumers(int concurrentConsumers) { this.concurrentConsumers = concurrentConsumers; }
    public void setMaxConcurrentConsumers(int maxConcurrentConsumers) { this.maxConcurrentConsumers = maxConcurrentConsumers; }
    public void setRabbitListenerContainerFactoryName(String rabbitListenerContainerFactoryName) { this.rabbitListenerContainerFactoryName = rabbitListenerContainerFactoryName; }
    public void setRequestedHeartBeat(int requestedHeartBeat) { this.requestedHeartBeat = requestedHeartBeat; }
}