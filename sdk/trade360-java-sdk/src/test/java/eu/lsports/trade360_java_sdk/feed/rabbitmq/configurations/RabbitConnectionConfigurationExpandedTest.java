package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RabbitConnectionConfigurationExpandedTest {

    private RabbitConnectionConfiguration configuration;

    @BeforeEach
    void setUp() {
        configuration = new RabbitConnectionConfiguration();
    }

    @Test
    void testNameAssignment() {
        String name = "test-connection";
        configuration.setName(name);
        assertEquals(name, configuration.getName());
    }

    @Test
    void testPackageIdAssignment() {
        Integer packageId = 12345;
        configuration.setPackageId(packageId);
        assertEquals(packageId, configuration.getPackageId());
    }

    @Test
    void testHostAssignment() {
        String host = "localhost";
        configuration.setHost(host);
        assertEquals(host, configuration.getHost());
    }

    @Test
    void testPortAssignment() {
        Integer port = 5672;
        configuration.setPort(port);
        assertEquals(port, configuration.getPort());
    }

    @Test
    void testVirtualHostAssignment() {
        String virtualHost = "/test";
        configuration.setVirtualHost(virtualHost);
        assertEquals(virtualHost, configuration.getVirtualHost());
    }

    @Test
    void testUsernameAssignment() {
        String username = "testuser";
        configuration.setUserName(username);
        assertEquals(username, configuration.getUserName());
    }

    @Test
    void testPasswordAssignment() {
        String password = "testpass";
        configuration.setPassword(password);
        assertEquals(password, configuration.getPassword());
    }

    @Test
    void testAllFieldsAssignment() {
        String name = "full-test-connection";
        int packageId = 99999;
        String host = "rabbitmq.example.com";
        int port = 5673;
        String virtualHost = "/production";
        String userName = "produser";
        String password = "prodpass";
        int prefetchCount = 200;
        boolean autoAck = false;
        int retryAttempts = 5;
        int retryInitialInterval = 2000;
        int requestedHeartBeat = 120;
        
        configuration.setName(name);
        configuration.setPackageId(packageId);
        configuration.setHost(host);
        configuration.setPort(port);
        configuration.setVirtualHost(virtualHost);
        configuration.setUserName(userName);
        configuration.setPassword(password);
        configuration.setPrefetchCount(prefetchCount);
        configuration.setAutoAck(autoAck);
        configuration.setRetryAttempts(retryAttempts);
        configuration.setRetryInitialInterval(retryInitialInterval);
        configuration.setRequestedHeartBeat(requestedHeartBeat);
        
        assertEquals(packageId, configuration.getPackageId());
        assertEquals(host, configuration.getHost());
        assertEquals(virtualHost, configuration.getVirtualHost());
        assertEquals(userName, configuration.getUserName());
        assertEquals(password, configuration.getPassword());
        assertEquals(prefetchCount, configuration.getPrefetchCount());
        assertEquals(autoAck, configuration.isAutoAck());
        assertEquals(retryAttempts, configuration.getRetryAttempts());
        assertEquals(retryInitialInterval, configuration.getRetryInitialInterval());
        assertEquals(requestedHeartBeat, configuration.getRequestedHeartBeat());
    }

    @Test
    void testDefaultValues() {
        RabbitConnectionConfiguration newConfiguration = new RabbitConnectionConfiguration();
        
        assertEquals("localhost", newConfiguration.getHost());
        assertEquals("/", newConfiguration.getVirtualHost());
        assertEquals("guest", newConfiguration.getUserName());
        assertEquals("guest", newConfiguration.getPassword());
        assertTrue(newConfiguration.isAutoAck());
        assertEquals(3000, newConfiguration.getNetworkRecoveryInterval());
        assertEquals(3, newConfiguration.getRetryAttempts());
        assertEquals(1000, newConfiguration.getRetryInitialInterval());
        assertEquals(2.0, newConfiguration.getRetryMultiple());
        assertEquals(5000, newConfiguration.getRetryMaxInterval());
        assertEquals(1, newConfiguration.getConcurrentConsumers());
        assertEquals(20, newConfiguration.getMaxConcurrentConsumers());
        assertEquals(30, newConfiguration.getRequestedHeartBeat());
    }
}
