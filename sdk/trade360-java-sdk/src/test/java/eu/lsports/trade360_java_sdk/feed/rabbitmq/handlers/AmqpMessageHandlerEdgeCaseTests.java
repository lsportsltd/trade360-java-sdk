package eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.exceptions.RabbitMQFeedException;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Edge case tests for AmqpMessageHandler.
 * Tests documented issues from Confluence test cases including:
 * - Malformed JSON handling (missing closing bracket)
 * - Missing header property handling
 * - Invalid message type ID (222)
 * - Null and empty message bodies
 */
public class AmqpMessageHandlerEdgeCaseTests {

    private EntityRegistry mockEntityRegistry;
    private AmqpMessageHandler handler;
    private EntityHandler mockEntityHandler;

    @Before
    public void setUp() {
        mockEntityRegistry = mock(EntityRegistry.class);
        mockEntityHandler = mock(EntityHandler.class);
        handler = new AmqpMessageHandler(mockEntityRegistry);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withMalformedJsonMissingClosingBracket_throwsRabbitMQFeedException() throws Exception {
        // Confluence-documented edge case: Message with missing closing bracket
        String malformedJson = "{\"Header\":{\"Type\":1},\"Body\":{\"data\":\"test\""; // Missing closing }
        Message message = createMessage(malformedJson);

        // Expected: Should throw RabbitMQFeedException during parsing
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withMissingHeaderProperty_throwsRabbitMQFeedException() throws Exception {
        // Confluence-documented edge case: Message missing Header property
        String jsonWithoutHeader = "{\"Body\":{\"data\":\"test\"}}";
        Message message = createMessage(jsonWithoutHeader);

        // Expected: Should throw RabbitMQFeedException
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withNullHeaderProperty_throwsRabbitMQFeedException() throws Exception {
        // Edge case: Header property is null
        String jsonWithNullHeader = "{\"Header\":null,\"Body\":{\"data\":\"test\"}}";
        Message message = createMessage(jsonWithNullHeader);

        // Expected: Should throw RabbitMQFeedException
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withMissingTypeInHeader_throwsRabbitMQFeedException() throws Exception {
        // Edge case: Header exists but Type property is missing
        String jsonWithoutType = "{\"Header\":{\"OtherField\":\"value\"},\"Body\":{\"data\":\"test\"}}";
        Message message = createMessage(jsonWithoutType);

        // Expected: Should throw RabbitMQFeedException
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withNullTypeInHeader_throwsRabbitMQFeedException() throws Exception {
        // Edge case: Type property is null
        String jsonWithNullType = "{\"Header\":{\"Type\":null},\"Body\":{\"data\":\"test\"}}";
        Message message = createMessage(jsonWithNullType);

        // Expected: Should throw RabbitMQFeedException with message about wrong or lack of 'type' property
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withEmptyTypeInHeader_throwsRabbitMQFeedException() throws Exception {
        // Edge case: Type property is empty string
        String jsonWithEmptyType = "{\"Header\":{\"Type\":\"\"},\"Body\":{\"data\":\"test\"}}";
        Message message = createMessage(jsonWithEmptyType);

        // Expected: Should throw RabbitMQFeedException
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withUnsupportedMessageType222_throwsRabbitMQFeedException() throws Exception {
        // Confluence-documented edge case: Unsupported message type ID 222
        String jsonWithType222 = "{\"Header\":{\"Type\":222},\"Body\":{\"data\":\"test\"}}";
        Message message = createMessage(jsonWithType222);

        // Expected: Should throw RabbitMQFeedException with message "Failed to deserialize typeId: 222"
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withMissingBodyProperty_throwsRabbitMQFeedException() throws Exception {
        // Edge case: Message with valid Header but missing Body
        String jsonWithoutBody = "{\"Header\":{\"Type\":3}}"; // MarketUpdate requires body
        Message message = createMessage(jsonWithoutBody);
        
        when(mockEntityRegistry.getEntityByTypeId(3)).thenReturn(mockEntityHandler);

        // Expected: Should throw RabbitMQFeedException
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withNullBodyProperty_throwsRabbitMQFeedException() throws Exception {
        // Edge case: Body property is null for message type that requires body
        String jsonWithNullBody = "{\"Header\":{\"Type\":3},\"Body\":null}";
        Message message = createMessage(jsonWithNullBody);
        
        when(mockEntityRegistry.getEntityByTypeId(3)).thenReturn(mockEntityHandler);

        // Expected: Should throw RabbitMQFeedException
        handler.process(message);
    }

    @Test(expected = Trade360Exception.class)
    public void process_withUnregisteredEntityHandler_throwsTrade360Exception() throws Exception {
        // Edge case: Valid message but no entity handler registered
        String validJson = "{\"Header\":{\"Type\":1},\"Body\":{\"FixtureId\":12345}}";
        Message message = createMessage(validJson);
        
        // EntityRegistry returns null (no handler registered)
        when(mockEntityRegistry.getEntityByTypeId(1)).thenReturn(null);

        // Expected: Should throw Trade360Exception with message about entity handler not found
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withInvalidJsonStructure_throwsRabbitMQFeedException() throws Exception {
        // Edge case: JSON is an array instead of object
        String invalidJsonStructure = "[\"Header\",\"Body\"]";
        Message message = createMessage(invalidJsonStructure);

        // Expected: Should throw RabbitMQFeedException
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withEmptyJson_throwsRabbitMQFeedException() throws Exception {
        // Edge case: Empty JSON object
        String emptyJson = "{}";
        Message message = createMessage(emptyJson);

        // Expected: Should throw RabbitMQFeedException
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withInvalidTypeIdFormat_throwsRabbitMQFeedException() throws Exception {
        // Edge case: Type is not a valid integer
        String jsonWithInvalidType = "{\"Header\":{\"Type\":\"abc\"},\"Body\":{\"data\":\"test\"}}";
        Message message = createMessage(jsonWithInvalidType);

        // Expected: Should throw RabbitMQFeedException
        handler.process(message);
    }

    @Test(expected = RabbitMQFeedException.class)
    public void process_withNegativeTypeId_throwsRabbitMQFeedException() throws Exception {
        // Edge case: Negative type ID
        String jsonWithNegativeType = "{\"Header\":{\"Type\":-1},\"Body\":{\"data\":\"test\"}}";
        Message message = createMessage(jsonWithNegativeType);

        // Expected: Should throw RabbitMQFeedException
        handler.process(message);
    }

    @Test
    public void process_exceptionMessage_containsTypeIdForUnsupportedType() {
        // Verify exception message includes the invalid type ID for debugging
        String jsonWithType999 = "{\"Header\":{\"Type\":999},\"Body\":{\"data\":\"test\"}}";
        Message message = createMessage(jsonWithType999);

        try {
            handler.process(message);
            fail("Should have thrown RabbitMQFeedException");
        } catch (RabbitMQFeedException e) {
            assertTrue("Exception message should contain type ID 999", 
                      e.getMessage().contains("999"));
        } catch (Exception e) {
            fail("Wrong exception type thrown: " + e.getClass().getName());
        }
    }

    @Test
    public void process_exceptionMessage_containsContextForMissingType() {
        // Verify exception message is helpful when Type property is missing
        String jsonWithoutType = "{\"Header\":{},\"Body\":{\"data\":\"test\"}}";
        Message message = createMessage(jsonWithoutType);

        try {
            handler.process(message);
            fail("Should have thrown RabbitMQFeedException");
        } catch (RabbitMQFeedException e) {
            assertTrue("Exception message should mention 'type' property", 
                      e.getMessage().toLowerCase().contains("type"));
        } catch (Exception e) {
            fail("Wrong exception type thrown: " + e.getClass().getName());
        }
    }

    @Test
    public void process_exceptionMessage_containsContextForEntityHandlerNotFound() {
        // Verify exception message is helpful when entity handler not registered
        String validJson = "{\"Header\":{\"Type\":1},\"Body\":{\"FixtureId\":12345}}";
        Message message = createMessage(validJson);
        
        when(mockEntityRegistry.getEntityByTypeId(1)).thenReturn(null);

        try {
            handler.process(message);
            fail("Should have thrown Trade360Exception");
        } catch (Trade360Exception e) {
            assertTrue("Exception message should mention entity handler not found", 
                      e.getMessage().toLowerCase().contains("entity handler not found"));
            assertTrue("Exception message should contain type ID", 
                      e.getMessage().contains("1"));
        } catch (Exception e) {
            fail("Wrong exception type thrown: " + e.getClass().getName());
        }
    }

    /**
     * Helper method to create a Message object from JSON string
     */
    private Message createMessage(String json) {
        MessageProperties properties = new MessageProperties();
        return new Message(json.getBytes(), properties);
    }
}

