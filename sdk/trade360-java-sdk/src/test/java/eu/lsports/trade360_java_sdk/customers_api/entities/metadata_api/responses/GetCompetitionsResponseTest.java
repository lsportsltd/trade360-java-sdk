package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetCompetitionsResponseTest {
    @Test
    void testConstructorAndFields() {
        CompetitionMetadata cm = new CompetitionMetadata(1, "Competition", 2, 3);
        List<CompetitionMetadata> competitions = List.of(cm);
        GetCompetitionsResponse resp = new GetCompetitionsResponse(competitions);
        assertEquals(competitions, resp.competitions());
    }
} 