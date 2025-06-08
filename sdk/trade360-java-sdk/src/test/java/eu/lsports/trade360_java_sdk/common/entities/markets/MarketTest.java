package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class MarketTest {
    private Market market;

    @BeforeEach
    void setUp() {
        market = new Market();
    }

    @Test
    void testInstantiation() {
        assertNotNull(market);
        assertEquals(0, market.id);
        assertNull(market.name);
        assertNull(market.bets);
        assertNull(market.providerMarkets);
        assertNull(market.mainLine);
    }

    @Test
    void testFieldAssignment() {
        market.id = 100;
        market.name = "Over/Under 2.5 Goals";
        market.mainLine = "2.5";

        assertEquals(100, market.id);
        assertEquals("Over/Under 2.5 Goals", market.name);
        assertEquals("2.5", market.mainLine);
    }

    @Test
    void testBetsCollection() {
        List<Bet> bets = new ArrayList<>();
        Bet bet1 = new Bet();
        bet1.providerBetId = "bet1";
        Bet bet2 = new Bet();
        bet2.providerBetId = "bet2";
        
        bets.add(bet1);
        bets.add(bet2);
        
        market.bets = bets;
        
        assertNotNull(market.bets);
        assertEquals(2, ((List<Bet>) market.bets).size());
    }

    @Test
    void testProviderMarketsCollection() {
        List<ProviderMarket> providerMarkets = new ArrayList<>();
        ProviderMarket pm1 = new ProviderMarket();
        ProviderMarket pm2 = new ProviderMarket();
        
        providerMarkets.add(pm1);
        providerMarkets.add(pm2);
        
        market.providerMarkets = providerMarkets;
        
        assertNotNull(market.providerMarkets);
        assertEquals(2, ((List<ProviderMarket>) market.providerMarkets).size());
    }

    @Test
    void testNullableFieldsHandling() {
        market.name = "Test Market";
        assertEquals("Test Market", market.name);
        
        market.name = null;
        assertNull(market.name);
        
        market.mainLine = "1.5";
        assertEquals("1.5", market.mainLine);
        
        market.mainLine = null;
        assertNull(market.mainLine);
    }

    @Test
    void testEmptyCollections() {
        market.bets = new ArrayList<>();
        market.providerMarkets = new ArrayList<>();
        
        assertNotNull(market.bets);
        assertNotNull(market.providerMarkets);
        assertEquals(0, ((List<Bet>) market.bets).size());
        assertEquals(0, ((List<ProviderMarket>) market.providerMarkets).size());
    }

    @Test
    void testCompleteMarketData() {
        List<Bet> bets = new ArrayList<>();
        Bet bet = new Bet();
        bet.providerBetId = "test-bet";
        bets.add(bet);
        
        List<ProviderMarket> providerMarkets = new ArrayList<>();
        ProviderMarket pm = new ProviderMarket();
        providerMarkets.add(pm);
        
        market.id = 500;
        market.name = "Match Winner";
        market.bets = bets;
        market.providerMarkets = providerMarkets;
        market.mainLine = "0";
        
        assertEquals(500, market.id);
        assertEquals("Match Winner", market.name);
        assertEquals("0", market.mainLine);
        assertNotNull(market.bets);
        assertNotNull(market.providerMarkets);
        assertEquals(1, ((List<Bet>) market.bets).size());
        assertEquals(1, ((List<ProviderMarket>) market.providerMarkets).size());
    }
}   