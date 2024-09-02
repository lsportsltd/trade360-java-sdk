# LSports Trade360 SDK

## Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
    - [Pre-requisites](#pre_requisites)
    - [Supported JDK Versions](#supported_versions)
    - [Installing](#installing)
    - [Initial Configuration](#configuration)
- [Usage Guide](#usage_guide)
  - [Connecting to Trade360 Feed](#usage_guide_feed)
  - [Using the Snapshot API](#usage_snapshot_api)
  - [Using Customers API](#usage_customers_api)
- [Contribution](#contributing)
- [License](#license)

## About <a name = "about"></a>

The Trade360 SDK is designed to simplify the integration with Trade360 services. This SDK provides a comprehensive set of tools and examples to streamline the following tasks:

- Connecting to the Trade360 feed
- Utilizing the Snapshot API
- Interacting with the Customers API

By using this SDK, developers can easily integrate and interact with Trade360's services, ensuring efficient and effective use of the available APIs.

### Key Features
- Efficiently connect and interact with the Trade360 feed, featuring automatic recovery through configuration and seamless start/stop distribution aligned with service operations.
- Utilize the Snapshot API for real-time recovery, with an easy-to-use HTTP client exposing all relevant endpoints, including comprehensive request and response handling.
- Manage customer data and subscriptions seamlessly via the Customers API, offering an intuitive HTTP client that covers all necessary endpoints for efficient data management.

## Getting Started <a name="getting_started"></a>

This section provides examples and guidance to help you start using the Trade360 SDK.

### Prerequisites <a name = "pre_requisites"></a>

Ensure you have the following installed on your machine:

- [[JAVA OpenJDK 1.7 Linux x64]](https://jdk.java.net/java-se-ri/17-MR1) 
- [[Maven 3.9.8]](https://maven.apache.org/download.cgi)
- 
This SDK targets JDK in version 17.

## Installing <a name = "installing"></a>

A step-by-step series of instructions to set up your development environment.

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/trade360sdk-feed-example.git
    cd trade360sdk-feed-example
    ```

2. **Restore dependencies:**

    ```bash
    mvn -U clean install
    ```

3. **Run the project:**

    ```bash
    mvn spring-boot:run
    ```

## Usage Guide <a name = "usage_guide"></a>

### Connecting to Trade360 Feed <a name = "usage_guide_feed"></a>

This is an example usage of the feed SDK, which gives you the ability to create an instance and connect to your RabbitMQ feed. You can create a handler to deal with each type of message being produced (fixture, livescore, markets, settlement) for standard sports, outright sports, and outright league sports (tournaments). Please download the repo and run the examples for more information.

#### Example Configuration (`application.properties`)

```yaml
spring.application.name:trade360-feed-example

rabbitmq.inplay.name: inplay
rabbitmq.inplay.rabbit_listener_container_factory_name: inplaySimpleRabbitListenerContainerFactory
rabbitmq.inplay.package_id: 99
rabbitmq.inplay.host: localhost
rabbitmq.inplay.port: 5672
rabbitmq.inplay.virtual_host: /
rabbitmq.inplay.user_name: guest
rabbitmq.inplay.password: guest
rabbitmq.inplay.prefetch_count: 100
rabbitmq.inplay.auto_ack: false
rabbitmq.inplay.requested_heartbeat_seconds: 30
rabbitmq.inplay.network_recovery_interval: 30
rabbitmq.inplay.base_customers_api: https://stm-api.lsports.eu
rabbitmq.inplay.retry_attempts: 3
rabbitmq.inplay.retry_initial_interval: 1000
rabbitmq.inplay.retry_multiple: 2
rabbitmq.inplay.retry_max_interval: 5000
rabbitmq.inplay.concurrent_consumers: 1
rabbitmq.inplay.max_concurrent_consumers: 1
```



#### Implementing The Connection

To create a connection it is necessary to use the 'DynamicBeanDefinitionRegistrarConfiguration' configuration class.
This class reads the connection parameters from the application properties based on defined prefixes.

```java
// Configuration class for dynamic register Rabbit Connection based on application properties
@Configuration
public class DynamicBeanDefinitionRegistrarConfiguration {
    // Configure the settings for the "Inplay" feed using the "rabbitmq.inplay" section of the configuration file
    public static final String RABBITMQ_INPLAY_PREFIX = "rabbitmq.inplay";
    // Configure the settings for the "Prematch" feed using the "rabbitmq.prematch" section of the configuration file
    public static final String RABBITMQ_PREMATCH_PREFIX = "rabbitmq.prematch";

    @Bean
    public static DynamicRabbitMQDefinitionRegistrar beanDefinitionRegistrar(Environment environment) {
        return new DynamicRabbitMQDefinitionRegistrar(environment, Arrays.asList(RABBITMQ_INPLAY_PREFIX,RABBITMQ_PREMATCH_PREFIX));
    }
}
```

Above code register connections configuration for two prefixes 'rabbitmq.inplay' and "rabbitmq.prematch"

Next, it is necessary to add listener methods for the above connections. Each @RabbitListener annotation has an association between the Rabbit Connection Factory and that method by the bean name written in the containerFactory annotation properties.

```java
@RabbitListener(containerFactory = "${rabbitmq.inplay.rabbit_listener_container_factory_name}", queues = "_${rabbitmq.inplay.package_id}_", errorHandler="${rabbitmq.inplay.name}.ErrorMessageHandler")
public void inPlayProcessMessage(final Message amqpMessage, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
    inPlayMessageHandler.process(amqpMessage);

    if (!inPlayRabbitConnectionConfiguration.auto_ack)
        channel.basicAck(tag, false);
}

@RabbitListener(containerFactory = "${rabbitmq.prematch.rabbit_listener_container_factory_name}", queues = "_${rabbitmq.prematch.package_id}_", errorHandler="${rabbitmq.inplay.name}.ErrorMessageHandler")
public void preMatchProcessMessage(final Message message, Channel channel,
                                   @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
    preMatchMessageHandler.process(message);

    if (!preMatchRabbitConnectionConfiguration.auto_ack)
        channel.basicAck(tag, false);
}
```
Add handlers for each type of message**:
```java
    //Register entity handlers for inPlay
    @Bean
    public EntityRegistry inPlayEentityRegister() throws RabbitMQFeedException {
    EntityRegistry entityRegistry = new EntityRegistry();
    entityRegistry.setEntityHandler(new FixtureMarketUpdateHandlerInplay());
    entityRegistry.setEntityHandler(new LivescoreUpdateHandlerInplay());
    entityRegistry.setEntityHandler(new HeartbeatHandlerInplay());
    entityRegistry.setEntityHandler(new FixtureMetadataUpdateHandlerInplay());
    return entityRegistry;
    }
```

Connection will be established right after application start. 

#### Message recover in case of failure

In order to handle message recover it is a need to  implements 'MessageRecoverer' interface. Spring [documentation](https://docs.spring.io/spring-amqp/api/org/springframework/amqp/rabbit/retry/RepublishMessageRecoverer.html)

#### Message exception handling in case of failure

In order to handle message excpetion it is a need to  implements 'RabbitListenerErrorHandler' interface. Spring [documentation](https://docs.spring.io/spring-amqp/docs/current/api/org/springframework/amqp/rabbit/listener/api/RabbitListenerErrorHandler.html)


## Contributing <a name = "contributing"></a>

Please read [CONTRIBUTING.md](../CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License <a name = "license"></a>

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Release: https://github.com/lsportsltd/trade360-dotnet-sdk/releases/tag/v1.0.0
