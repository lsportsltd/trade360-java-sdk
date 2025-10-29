package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Edge case tests for StatisticType enum.
 * Tests documented issues from Confluence test cases including:
 * - Unknown StatisticType values 93 and 2029 (OutrightFixtureUpdate message)
 * - JSON deserialization edge cases
 * - Boundary value handling
 */
public class StatisticTypeEdgeCaseTests {

    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void getAllEnumValues_containsExpectedTypes() {
        // Verify all enum values are present
        StatisticType[] allTypes = StatisticType.values();
        assertTrue("Should have multiple statistic types", allTypes.length > 40);
    }

    @Test
    public void getValue_forValidEnumValues_returnsCorrectValue() {
        // Test a few key enum values
        assertEquals(0, StatisticType.NOT_SET.getValue());
        assertEquals(1, StatisticType.CORNERS.getValue());
        assertEquals(9, StatisticType.GOAL.getValue());
        assertEquals(41, StatisticType.CARDS.getValue());
    }

    @Test
    public void deserializeValidStatisticType_succeeds() throws JsonProcessingException {
        // Arrange
        String json = "1"; // CORNERS

        // Act
        StatisticType result = objectMapper.readValue(json, StatisticType.class);

        // Assert
        assertEquals(StatisticType.CORNERS, result);
    }

    @Test(expected = InvalidFormatException.class)
    public void deserializeUnknownValue93_throwsInvalidFormatException() throws JsonProcessingException {
        // Confluence-documented edge case: StatisticType = 93 not in enum
        // This occurs in OutrightFixtureUpdate messages
        String json = "93";
        
        // Expected: Should throw InvalidFormatException
        objectMapper.readValue(json, StatisticType.class);
    }

    @Test(expected = InvalidFormatException.class)
    public void deserializeUnknownValue2029_throwsInvalidFormatException() throws JsonProcessingException {
        // Confluence-documented edge case: StatisticType = 2029 not in enum
        // This occurs in OutrightFixtureUpdate messages
        String json = "2029";
        
        // Expected: Should throw InvalidFormatException
        objectMapper.readValue(json, StatisticType.class);
    }

    @Test(expected = InvalidFormatException.class)
    public void deserializeNegativeValue_throwsInvalidFormatException() throws JsonProcessingException {
        // Arrange
        String json = "-1";

        // Act & Assert
        objectMapper.readValue(json, StatisticType.class);
    }

    @Test(expected = InvalidFormatException.class)
    public void deserializeVeryLargeValue_throwsInvalidFormatException() throws JsonProcessingException {
        // Arrange
        String json = "9999";

        // Act & Assert
        objectMapper.readValue(json, StatisticType.class);
    }

    @Test
    public void serializeAllStatisticTypes_succeeds() throws JsonProcessingException {
        // Verify all enum values can be serialized
        for (StatisticType type : StatisticType.values()) {
            String json = objectMapper.writeValueAsString(type);
            assertNotNull("Serialized JSON should not be null for " + type.name(), json);
            assertEquals("Serialized value should match enum value", 
                        String.valueOf(type.getValue()), json);
        }
    }

    @Test
    public void roundTripSerialization_preservesValue() throws JsonProcessingException {
        // Test serialization and deserialization cycle
        StatisticType original = StatisticType.GOAL;
        
        // Serialize
        String json = objectMapper.writeValueAsString(original);
        
        // Deserialize
        StatisticType deserialized = objectMapper.readValue(json, StatisticType.class);
        
        // Assert
        assertEquals(original, deserialized);
        assertEquals(original.getValue(), deserialized.getValue());
    }

    @Test
    public void allEnumValues_haveUniqueValues() {
        // Verify no duplicate values in enum
        StatisticType[] allTypes = StatisticType.values();
        for (int i = 0; i < allTypes.length; i++) {
            for (int j = i + 1; j < allTypes.length; j++) {
                assertNotEquals("Enum values should be unique: " + allTypes[i].name() + " vs " + allTypes[j].name(),
                               allTypes[i].getValue(), allTypes[j].getValue());
            }
        }
    }

    @Test
    public void allEnumValues_haveNonNegativeValues() {
        // Verify all enum values are non-negative
        for (StatisticType type : StatisticType.values()) {
            assertTrue("Statistic type value should be non-negative: " + type.name(),
                      type.getValue() >= 0);
        }
    }

    @Test
    public void deserializeZeroValue_returnsNotSet() throws JsonProcessingException {
        // Arrange
        String json = "0";

        // Act
        StatisticType result = objectMapper.readValue(json, StatisticType.class);

        // Assert
        assertEquals(StatisticType.NOT_SET, result);
        assertEquals(0, result.getValue());
    }

    @Test
    public void enumValueOf_withValidName_returnsCorrectEnum() {
        // Test valueOf method
        StatisticType result = StatisticType.valueOf("GOAL");
        assertEquals(StatisticType.GOAL, result);
        assertEquals(9, result.getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void enumValueOf_withInvalidName_throwsIllegalArgumentException() {
        // Test valueOf with invalid name
        StatisticType.valueOf("INVALID_STATISTIC_TYPE");
    }
}

