package eu.lsports.trade360_java_sdk.common.entities.shared;

import eu.lsports.trade360_java_sdk.common.entities.enums.SubscriptionStatus;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubscriptionTests {

    @Test
    public void newInstance_hasDefaultValues() {
        Subscription subscription = new Subscription();
        
        assertEquals(0, subscription.type);
        assertNull(subscription.status);
    }

    @Test
    public void setType_storesValue() {
        Subscription subscription = new Subscription();
        
        subscription.type = 123;
        
        assertEquals(123, subscription.type);
    }

    @Test
    public void setStatus_storesValue() {
        Subscription subscription = new Subscription();
        
        subscription.status = SubscriptionStatus.SUBSCRIBED;
        
        assertEquals(SubscriptionStatus.SUBSCRIBED, subscription.status);
    }

    @Test
    public void setBothFields_storesBothValues() {
        Subscription subscription = new Subscription();
        
        subscription.type = 456;
        subscription.status = SubscriptionStatus.PENDING;
        
        assertEquals(456, subscription.type);
        assertEquals(SubscriptionStatus.PENDING, subscription.status);
    }

    @Test
    public void setType_canOverwriteValue() {
        Subscription subscription = new Subscription();
        subscription.type = 100;
        
        subscription.type = 200;
        
        assertEquals(200, subscription.type);
    }

    @Test
    public void setStatus_canOverwriteValue() {
        Subscription subscription = new Subscription();
        subscription.status = SubscriptionStatus.SUBSCRIBED;
        
        subscription.status = SubscriptionStatus.UNSUBSCRIBED;
        
        assertEquals(SubscriptionStatus.UNSUBSCRIBED, subscription.status);
    }

    @Test
    public void setStatus_canSetToNull() {
        Subscription subscription = new Subscription();
        subscription.status = SubscriptionStatus.SUBSCRIBED;
        
        subscription.status = null;
        
        assertNull(subscription.status);
    }

    @Test
    public void setType_canBeZero() {
        Subscription subscription = new Subscription();
        
        subscription.type = 0;
        
        assertEquals(0, subscription.type);
    }

    @Test
    public void setType_canBeNegative() {
        Subscription subscription = new Subscription();
        
        subscription.type = -1;
        
        assertEquals(-1, subscription.type);
    }

    @Test
    public void setType_canBeLarge() {
        Subscription subscription = new Subscription();
        
        subscription.type = Integer.MAX_VALUE;
        
        assertEquals(Integer.MAX_VALUE, subscription.type);
    }

    @Test
    public void setStatus_withAllEnumValues_storesCorrectly() {
        Subscription subscription = new Subscription();
        
        for (SubscriptionStatus status : SubscriptionStatus.values()) {
            subscription.status = status;
            assertEquals(status, subscription.status);
        }
    }

    @Test
    public void fields_independentlyModifiable() {
        Subscription subscription = new Subscription();
        
        subscription.type = 10;
        assertEquals(10, subscription.type);
        assertNull(subscription.status);
        
        subscription.status = SubscriptionStatus.SUBSCRIBED;
        assertEquals(10, subscription.type);
        assertEquals(SubscriptionStatus.SUBSCRIBED, subscription.status);
    }
}

