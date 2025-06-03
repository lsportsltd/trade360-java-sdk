package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueFixtureTest {
    @Test
    void testFieldAssignment() {
        OutrightLeagueFixture fixture = new OutrightLeagueFixture();
        fixture.subscription = new Subscription();
        fixture.lastUpdate = LocalDateTime.now();
        fixture.status = FixtureStatus.FINISHED;
        fixture.extraData = List.of(new NameValuePair());
        assertNotNull(fixture.subscription);
        assertNotNull(fixture.lastUpdate);
        assertEquals(FixtureStatus.FINISHED, fixture.status);
        assertNotNull(fixture.extraData);
    }
} 