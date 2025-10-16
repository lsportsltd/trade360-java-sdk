package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgeCategoryTest {

    @Test
    void testAgeCategoryValues() {
        assertEquals(0, AgeCategory.REGULAR.getValue());
        assertEquals(1, AgeCategory.YOUTH.getValue());
        assertEquals(2, AgeCategory.RESERVES.getValue());
    }

    @Test
    void testAgeCategoryEnumCount() {
        assertEquals(3, AgeCategory.values().length);
    }

    @Test
    void testAgeCategoryValueOf() {
        assertEquals(AgeCategory.REGULAR, AgeCategory.valueOf("REGULAR"));
        assertEquals(AgeCategory.YOUTH, AgeCategory.valueOf("YOUTH"));
        assertEquals(AgeCategory.RESERVES, AgeCategory.valueOf("RESERVES"));
    }
}

