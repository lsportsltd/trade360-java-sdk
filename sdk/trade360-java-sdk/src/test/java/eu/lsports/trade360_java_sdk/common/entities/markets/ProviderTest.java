package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class ProviderTest {
    @Test
    void testInstantiation() {
        Provider provider = new Provider();
        assertNotNull(provider);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        Provider provider = new Provider();
        assertEquals(0, provider.id);
        assertNull(provider.name);
        assertNull(provider.lastUpdate);
        assertNull(provider.providerFixtureId);
        assertNull(provider.providerLeagueId);
        assertNull(provider.providerMarketId);
        assertNull(provider.bets);

        provider.id = 7;
        provider.name = "ProviderName";
        LocalDateTime now = LocalDateTime.now();
        provider.lastUpdate = now;
        provider.providerFixtureId = "fix123";
        provider.providerLeagueId = "league123";
        provider.providerMarketId = "market123";
        provider.bets = null;

        assertEquals(7, provider.id);
        assertEquals("ProviderName", provider.name);
        assertEquals(now, provider.lastUpdate);
        assertEquals("fix123", provider.providerFixtureId);
        assertEquals("league123", provider.providerLeagueId);
        assertEquals("market123", provider.providerMarketId);
        assertNull(provider.bets);
    }
} 