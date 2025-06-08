package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import eu.lsports.trade360_java_sdk.common.entities.enums.MarketType;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GetMarketsRequestTest {

    @Test
    void testConstructorAndAccessors() {
        List<Integer> sportIds = List.of(1, 2);
        List<Integer> locationIds = List.of(3, 4);
        List<Integer> leaguesIds = List.of(5, 6);
        List<Integer> marketsIds = List.of(7, 8);
        Boolean isSettleable = true;
        MarketType marketType = MarketType.STANDARD;
        Integer languageId = 10;
        GetMarketsRequest req = new GetMarketsRequest(sportIds, locationIds, leaguesIds, marketsIds, isSettleable, marketType, languageId);
        assertEquals(sportIds, req.sportIds());
        assertEquals(locationIds, req.locationIds());
        assertEquals(leaguesIds, req.leaguesIds());
        assertEquals(marketsIds, req.marketsIds());
        assertEquals(isSettleable, req.isSettleable());
        assertEquals(marketType, req.marketType());
        assertEquals(languageId, req.languageId());
    }

    @Test
    void testToString() {
        GetMarketsRequest req = new GetMarketsRequest(List.of(1), null, null, null, null, MarketType.OUTRIGHT, 5);
        String str = req.toString();
        assertTrue(str.contains("1"));
        assertTrue(str.contains("OUTRIGHT"));
        assertTrue(str.contains("5"));
    }
} 