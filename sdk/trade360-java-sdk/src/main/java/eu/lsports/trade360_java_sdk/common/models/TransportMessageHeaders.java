package eu.lsports.trade360_java_sdk.common.models;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code TransportMessageHeaders} class represents transport-level message headers
 * extracted from message properties. This class is immutable once created.
 */
public class TransportMessageHeaders {

    private static final String MESSAGE_GUID_KEY = "MessageGuid";
    private static final String MESSAGE_TYPE_KEY = "MessageType";
    private static final String TIMESTAMP_IN_MS_KEY = "timestamp_in_ms";
    private static final String MESSAGE_SEQUENCE_KEY = "MessageSequence";
    private static final String FIXTURE_ID_KEY = "FixtureId";

    private final String messageType;
    private final String messageSequence;
    private final String messageGuid;
    private final String fixtureId;
    private final String timestampInMs;

    /**
     * Private constructor to prevent direct instantiation.
     * Use {@link #createFromProperties(Map)} to create instances.
     *
     * @param messageGuid the message GUID
     * @param messageType the message type
     * @param timestampInMs the timestamp in milliseconds
     * @param messageSequence the message sequence (optional)
     * @param fixtureId the fixture ID (optional)
     */
    private TransportMessageHeaders(String messageGuid, String messageType, String timestampInMs, 
                                   String messageSequence, String fixtureId) {
        this.messageGuid = messageGuid;
        this.messageType = messageType;
        this.timestampInMs = timestampInMs;
        this.messageSequence = messageSequence;
        this.fixtureId = fixtureId;
    }

    /**
     * Gets the message type.
     *
     * @return the message type
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * Gets the message sequence.
     *
     * @return the message sequence
     */
    public String getMessageSequence() {
        return messageSequence;
    }

    /**
     * Gets the message GUID.
     *
     * @return the message GUID
     */
    public String getMessageGuid() {
        return messageGuid;
    }

    /**
     * Gets the fixture ID.
     *
     * @return the fixture ID
     */
    public String getFixtureId() {
        return fixtureId;
    }

    /**
     * Gets the timestamp in milliseconds.
     *
     * @return the timestamp in milliseconds
     */
    public String getTimestampInMs() {
        return timestampInMs;
    }

    /**
     * Creates a new {@code TransportMessageHeaders} instance from message properties.
     *
     * @param properties the message properties map
     * @return a new {@code TransportMessageHeaders} instance
     * @throws IllegalArgumentException if properties is null or required headers are missing
     */
    public static TransportMessageHeaders createFromProperties(Map<String, Object> properties) {
        if (properties == null) {
            throw new IllegalArgumentException("Properties cannot be null");
        }

        String messageGuid = getRequiredProperty(properties, MESSAGE_GUID_KEY, true);
        String messageType = getRequiredProperty(properties, MESSAGE_TYPE_KEY, true);
        String timestampInMs = getRequiredProperty(properties, TIMESTAMP_IN_MS_KEY, true);
        String messageSequence = getRequiredProperty(properties, MESSAGE_SEQUENCE_KEY, false);
        String fixtureId = getRequiredProperty(properties, FIXTURE_ID_KEY, false);

        return new TransportMessageHeaders(messageGuid, messageType, timestampInMs, messageSequence, fixtureId);
    }

    /**
     * Returns the available headers as a map containing only non-null and non-empty values.
     *
     * @return a map containing the available headers with their corresponding keys
     */
    public Map<String, String> getAsMap() {
        Map<String, String> headerMap = new HashMap<>();
        
        if (!isNullOrEmpty(messageGuid)) {
            headerMap.put(MESSAGE_GUID_KEY, messageGuid);
        }
        
        if (!isNullOrEmpty(messageType)) {
            headerMap.put(MESSAGE_TYPE_KEY, messageType);
        }
        
        if (!isNullOrEmpty(timestampInMs)) {
            headerMap.put(TIMESTAMP_IN_MS_KEY, timestampInMs);
        }
        
        if (!isNullOrEmpty(messageSequence)) {
            headerMap.put(MESSAGE_SEQUENCE_KEY, messageSequence);
        }
        
        if (!isNullOrEmpty(fixtureId)) {
            headerMap.put(FIXTURE_ID_KEY, fixtureId);
        }
        
        return headerMap;
    }

    /**
     * Checks if a string is null or empty (after trimming).
     *
     * @param value the string value to check
     * @return true if the value is null or empty, false otherwise
     */
    private static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Retrieves a property value from the properties map.
     *
     * @param properties the properties map
     * @param key the property key
     * @param required whether the property is required
     * @return the property value as a string, or empty string if not required and missing
     * @throws IllegalArgumentException if a required property is missing, null, or empty
     */
    private static String getRequiredProperty(Map<String, Object> properties, String key, boolean required) {
        if (!properties.containsKey(key)) {
            if (required) {
                throw new IllegalArgumentException(
                    String.format("Header '%s' is missing, null, or empty in message properties object.", key)
                );
            }
            return "";
        }

        var value = properties.get(key);
        var stringValue = value == null ? "" : value.toString();

        if (required && isNullOrEmpty(stringValue)) {
            throw new IllegalArgumentException(
                String.format("Header '%s' is missing, null, or empty in message properties object.", key)
            );
        }

        return stringValue;
    }
}
