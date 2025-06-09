package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RabbitConnectionConfigurationComprehensiveTest {

    @Test
    void testRabbitConnectionConfigurationDefaultConstructor() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        
        assertNotNull(config);
        assertNull(config.getName());
        assertEquals("localhost", config.getHost());
        assertEquals(5672, config.getPort());
        assertEquals("guest", config.getUserName());
        assertEquals("guest", config.getPassword());
        assertEquals("/", config.getVirtualHost());
        assertEquals(0, config.getPackageId());
        assertEquals(0, config.getPrefetchCount());
        assertTrue(config.isAutoAck());
        assertEquals(3000, config.getNetworkRecoveryInterval());
        assertEquals(3, config.getRetryAttempts());
        assertEquals(1000, config.getRetryInitialInterval());
        assertEquals(2.0, config.getRetryMultiple());
        assertEquals(5000, config.getRetryMaxInterval());
        assertEquals(1, config.getConcurrentConsumers());
        assertEquals(20, config.getMaxConcurrentConsumers());
        assertEquals(30, config.getRequestedHeartBeat());
    }

    @Test
    void testRabbitConnectionConfigurationNameAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        String testName = "test-connection";
        
        config.setName(testName);
        
        assertEquals(testName, config.getName());
    }

    @Test
    void testRabbitConnectionConfigurationHostAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        String testHost = "rabbitmq.example.com";
        
        config.setHost(testHost);
        
        assertEquals(testHost, config.getHost());
    }

    @Test
    void testRabbitConnectionConfigurationPortAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        int testPort = 15672;
        
        config.setPort(testPort);
        
        assertEquals(testPort, config.getPort());
    }

    @Test
    void testRabbitConnectionConfigurationUserNameAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        String testUserName = "admin";
        
        config.setUserName(testUserName);
        
        assertEquals(testUserName, config.getUserName());
    }

    @Test
    void testRabbitConnectionConfigurationPasswordAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        String testPassword = "password123";
        
        config.setPassword(testPassword);
        
        assertEquals(testPassword, config.getPassword());
    }

    @Test
    void testRabbitConnectionConfigurationVirtualHostAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        String testVirtualHost = "/test";
        
        config.setVirtualHost(testVirtualHost);
        
        assertEquals(testVirtualHost, config.getVirtualHost());
    }

    @Test
    void testRabbitConnectionConfigurationPackageIdAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        int testPackageId = 12345;
        
        config.setPackageId(testPackageId);
        
        assertEquals(testPackageId, config.getPackageId());
    }

    @Test
    void testRabbitConnectionConfigurationPrefetchCountAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        int testPrefetchCount = 100;
        
        config.setPrefetchCount(testPrefetchCount);
        
        assertEquals(testPrefetchCount, config.getPrefetchCount());
    }

    @Test
    void testRabbitConnectionConfigurationAutoAckAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        
        config.setAutoAck(false);
        
        assertFalse(config.isAutoAck());
    }

    @Test
    void testRabbitConnectionConfigurationNetworkRecoveryIntervalAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        long testInterval = 5000L;
        
        config.setNetworkRecoveryInterval(testInterval);
        
        assertEquals(testInterval, config.getNetworkRecoveryInterval());
    }

    @Test
    void testRabbitConnectionConfigurationRetryAttemptsAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        int testRetryAttempts = 5;
        
        config.setRetryAttempts(testRetryAttempts);
        
        assertEquals(testRetryAttempts, config.getRetryAttempts());
    }

    @Test
    void testRabbitConnectionConfigurationRetryInitialIntervalAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        int testRetryInitialInterval = 2000;
        
        config.setRetryInitialInterval(testRetryInitialInterval);
        
        assertEquals(testRetryInitialInterval, config.getRetryInitialInterval());
    }

    @Test
    void testRabbitConnectionConfigurationRetryMultipleAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        double testRetryMultiple = 1.5;
        
        config.setRetryMultiple(testRetryMultiple);
        
        assertEquals(testRetryMultiple, config.getRetryMultiple());
    }

    @Test
    void testRabbitConnectionConfigurationRetryMaxIntervalAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        int testRetryMaxInterval = 10000;
        
        config.setRetryMaxInterval(testRetryMaxInterval);
        
        assertEquals(testRetryMaxInterval, config.getRetryMaxInterval());
    }

    @Test
    void testRabbitConnectionConfigurationConcurrentConsumersAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        int testConcurrentConsumers = 5;
        
        config.setConcurrentConsumers(testConcurrentConsumers);
        
        assertEquals(testConcurrentConsumers, config.getConcurrentConsumers());
    }

    @Test
    void testRabbitConnectionConfigurationMaxConcurrentConsumersAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        int testMaxConcurrentConsumers = 50;
        
        config.setMaxConcurrentConsumers(testMaxConcurrentConsumers);
        
        assertEquals(testMaxConcurrentConsumers, config.getMaxConcurrentConsumers());
    }

    @Test
    void testRabbitConnectionConfigurationRequestedHeartBeatAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        int testRequestedHeartBeat = 60;
        
        config.setRequestedHeartBeat(testRequestedHeartBeat);
        
        assertEquals(testRequestedHeartBeat, config.getRequestedHeartBeat());
    }

    @Test
    void testRabbitConnectionConfigurationBaseCustomersApiAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        String testBaseCustomersApi = "https://api.example.com";
        
        config.setBaseCustomersApi(testBaseCustomersApi);
        
        assertEquals(testBaseCustomersApi, config.getBaseCustomersApi());
    }

    @Test
    void testRabbitConnectionConfigurationRabbitListenerContainerFactoryNameAssignment() {
        RabbitConnectionConfiguration config = new RabbitConnectionConfiguration();
        String testFactoryName = "customRabbitListenerContainerFactory";
        
        config.setRabbitListenerContainerFactoryName(testFactoryName);
        
        assertEquals(testFactoryName, config.getRabbitListenerContainerFactoryName());
    }
}
