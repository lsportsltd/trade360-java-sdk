package com.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import com.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EntityRegistryTests {

    @Test
    public void setEntityHandler_withNewHandler_addsHandlerToRegistry() throws RabbitMQFeedException {
        // Arrange
        EntityRegistry registry = new EntityRegistry();
        EntityHandler handler = mock(EntityHandler.class);
        when(handler.getEntityKey()).thenReturn(1);

        // Act
        registry.setEntityHandler(handler);

        // Assert
        EntityHandler retrievedHandler = registry.getEntityByTypeId(1);
        assertNotNull(retrievedHandler);
        assertEquals(handler, retrievedHandler);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void setEntityHandler_withDuplicateEntityKey_throwsException() throws RabbitMQFeedException {
        // Arrange
        EntityRegistry registry = new EntityRegistry();
        EntityHandler handler1 = mock(EntityHandler.class);
        EntityHandler handler2 = mock(EntityHandler.class);
        when(handler1.getEntityKey()).thenReturn(1);
        when(handler2.getEntityKey()).thenReturn(1);

        // Act
        registry.setEntityHandler(handler1);
        registry.setEntityHandler(handler2); // Should throw exception
    }

    @Test
    public void setEntityHandler_withDifferentEntityKeys_addsMultipleHandlers() throws RabbitMQFeedException {
        // Arrange
        EntityRegistry registry = new EntityRegistry();
        EntityHandler handler1 = mock(EntityHandler.class);
        EntityHandler handler2 = mock(EntityHandler.class);
        EntityHandler handler3 = mock(EntityHandler.class);
        when(handler1.getEntityKey()).thenReturn(1);
        when(handler2.getEntityKey()).thenReturn(2);
        when(handler3.getEntityKey()).thenReturn(3);

        // Act
        registry.setEntityHandler(handler1);
        registry.setEntityHandler(handler2);
        registry.setEntityHandler(handler3);

        // Assert
        assertEquals(handler1, registry.getEntityByTypeId(1));
        assertEquals(handler2, registry.getEntityByTypeId(2));
        assertEquals(handler3, registry.getEntityByTypeId(3));
    }

    @Test
    public void getEntityByTypeId_withNonExistentKey_returnsNull() {
        // Arrange
        EntityRegistry registry = new EntityRegistry();

        // Act
        EntityHandler result = registry.getEntityByTypeId(999);

        // Assert
        assertNull(result);
    }

    @Test
    public void getEntityByTypeId_afterAddingHandler_returnsCorrectHandler() throws RabbitMQFeedException {
        // Arrange
        EntityRegistry registry = new EntityRegistry();
        EntityHandler handler = mock(EntityHandler.class);
        when(handler.getEntityKey()).thenReturn(42);
        registry.setEntityHandler(handler);

        // Act
        EntityHandler result = registry.getEntityByTypeId(42);

        // Assert
        assertNotNull(result);
        assertEquals(handler, result);
        verify(handler, atLeastOnce()).getEntityKey();
    }

    @Test
    public void setEntityHandler_withMultipleHandlers_maintainsAllHandlers() throws RabbitMQFeedException {
        // Arrange
        EntityRegistry registry = new EntityRegistry();
        EntityHandler handler1 = mock(EntityHandler.class);
        EntityHandler handler2 = mock(EntityHandler.class);
        when(handler1.getEntityKey()).thenReturn(10);
        when(handler2.getEntityKey()).thenReturn(20);

        // Act
        registry.setEntityHandler(handler1);
        registry.setEntityHandler(handler2);

        // Assert
        assertNotNull(registry.getEntityByTypeId(10));
        assertNotNull(registry.getEntityByTypeId(20));
        assertEquals(handler1, registry.getEntityByTypeId(10));
        assertEquals(handler2, registry.getEntityByTypeId(20));
    }

    @Test
    public void constructor_createsEmptyRegistry() {
        // Arrange & Act
        EntityRegistry registry = new EntityRegistry();

        // Assert
        assertNull(registry.getEntityByTypeId(1));
        assertNull(registry.getEntityByTypeId(2));
    }
}

