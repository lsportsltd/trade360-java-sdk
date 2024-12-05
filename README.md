# LSports Trade360 SDK <!-- omit from toc -->

## Table of Contents <!-- omit from toc -->

- [About](#about)
  - [Key Features](#key-features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
- [Installing](#installing)
- [Usage Guide](#usage-guide)
  - [Connecting to Trade360 Feed](#connecting-to-trade360-feed)
    - [Example Configuration (`application.properties`)](#example-configuration-applicationproperties)
    - [Message recover in case of failure](#message-recover-in-case-of-failure)
    - [Message exception handling in case of failure](#message-exception-handling-in-case-of-failure)
  - [Using Snapshot API](#using-snapshot-api)
    - [Example Configuration (`application.properties`)](#snapshot-api-example-configuration-applicationproperties)
    - [Handling responses](#snapshot-api-handling-responses)
    - [Error handling](#snapshot-api-error-handling)
  - [Using Customers API](#using-customers-api)
    - [Example Configuration (`application.properties`)](#customers-api-example-configuration-applicationproperties)
    - [Handling responses](#customers-api-handling-responses)
    - [Error handling](#customers-api-error-handling)
- [Links](#links)
- [Contributing](#contributing)
- [License](#license)
- [Release](#release)

## About

The Trade360 SDK is designed to simplify the integration with Trade360 services. This SDK provides a comprehensive set of tools and examples to streamline the following tasks:

- Connecting to the Trade360 feed
- Utilizing the Snapshot API
- Interacting with the Customers API

By using this SDK, developers can easily integrate and interact with Trade360's services, ensuring efficient and effective use of the available APIs.

### Key Features
- Efficiently connect and interact with the Trade360 feed, featuring automatic recovery through configuration and seamless start/stop distribution aligned with service operations.
- Utilize the Snapshot API for real-time recovery, with an easy-to-use HTTP client exposing all relevant endpoints, including comprehensive request and response handling.
- Manage customer data and subscriptions seamlessly via the Customers API, offering an intuitive HTTP client that covers all necessary endpoints for efficient data management.

## Getting Started

This section provides examples and guidance to help you start using the Trade360 SDK.

### Prerequisites

Ensure you have the following installed on your machine:

- JDK 17, e.g.:
  - [Reference JAVA OpenJDK 17](https://jdk.java.net/java-se-ri/17-MR1)
  - [Adoptium Java SDK 17](https://adoptium.net/temurin/releases/?version=17)
- [Maven 3.9.8](https://maven.apache.org/download.cgi)

This SDK targets JDK in version 17.

## Installing

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

## Usage Guide

### Connecting to Trade360 Feed

This is an example usage of the feed SDK, which gives you the ability to create an instance and connect to your RabbitMQ feed. You can create a handler to deal with each type of message being produced (fixture, livescore, markets, settlement) for standard sports, outright sports, and outright league sports (tournaments). Please download the repo and run the examples for more information.

#### Example Configuration (`application.properties`)

```yaml
spring.application.name:trade360-feed-example

rabbitmq.inplay.name: inplay
rabbitmq.inplay.rabbit_listener_container_factory_name: inPlaySimpleRabbitListenerContainerFactory
rabbitmq.inplay.package_id: your-packageid
rabbitmq.inplay.host: trade360-inplay-rabbitmq-host
rabbitmq.inplay.port: trade360-inplay-rabbitmq-port
rabbitmq.inplay.virtual_host: trade360-inplay-rabbitmq-virtual-host
rabbitmq.inplay.user_name: your-username
rabbitmq.inplay.password: your-password
rabbitmq.inplay.prefetch_count: 100
rabbitmq.inplay.auto_ack: true
rabbitmq.inplay.requested_heartbeat_seconds: 30
rabbitmq.inplay.network_recovery_interval: 30
rabbitmq.inplay.retry_attempts: 3
rabbitmq.inplay.retry_initial_interval: 1000
rabbitmq.inplay.retry_multiple: 2
rabbitmq.inplay.retry_max_interval: 5000
rabbitmq.inplay.concurrent_consumers: 1
rabbitmq.inplay.max_concurrent_consumers: 1
```
name - name for a RabbitMQ connection 
rabbit_listener_container_factory_name - name of the RabbitMQ listener container factory
package_id - LSports package id/used to create RabbitMQ queue name
host - RabbitMQ host 
port - RabbitMQ port
virtual_host - RabbitMQ virtual host
user_name - RabbitMQ user name
password - RabbitMQ password
prefetch_count - RabbitMQ prefetch count
auto_ack - RabbitMQ auto ack message flag
requested_heartbeat_seconds - RabbitMQ requested heartbeat seconds
network_recovery_interval - RabbitMQ network recovery interval
retry_attempts - RabbitMQ retry attempts
retry_initial_interval - RabbitMQ retry initial interval
retry_multiple - RabbitMQ retry multiple
retry_max_interval - RabbitMQ retry max interval
concurrent_consumers - RabbitMQ concurrent consumers (prefered 1)
max_concurrent_consumers - RabbitMQ max concurrent consumers (prefered 1)



```yaml
#### Implementing the connection

Full working example of using Trade360 Feed in Spring Framework can be found in this sample application.

To create a connection it is necessary to use the `InplayTrade360SdkConfiguration` or/and `PrematchTrade360SdkConfiguration` configuration class.
This class reads the connection parameters from the application properties based on defined prefixes.

```java
// Configuration class for Rabbit Connection
@Configuration
public class InplayTrade360SdkConfiguration {
    // Configure the settings for the "Inplay" feed using the "rabbitmq.inplay" section of the configuration file
    public static final String RABBITMQ_INPLAY_PREFIX = "rabbitmq.inplay";
    ...


// Configuration class Rabbit Connection
@Configuration
public class PrematchTrade360SdkConfiguration {
     // Configure the settings for the "Prematch" feed using the "rabbitmq.prematch" section of the configuration file
     public static final String RABBITMQ_PREMATCH_PREFIX = "rabbitmq.prematch";
        ...
```

Above code register connections configuration for two prefixes `rabbitmq.inplay` and `rabbitmq.prematch`

Next step is add listener handler methods for the above connections. Each `@RabbitListener` annotation has an association between the Rabbit Connection Factory and that listener method by the bean name written in the containerFactory annotation properties.
Second parameter is queue and third name of error message handling implementation defined in `Trade360SdkConfiguration` class. 
```java

@RabbitListener(containerFactory = "${rabbitmq.inplay.rabbit_listener_container_factory_name}", queues = "_${rabbitmq.inplay.package_id}_", errorHandler="inplayErrorMessageHandler")
public void inPlayProcessMessage(final Message amqpMessage, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
    inPlayMessageHandler.process(amqpMessage);

    //in case of manual ACK  - auto_ack:false
    //   channel.basicAck(tag, false);
}

@RabbitListener(containerFactory = "${rabbitmq.prematch.rabbit_listener_container_factory_name}", queues = "_${rabbitmq.prematch.package_id}_", errorHandler="prematchErrorMessageHandler")
public void preMatchProcessMessage(final Message message, Channel channel,
                                   @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
    preMatchMessageHandler.process(message);

    //in case of manual ACK  - auto_ack:false
    //  channel.basicAck(tag, false);
}
```
Next step is to register handlers for each type of message separately for InPlay and PreMatch:
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

    //Register entity handlers for preMatch
    @Bean
    public EntityRegistry preMachEentityRegister() throws RabbitMQFeedException {
        EntityRegistry entityRegistry = new EntityRegistry();
        entityRegistry.setEntityHandler(new FixtureMarketUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new FixtureMetadataUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new HeartbeatHandlerPrematch());
        entityRegistry.setEntityHandler(new KeepAliveUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new LivescoreUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightFixtureMarketUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightFixtureUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightLeagueMarketsUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightLeagueUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightScoreUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new OutrightSettlementsUpdateHandlerPrematch());
        entityRegistry.setEntityHandler(new SettlementUpdateHandlerPrematch());
        return entityRegistry;
    }
```

Connection will be established right after application start. 

#### Message recover in case of failure

In order to handle message recover it is a need to  implements `MessageRecoverer` interface ([Spring documentation](https://docs.spring.io/spring-amqp/api/org/springframework/amqp/rabbit/retry/RepublishMessageRecoverer.html)).

Example:
```java
package com.lsports.trade360feedexample.handlers.inplay.errors;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;

import java.text.MessageFormat;

public class InplayRecoveryMessageResolver implements MessageRecoverer {
    @Override
    public void recover(Message message, Throwable cause) {

        // Printout error message after policy retry fulfilment
        System.out.print(MessageFormat.format("Unable to process message due to {0} message: {1}", cause.getMessage(), message));

        // Further message handling can be added here, e.g. send to DLQ
    }
}
```
#### Message exception handling in case of failure

In order to handle message exception it is a need to implement `RabbitListenerErrorHandler` interface ([Spring documentation](https://docs.spring.io/spring-amqp/docs/current/api/org/springframework/amqp/rabbit/listener/api/RabbitListenerErrorHandler.html)).

Example:
```java
package com.lsports.trade360feedexample.handlers.inplay.errors;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;

import java.text.MessageFormat;

@SuppressWarnings("removal")
public class InplayErrorMessageHandler implements RabbitListenerErrorHandler {

    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException exception) throws Exception {
        return null;
    }

    @Override
    public Object handleError(Message amqpMessage, Channel channel, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException exception) throws Exception {

        String connectionName = channel.getConnection().getAddress().toString();

        // Printout error message after error
        System.out.println(MessageFormat.format("{0}: Unable to process message amqpMessage header: {1}", connectionName, amqpMessage.getMessageProperties().toString()));
        System.out.println(MessageFormat.format("{0}: Unable to process due to exception cause: {1} ", connectionName, exception.getCause()));
        System.out.println(MessageFormat.format("{0}: message: {1} ", connectionName, message.getPayload()));

        // Further message handling can be added here, e.g. send to DLQ

        return RabbitListenerErrorHandler.super.handleError(amqpMessage, channel, message, exception);
    }
}

```

### Using Snapshot API

Full working example of using Snapshot API SDK in Spring Framework, which provides an easy way to interact with the Snapshot API for recovery purposes. The SDK offers a simplified HTTP client with request and response handling.

It can be found in this [sample application](/samples/trade360-samples/src/main/java/com/lsports/trade360_snapshot_api_example/SnapshotApiExampleApplication.java).

#### Snapshot API Example Configuration (`application.properties`)

```yaml
snapshotapi.base_snapshot_api:https://stm-snapshot.lsports.eu
snapshotapi.inplay.package_id:430
snapshotapi.inplay.user_name:<username>
snapshotapi.inplay.password:<password>
snapshotapi.prematch.package_id:431
snapshotapi.prematch.user_name:<username>
snapshotapi.prematch.password:<password>
```
After setting the correct configuration, add the following:
In order to create a client instance a `SnapshotApiClientFactory` interface instance is necessary. You can obtain one by using one of provided implementation. 

Available `SnapshotApiClientFactory` implementations:

- `SpringBootSnapshotApiClientFactory` - an implementation comptatible with Spring Framework, as it uses flux `WebClient`.

In case you use `SpringBootSnapshotApiClientFactory` the good practice is to register it as a `@Bean` and fetch it via dependency injection where necessary. Below you can find an example of proper registration of the factory.

```java
@Bean
public SnapshotApiClientFactory configureSnapshotApiClientFactory(WebClient.Builder webClientBuilder) {
    return new SpringBootSnapshotApiClientFactory(webClientBuilder);
}
```

Later, you can inject the factory e.g. via the constructor:
```java
private final SnapshotApiClientFactory apiClientFactory;

public SnapshotApiExampleApplication(SnapshotApiClientFactory factory) {
    apiClientFactory = factory;
}
```

After factory is obtained, it can be used to create actual API Client instances. When creating an instance, proper settings will be loaded from application.properties file. 

Having the configured client instance one can use it by invoking requests with proper parameters. The documentation for each request can be found [here](https://docs.lsports.eu/lsports/v/integration/apis/snapshot) - bear in mind that you do not need to provide auth parameters each time as the SDK does it for you.

#### Snapshot API Handling responses

The client is written in reactive approach using [Reactor](https://projectreactor.io/) library. Each operation returns `Mono<T>` instance being an observable eventually returning response in case of success, or an error in case of failure. You can use the `Mono<T>` object in any way you want according to your needs, you can learn more what you can do with it in the Reactor library documentation linked above.

Below you can find primary approach how you can handle responses.
Asynchronous method - this is the recommended approach to the high load and throughput scenarios as this prioritizes throughput and minimizes risk of bottlenecks.
```java
    this.executeAsynchronous("PreMatch Async Get Fixtures",
        new GetFixtureRequest(.....),
        preMatchClient::getFixtures);
```

#### Snapshot API Error handling

Error handling depends on which approach is used – synchronous or asynchronous:
 For asynchronous method a standard approach for reactive paradigm should be used. If error occurs during request processing a `Trade360Exception` exception is emitted to `Mono<T>`. The excessive description how to handle errors in Reactor can be found [here](https://projectreactor.io/docs/core/release/reference/index.html#error.handling). Below you can find one of the most basic approach to handle errors:
```java
    exception -> {
        System.err.println("[" + newExampleName + "] - Failed: " + exception.getMessage());
        if (exception instanceof Trade360Exception) {
            var trade360Exception = (Trade360Exception) exception;
            System.out.println("[" + newExampleName + "] - Errors:");
            trade360Exception.getErrors().forEach(error -> System.out.println("[" + newExampleName + "]\t- " + error));
            System.out.flush();}
        }
```

The `Trade360Exception` class does contain a detailed message which may help identify the root cause of the issue. To obtain the message call `getMessage()` method. Also sometimes additional detailed errors can be obtained using `getErrors()` method.

Below you can find an example how an exception may look like. In this case it means incorrect credentials have been provided.
![Trade360Exception example](/docs/static/trade360exception_example.png)



### Using Customers API

The Customers API SDK is made up of three parts: Package Distribution, Metadata, and Subscription. It provides a simplified HTTP client with request and response handling for various operations.

Package Distribution: Start, stop, and get distribution status.
Metadata: Exposes endpoints to get leagues, sports, locations, markets, and translations.
Subscription: Allows subscribing and unsubscribing to a fixture or by league. It also includes manual suspension actions and quota retrieval.

It can be found in this [sample application](/samples/trade360-samples/src/main/java/com/lsports/trade360_customer_api_example/CustomerApiExampleApplication.java).

#### Customers API Example Configuration (`application.properties`)

```yaml
customersapi.base_customers_api:https://stm-api.lsports.eu
customersapi.inplay.package_id:430
customersapi.inplay.user_name:<username>
customersapi.inplay.password:<password>
customersapi.prematch.package_id:431
customersapi.prematch.user_name:<username>
customersapi.prematch.password:<password>
```
After setting the correct configuration, add the following:
In order to create a client instance a `CustomersApiClientFactory` interface instance is necessary. You can obtain one by using one of provided implementation.

Available `CustomersApiClientFactory` implementations:

- `SpringBootCustomersApiClientFactory` - an implementation comptatible with Spring Framework, as it uses flux `WebClient`.

In case you use `SpringBootCustomersApiClientFactory` we will have spreate implination for each type of apis- PackageDistributionApiClient, MetadataApiClient, SubscriptionApiClient. Below you can find an example of proper registration of the factory.

```java
  @Override
public PackageDistributionApiClientImplementation createPackageDistributionHttpClient(URI baseUrl, PackageCredentials packageCredentials) {
    var client = this.createInternalClient(baseUrl, packageCredentials);
    return new PackageDistributionApiClientImplementation(client);
}

/**
 * {@inheritDoc}
 */
@Override
public MetadataApiClient createMetadataHttpClient(URI baseUrl, PackageCredentials packageCredentials) {
    var client = this.createInternalClient(baseUrl, packageCredentials);
    return new MetadataApiClientImplementation(client);
}

/**
 * {@inheritDoc}
 */
@Override
public SubscriptionApiClient createSubscriptionApiHttpClient(URI baseUrl, PackageCredentials packageCredentials) {
    var client = this.createInternalClient(baseUrl, packageCredentials);
    return new SubscriptionApiClientImplementation(client);
}
```

Later, you can inject the factory e.g. via the constructor:
```java
private final CustomersApiClientFactory apiClientFactory;

public CustomerApiExampleApplication(CustomersApiClientFactory factory) {
    apiClientFactory = factory;
}
```

After factory is obtained, it can be used to create actual API Client instances. When creating an instance, proper settings will be loaded from application.properties file.

Having the configured client instance one can use it by invoking requests with proper parameters. The documentation for each request can be found [here](https://docs.lsports.eu/lsports/v/integration/apis/snapshot) - bear in mind that you do not need to provide auth parameters each time as the SDK does it for you.

#### Customers API Handling responses

The client is written in reactive approach using [Reactor](https://projectreactor.io/) library. Each operation returns `Mono<T>` instance being an observable eventually returning response in case of success, or an error in case of failure. You can use the `Mono<T>` object in any way you want according to your needs, you can learn more what you can do with it in the Reactor library documentation linked above.

Below you can find primary approach how you can handle responses.
Asynchronous method - this is the recommended approach to the high load and throughput scenarios as this prioritizes throughput and minimizes risk of bottlenecks.
```java
    this.executeAsynchronous("PreMatch Async Get Fixtures",
        new GetFixtureRequest(.....),
        preMatchClient::getFixtures);
```

#### Customers API Error handling
Error handling depends on which approach is used – synchronous or asynchronous:
For asynchronous method a standard approach for reactive paradigm should be used. If error occurs during request processing a `Trade360Exception` exception is emitted to `Mono<T>`. The excessive description how to handle errors in Reactor can be found [here](https://projectreactor.io/docs/core/release/reference/index.html#error.handling). Below you can find one of the most basic approach to handle errors:
```java
    exception -> {
        System.err.println("[" + newExampleName + "] - Failed: " + exception.getMessage());
        if (exception instanceof Trade360Exception) {
            var trade360Exception = (Trade360Exception) exception;
            System.out.println("[" + newExampleName + "] - Errors:");
            trade360Exception.getErrors().forEach(error -> System.out.println("[" + newExampleName + "]\t- " + error));
            System.out.flush();}
        }
```

The `Trade360Exception` class does contain a detailed message which may help identify the root cause of the issue. To obtain the message call `getMessage()` method. Also sometimes additional detailed errors can be obtained using `getErrors()` method.

Below you can find an example how an exception may look like. In this case it means incorrect credentials have been provided.
![Trade360Exception example](/docs/static/trade360exception_example.png)




## Links
Spring AMQP documentation:
https://spring.io/projects/spring-amqp
https://docs.spring.io/spring-amqp/reference/amqp/resilience-recovering-from-errors-and-broker-failures.html
https://docs.spring.io/spring-amqp/reference/amqp/listener-concurrency.html


## Contributing

Please read [CONTRIBUTING.md](../CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Release

Latest release: <https://github.com/lsportsltd/trade360-dotnet-sdk/releases/latest>
