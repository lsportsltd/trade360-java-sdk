package eu.lsports.trade360_java_sdk.common.entities.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    @Test
    void testFieldAssignments() {
        Entity entity = new Entity();
        
        entity.setId(123);
        assertEquals(123, entity.getId());
        
        entity.setName("Test Entity");
        assertEquals("Test Entity", entity.getName());
    }

    @Test
    void testNullValues() {
        Entity entity = new Entity();
        
        assertNull(entity.getName());
    }

    @Test
    void testDefaultValues() {
        Entity entity = new Entity();
        
        assertEquals(0, entity.getId());
    }

    @Test
    void testEmptyStringName() {
        Entity entity = new Entity();
        
        entity.setName("");
        assertEquals("", entity.getName());
    }

    @Test
    void testNegativeId() {
        Entity entity = new Entity();
        
        entity.setId(-1);
        assertEquals(-1, entity.getId());
    }
}
