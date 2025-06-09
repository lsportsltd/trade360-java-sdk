package eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RabbitMQConfigurationExpandedTest {

    private RabbitMQConfiguration configuration;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        configuration = new RabbitMQConfiguration();
    }

    @Test
    void testQueueCreation() {
        Queue queue = configuration.queue();
        assertNotNull(queue);
        assertEquals("trade360.queue", queue.getName());
        assertTrue(queue.isDurable());
    }

    @Test
    void testExchangeCreation() {
        TopicExchange exchange = configuration.exchange();
        assertNotNull(exchange);
        assertEquals("trade360.exchange", exchange.getName());
        assertTrue(exchange.isDurable());
    }

    @Test
    void testBindingCreation() {
        Queue queue = configuration.queue();
        TopicExchange exchange = configuration.exchange();
        Binding binding = configuration.binding(queue, exchange);
        
        assertNotNull(binding);
        assertEquals("trade360.routing.key", binding.getRoutingKey());
        assertEquals(queue.getName(), binding.getDestination());
        assertEquals(exchange.getName(), binding.getExchange());
    }

    @Test
    void testConfigurationInstantiation() {
        assertNotNull(configuration);
    }

    @Test
    void testQueueProperties() {
        Queue queue = configuration.queue();
        assertTrue(queue.isDurable());
        assertFalse(queue.isExclusive());
        assertFalse(queue.isAutoDelete());
    }

    @Test
    void testExchangeProperties() {
        TopicExchange exchange = configuration.exchange();
        assertTrue(exchange.isDurable());
        assertFalse(exchange.isAutoDelete());
        assertEquals("topic", exchange.getType());
    }
}
