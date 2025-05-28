package eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EntityRegistryTest {

    private EntityRegistry entityRegistry;

    @Mock
    private EntityHandler entityHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        entityRegistry = new EntityRegistry();
    }

    @Test
    public void testSetEntityHandler() throws RabbitMQFeedException {
        // Arrange
        when(entityHandler.getEntityKey()).thenReturn(1);

        // Act
        entityRegistry.setEntityHandler(entityHandler);

        // Assert
        assertEquals(entityHandler, entityRegistry.getEntityByTypeId(1));
    }

    @Test
    public void testSetEntityHandlerThrowsExceptionWhenHandlerAlreadyExists() {
        // Arrange
        when(entityHandler.getEntityKey()).thenReturn(1);

        // Act & Assert
        assertThrows(RabbitMQFeedException.class, () -> {
            entityRegistry.setEntityHandler(entityHandler);
            entityRegistry.setEntityHandler(entityHandler);
        });
    }

    @Test
    public void testGetEntityByTypeIdReturnsNullWhenHandlerNotFound() {
        // Act
        EntityHandler result = entityRegistry.getEntityByTypeId(1);

        // Assert
        assertNull(result);
    }
}