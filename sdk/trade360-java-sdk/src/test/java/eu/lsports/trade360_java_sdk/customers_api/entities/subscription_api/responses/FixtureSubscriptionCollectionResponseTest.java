package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.FixtureSubscription;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FixtureSubscriptionCollectionResponseTest {

    @Test
    void testFieldAssignment() {
        FixtureSubscriptionCollectionResponse response = new FixtureSubscriptionCollectionResponse();
        List<FixtureSubscription> fixtures = List.of(new FixtureSubscription());
        
        response.fixtures = fixtures;
        
        assertEquals(fixtures, response.fixtures);
    }

    @Test
    void testNullFieldsAllowed() {
        FixtureSubscriptionCollectionResponse response = new FixtureSubscriptionCollectionResponse();
        
        response.fixtures = null;
        
        assertNull(response.fixtures);
    }

    @Test
    void testDefaultValues() {
        FixtureSubscriptionCollectionResponse response = new FixtureSubscriptionCollectionResponse();
        
        assertNull(response.fixtures);
    }

    @Test
    void testEmptyList() {
        FixtureSubscriptionCollectionResponse response = new FixtureSubscriptionCollectionResponse();
        List<FixtureSubscription> emptyList = List.of();
        
        response.fixtures = emptyList;
        
        assertEquals(emptyList, response.fixtures);
        assertTrue(((List<FixtureSubscription>) response.fixtures).isEmpty());
    }
}
