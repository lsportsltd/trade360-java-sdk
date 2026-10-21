package eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers;


import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetDistributionStatusResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StartDistributionResponse;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.DistributionHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.net.URI;


/**
 * Handles Package Distribution
 */
@Component
public class PackageDistributionHandler implements DistributionHandler {
    /** Logger instance for this class. */
    protected static final Logger logger = LogManager.getLogger();
    private URI baseUri;
    private final CustomersApiClientFactory apiClientFactory;
    private PackageCredentials packageCredentials;
    private final long distributionPropagationDelayMs;
    /**
     * Constructs a new PackageDistributionHandler.
     *
     * @param apiClientFactory The factory for creating API clients
     * @param configuration The RabbitMQ connection configuration
     */
    public PackageDistributionHandler(CustomersApiClientFactory apiClientFactory, RabbitConnectionConfiguration configuration) {
        this.apiClientFactory = apiClientFactory;
        this.baseUri = URI.create(configuration.getBaseCustomersApi());
        this.packageCredentials = new PackageCredentials(configuration.getPackageId(), configuration.getUserName(), configuration.getPassword());
        this.distributionPropagationDelayMs = configuration.getDistributionPropagationDelayMs();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void process() throws Exception {
        var client = this.apiClientFactory.createPackageDistributionHttpClient(baseUri, packageCredentials);
        BaseResponse<GetDistributionStatusResponse> statusResponse = client.getDistributionStatus().block();
        if (statusResponse == null || statusResponse.body == null) {
            throw new IllegalStateException("Failed to get distribution status");
        }
        if (statusResponse.body.isDistributionOn) {
            logger.info("Distribution is already started");
            waitForBrokerAccess();
            return;
        }
        BaseResponse<StartDistributionResponse> startResponse = client.startDistribution().block();
        if (startResponse == null || startResponse.body == null) {
            throw new IllegalStateException("Failed to start distribution");
        }
        logger.info("Distribution started");
        waitForBrokerAccess();
    }

    /**
     * Distribution/Start can return 200 before RabbitMQ accepts a PLAIN login.
     * Spring opens its first connection as soon as this method returns.
     */
    private void waitForBrokerAccess() throws InterruptedException {
        if (distributionPropagationDelayMs <= 0) {
            return;
        }
        logger.info("Waiting {} ms for distribution access to propagate before connecting", distributionPropagationDelayMs);
        Thread.sleep(distributionPropagationDelayMs);
    }
}