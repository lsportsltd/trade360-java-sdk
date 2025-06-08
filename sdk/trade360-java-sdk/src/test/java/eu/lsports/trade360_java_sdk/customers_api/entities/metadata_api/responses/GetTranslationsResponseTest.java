package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetTranslationsResponseTest {
    @Test
    void testConstructorAndFields() {
        Map<Integer, Iterable<TranslationElement>> sports = Map.of(1, (Iterable<TranslationElement>) List.of(new TranslationElement(1, "A")));
        Map<Integer, Iterable<TranslationElement>> locations = Map.of();
        Map<Integer, Iterable<TranslationElement>> leagues = Map.of();
        Map<Integer, Iterable<TranslationElement>> markets = Map.of();
        Map<Integer, Iterable<TranslationElement>> participants = Map.of();
        GetTranslationsResponse resp = new GetTranslationsResponse(sports, locations, leagues, markets, participants);
        assertEquals(sports, resp.sports());
        assertEquals(locations, resp.locations());
        assertEquals(leagues, resp.leagues());
        assertEquals(markets, resp.markets());
        assertEquals(participants, resp.participants());
    }
} 