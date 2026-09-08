package eu.lsports.trade360_java_sdk.common.entities.markets;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import eu.lsports.trade360_java_sdk.common.entities.enums.BetStatus;
import eu.lsports.trade360_java_sdk.common.entities.enums.BetStatusId;
import eu.lsports.trade360_java_sdk.common.entities.enums.SettlementType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseBetBetStatusIdTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    void deserializeClosedMarketBetKeepsLegacyStatus() throws Exception {
        String json = """
                {
                  "Id": 1,
                  "Name": "Home",
                  "Status": 2,
                  "BetStatusId": 4
                }
                """;

        Bet bet = objectMapper.readValue(json, Bet.class);

        assertEquals(BetStatus.SUSPENDED, bet.status);
        assertEquals(BetStatusId.CLOSED, bet.betStatusId);
    }

    @ParameterizedTest
    @CsvSource({
        "1, OPEN, OPEN",
        "2, SUSPENDED, SUSPENDED",
        "3, SETTLED, SETTLED"
    })
    void deserializeOpenMarketBetCopiesStatusOntoBetStatusId(
            int statusValue, BetStatus expectedStatus, BetStatusId expectedBetStatusId) throws Exception {
        String json = """
                {
                  "Id": 1,
                  "Status": %d,
                  "BetStatusId": %d
                }
                """.formatted(statusValue, statusValue);

        Bet bet = objectMapper.readValue(json, Bet.class);

        assertEquals(expectedStatus, bet.status);
        assertEquals(expectedBetStatusId, bet.betStatusId);
    }

    @Test
    void deserializeSettlementBetKeepsOutcomeAndSetsSettled() throws Exception {
        String json = """
                {
                  "Id": 1,
                  "Name": "Home",
                  "Status": 3,
                  "BetStatusId": 3,
                  "Settlement": 2
                }
                """;

        Bet bet = objectMapper.readValue(json, Bet.class);

        assertEquals(BetStatus.SETTLED, bet.status);
        assertEquals(BetStatusId.SETTLED, bet.betStatusId);
        assertEquals(SettlementType.WINNER, bet.settlement);
    }

    @Test
    void deserializeLegacyPayloadLeavesBetStatusIdNull() throws Exception {
        String json = """
                {
                  "Id": 1,
                  "Status": 1,
                  "Settlement": 1
                }
                """;

        Bet bet = objectMapper.readValue(json, Bet.class);

        assertEquals(BetStatus.OPEN, bet.status);
        assertNull(bet.betStatusId);
        assertEquals(SettlementType.LOSER, bet.settlement);
    }
}
