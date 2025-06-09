package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LivescoreExtraDataTest {

    @Test
    void testFieldAssignments() {
        LivescoreExtraData extraData = new LivescoreExtraData();
        
        extraData.setAttendance(50000);
        assertEquals(50000, extraData.getAttendance());
        
        extraData.setWeather("Sunny");
        assertEquals("Sunny", extraData.getWeather());
        
        extraData.setTemperature("25°C");
        assertEquals("25°C", extraData.getTemperature());
        
        extraData.setStadium("Wembley Stadium");
        assertEquals("Wembley Stadium", extraData.getStadium());
        
        extraData.setReferee("John Smith");
        assertEquals("John Smith", extraData.getReferee());
        
        extraData.setNote("Important match");
        assertEquals("Important match", extraData.getNote());
    }

    @Test
    void testNullValues() {
        LivescoreExtraData extraData = new LivescoreExtraData();
        
        assertNull(extraData.getWeather());
        assertNull(extraData.getTemperature());
        assertNull(extraData.getStadium());
        assertNull(extraData.getReferee());
        assertNull(extraData.getNote());
    }

    @Test
    void testDefaultValues() {
        LivescoreExtraData extraData = new LivescoreExtraData();
        
        assertEquals(0, extraData.getAttendance());
    }

    @Test
    void testEmptyStringValues() {
        LivescoreExtraData extraData = new LivescoreExtraData();
        
        extraData.setWeather("");
        assertEquals("", extraData.getWeather());
        
        extraData.setTemperature("");
        assertEquals("", extraData.getTemperature());
        
        extraData.setStadium("");
        assertEquals("", extraData.getStadium());
    }
}
