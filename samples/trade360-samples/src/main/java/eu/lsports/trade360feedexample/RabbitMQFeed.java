package eu.lsports.trade360feedexample;

import eu.lsports.trade360_customer_api_example.configuration.CustomerApiConfiguration;
import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.common.entities.enums.ProviderOddsType;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetProviderOddsTypeResponse;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.PackageQueryApiClient;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.MessageHandler;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@EnableConfigurationProperties(CustomerApiConfiguration.class)
public class RabbitMQFeed {
    private final CustomersApiClientFactory apiClientFactory;
    private final MessageHandler inPlayMessageHandler;
    private final MessageHandler preMatchMessageHandler;
    private final RabbitConnectionConfiguration inPlayRabbitConnectionConfiguration;
    private final RabbitConnectionConfiguration preMatchRabbitConnectionConfiguration;
    @Autowired
    private CustomerApiConfiguration customerApiConfiguration;

    public RabbitMQFeed(@Qualifier("inPlayMessageHandler") MessageHandler inPlayMessageHandler,
                        @Qualifier("preMatchMessageHandler") MessageHandler preMatchMessageHandler,
                        @Qualifier("inPlayRabbitConnectionConfiguration") RabbitConnectionConfiguration inPlayRabbitConnectionConfiguration,
                        @Qualifier("preMatchRabbitConnectionConfiguration") RabbitConnectionConfiguration preMatchRabbitConnectionConfiguration,
                        CustomersApiClientFactory factory) {
        this.inPlayMessageHandler = inPlayMessageHandler;
        this.preMatchMessageHandler = preMatchMessageHandler;
        this.inPlayRabbitConnectionConfiguration = inPlayRabbitConnectionConfiguration;
        this.preMatchRabbitConnectionConfiguration = preMatchRabbitConnectionConfiguration;
        this.apiClientFactory = factory;
    }

    // General notes:
    // Application can work with one, two or more connection to RabbitMQ (Inplay, Prematch).
    // In order to remove one of connection nit is need to
    // - remove appropriate RabbitListener handler
    // - remove connection prefix definition from DynamicBeanDefinitionRegistrarConfiguration

    // Inplay message handler method.
    // Important notes:
    // - The association between Inplay Rabbit connection factory and this method is made by bean name written in containerFactory annotation properties. Name defined in application properties
   // - Name of queue is taken fom application properties
    // - Error handler is set by errorHandler annotation properties
    @RabbitListener(containerFactory = "${rabbitmq.inplay.rabbit_listener_container_factory_name}",  queues = "_${rabbitmq.inplay.package_id}_", errorHandler="inplayErrorMessageHandler")
    public void inPlayProcessMessage(final Message amqpMessage, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        ProviderOddsType providerOddsType = getInPlayProvideOddType(customerApiConfiguration.base_customers_api, customerApiConfiguration.inplay.package_id, customerApiConfiguration.inplay.user_name, customerApiConfiguration.inplay.password);
        inPlayMessageHandler.process(amqpMessage, providerOddsType);

        //in case of manual ACK  - auto_ack:false
        //   channel.basicAck(tag, false);
    }

    // Prematch message handler method.
    // Important notes:
    // - The association between Prematch Rabbit connection factory and this method is made by bean name written in containerFactory annotation properties. Name defined in application properties
    // - Name of queue is taken fom application properties
    // - Error handler is set by errorHandler annotation properties
    @RabbitListener(containerFactory = "${rabbitmq.prematch.rabbit_listener_container_factory_name}", queues = "_${rabbitmq.prematch.package_id}_", errorHandler="prematchErrorMessageHandler")
    public void preMatchProcessMessage(final Message message, Channel channel,
                                       @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        ProviderOddsType providerOddsType = getInPlayProvideOddType(customerApiConfiguration.base_customers_api, customerApiConfiguration.prematch.package_id, customerApiConfiguration.prematch.user_name, customerApiConfiguration.prematch.password);
        preMatchMessageHandler.process(message, providerOddsType);

        //in case of manual ACK  - auto_ack:false
        //  channel.basicAck(tag, false);
    }

    private ProviderOddsType getInPlayProvideOddType(String url, Integer packageId, String userName, String password) {
        URI baseUri = URI.create(url);
        PackageCredentials packageCredentials = new PackageCredentials(packageId,userName,password);
        try {
            PackageQueryApiClient client = apiClientFactory.createPackageQueryApiHttpClient(baseUri, packageCredentials);
            Mono<BaseResponse<GetProviderOddsTypeResponse>> response = client.getProviderOddsType();
            if(response.block() == null || response.block().body == null) {
                throw new RuntimeException("Failed to get provider odds type");
            }
            return response.block().body.providerOddsType;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


