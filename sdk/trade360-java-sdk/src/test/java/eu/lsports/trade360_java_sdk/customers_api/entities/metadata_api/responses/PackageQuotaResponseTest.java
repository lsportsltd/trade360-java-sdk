package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class PackageQuotaResponseTest {
    @Test
    void testConstructorAndFields() {
        int creditRemaining = 10;
        int creditLimit = 20;
        int usedCredit = 5;
        Instant start = Instant.now();
        Instant end = Instant.now();
        PackageQuotaResponse resp = new PackageQuotaResponse(creditRemaining, creditLimit, usedCredit, start, end);
        assertEquals(creditRemaining, resp.creditRemaining());
        assertEquals(creditLimit, resp.creditLimit());
        assertEquals(usedCredit, resp.usedCredit());
        assertEquals(start, resp.currentPeriodStartDate());
        assertEquals(end, resp.currentPeriodEndDate());
    }
} 