package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SuspensionTest {
    @Test
    void testConstructorAndAccessors() {
        Boolean succeeded = true;
        int sportId = 1;
        Integer locationId = 2;
        int competitionId = 3;
        Integer fixtureId = 4;
        LocalDateTime creationDate = LocalDateTime.now();
        List<Market> markets = List.of(new Market(5, "line"));
        Suspension s = new Suspension(succeeded, sportId, locationId, competitionId, fixtureId, creationDate, markets);
        assertEquals(succeeded, s.succeeded());
        assertEquals(sportId, s.sportId());
        assertEquals(locationId, s.locationId());
        assertEquals(competitionId, s.competitionId());
        assertEquals(fixtureId, s.fixtureId());
        assertEquals(creationDate, s.creationDate());
        assertEquals(markets, s.markets());
    }
} 