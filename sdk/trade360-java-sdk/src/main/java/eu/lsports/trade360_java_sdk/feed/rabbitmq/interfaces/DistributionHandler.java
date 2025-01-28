package eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces;

import eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import org.springframework.stereotype.Component;

/**
 * Interface for handling Package Distribution
 */
@Component
public interface DistributionHandler {

    /**
     * Processes the package distribution
     *
     * @throws Exception if an error occurs during processing
     */
    void process() throws Exception;
}