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
import reactor.core.publisher.Mono;

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
    /**
     * Constructs a new PackageDistributionHandler.
     *
     * @param apiClientFactory The factory for creating API clients
     * @param configuration The RabbitMQ connection configuration
     */
    public PackageDistributionHandler(CustomersApiClientFactory apiClientFactory, RabbitConnectionConfiguration configuration) {
        this.apiClientFactory = apiClientFactory;
        this.baseUri = URI.create(configuration.getBase_customers_api());
        this.packageCredentials = new PackageCredentials(configuration.getPackage_id(), configuration.getUser_name(), configuration.getPassword());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void process() throws Exception {
        var client = this.apiClientFactory.createPackageDistributionHttpClient(baseUri, packageCredentials);
        Mono<BaseResponse<GetDistributionStatusResponse>> response = client.getDistributionStatus();
        if(response.block() == null || response.block().body == null) {
            throw new IllegalStateException("Failed to get distribution status");
        }
        else{
            if(response.block().body.isDistributionOn)
            {
                logger.info("Distribution is already started");
            }
            else {
                Mono<BaseResponse<StartDistributionResponse>> startResponse = client.startDistribution();
                if (startResponse.block() == null || startResponse.block().body == null) {
                    throw new IllegalStateException("Failed to start distribution");
                } else {
                    logger.info("Distribution started");
                }
            }
        }
    }
}