package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.FixtureSchedule;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FixtureScheduleCollectionResponseTest {

    @Test
    void testFieldAssignment() {
        FixtureScheduleCollectionResponse response = new FixtureScheduleCollectionResponse();
        List<FixtureSchedule> fixtures = List.of(new FixtureSchedule());
        
        response.fixtures = fixtures;
        
        assertEquals(fixtures, response.fixtures);
    }

    @Test
    void testNullFieldsAllowed() {
        FixtureScheduleCollectionResponse response = new FixtureScheduleCollectionResponse();
        
        response.fixtures = null;
        
        assertNull(response.fixtures);
    }

    @Test
    void testDefaultValues() {
        FixtureScheduleCollectionResponse response = new FixtureScheduleCollectionResponse();
        
        assertNull(response.fixtures);
    }

    @Test
    void testEmptyList() {
        FixtureScheduleCollectionResponse response = new FixtureScheduleCollectionResponse();
        List<FixtureSchedule> emptyList = List.of();
        
        response.fixtures = emptyList;
        
        assertEquals(emptyList, response.fixtures);
        assertTrue(((List<FixtureSchedule>) response.fixtures).isEmpty());
    }
}
