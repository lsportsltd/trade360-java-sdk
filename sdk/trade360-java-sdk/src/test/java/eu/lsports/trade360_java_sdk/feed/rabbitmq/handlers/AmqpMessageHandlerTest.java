package eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lsports.trade360_java_sdk.common.entities.enums.MessageType;
import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.amqp.core.Message;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;

class AmqpMessageHandlerTest {
    private EntityRegistry entityRegistry;
    private AmqpMessageHandler handler;
    private EntityHandler entityHandler;

    @BeforeEach
    void setUp() {
        entityRegistry = mock(EntityRegistry.class);
        entityHandler = mock(EntityHandler.class);
        handler = new AmqpMessageHandler(entityRegistry);
    }

    @Test
    void test_process_ValidMessage_CallsEntityHandler() throws Exception {
        int typeId = 1;
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"1\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        when(entityRegistry.getEntityByTypeId(typeId)).thenReturn(entityHandler);
        // Mock static method
        try (var mt = Mockito.mockStatic(MessageType.class)) {
            mt.when(() -> MessageType.findMessageType(typeId)).thenReturn(MessageType.FixtureMetadataUpdate);
            doNothing().when(entityHandler).process(any(), any());
            assertDoesNotThrow(() -> handler.process(message));
        }
    }

    @Test
    void process_entityHandlerNotFound_throwsException() throws Exception {
        int typeId = 1;
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"1\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        when(entityRegistry.getEntityByTypeId(typeId)).thenReturn(null);
        try (var mt = Mockito.mockStatic(MessageType.class)) {
            mt.when(() -> MessageType.findMessageType(typeId)).thenReturn(MessageType.FixtureMetadataUpdate);
            assertThrows(Trade360Exception.class, () -> handler.process(message));
        }
    }

    @Test
    void testGetMessageType_InvalidType_ThrowsException() throws Exception {
        var method = handler.getClass().getDeclaredMethod("getMessageType", int.class);
        method.setAccessible(true);
        try (var mt = Mockito.mockStatic(MessageType.class)) {
            mt.when(() -> MessageType.findMessageType(999)).thenThrow(new ClassNotFoundException());
            InvocationTargetException ex = assertThrows(InvocationTargetException.class, () -> method.invoke(handler, 999));
            assertTrue(ex.getCause() instanceof RabbitMQFeedException);
        }
    }

    @Test
    void testGetTypeIdFromMessageInvalidHeaderThrowsException() throws Exception {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        var method = handler.getClass().getDeclaredMethod("getTypeIdFromMessage", Message.class);
        method.setAccessible(true);
        assertThrows(Exception.class, () -> method.invoke(handler, message));
    }

    void testProcessWithMalformedJson() {
        String malformedJson = "{invalid json}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(malformedJson.getBytes(StandardCharsets.UTF_8));
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testProcessWithMissingBodyProperty() {
        String bodyJson = "{\"Header\":{\"Type\":\"1\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testProcessWithMissingHeaderProperty() {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testProcessWithNullTypeInHeader() {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":null}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testProcessWithEmptyTypeInHeader() {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testProcessWithInvalidTypeFormat() {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"invalid\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        
        assertThrows(Exception.class, () -> handler.process(message));
    }

    @Test
    void testGetBodyFromMessage() throws Exception {
        String bodyJson = "{\"Body\":{\"testField\":\"testValue\"},\"Header\":{\"Type\":\"1\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        
        var method = handler.getClass().getDeclaredMethod("getBodyFromMessage", Message.class);
        method.setAccessible(true);
        String result = (String) method.invoke(handler, message);
        
        assertNotNull(result);
        assertTrue(result.contains("testField"));
        assertTrue(result.contains("testValue"));
    }

    @Test
    void testGetHeaderFromMessage() throws Exception {
        String bodyJson = "{\"Body\":{\"foo\":\"bar\"},\"Header\":{\"Type\":\"1\",\"CustomHeader\":\"value\"}}";
        Message message = mock(Message.class);
        when(message.getBody()).thenReturn(bodyJson.getBytes(StandardCharsets.UTF_8));
        
        var method = handler.getClass().getDeclaredMethod("getHeaderFromMessage", Message.class);
        method.setAccessible(true);
        Map<String, String> result = (Map<String, String>) method.invoke(handler, message);
        
        assertNotNull(result);
        assertEquals("1", result.get("Type"));
        assertEquals("value", result.get("CustomHeader"));
    }
}  
