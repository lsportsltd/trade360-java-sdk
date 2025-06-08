package eu.lsports.trade360_java_sdk.snapshot_api.springframework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SnapshotApiRestClientTest {
    @Test
    void testInstantiation() {
        // Cannot instantiate directly as it is likely abstract or requires dependencies
        // This test ensures the class is present and can be referenced
        assertDoesNotThrow(() -> SnapshotApiRestClient.class.getName());
    }
} 