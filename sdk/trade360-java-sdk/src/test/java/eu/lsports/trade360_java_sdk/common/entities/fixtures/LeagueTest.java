package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeagueTest {
    @Test
    void testFieldAssignmentAndNullability() {
        League league = new League();
        assertEquals(0, league.id);
        assertNull(league.name);
        assertNull(league.tour);
        assertNull(league.ageCategory);
        assertNull(league.gender);
        assertNull(league.type);
        assertNull(league.numberOfPeriods);
        assertNull(league.sportCategory);

        league.id = 7;
        league.name = "Premier League";
        league.tour = new IdNamePair(10, "European Tour");
        league.ageCategory = 21;
        league.gender = 1;
        league.type = 2;
        league.numberOfPeriods = 2;
        league.sportCategory = new IdNamePair(1, "Football");

        assertEquals(7, league.id);
        assertEquals("Premier League", league.name);
        assertNotNull(league.tour);
        assertEquals(10, league.tour.id());
        assertEquals("European Tour", league.tour.name());
        assertEquals(21, league.ageCategory);
        assertEquals(1, league.gender);
        assertEquals(2, league.type);
        assertEquals(2, league.numberOfPeriods);
        assertNotNull(league.sportCategory);
        assertEquals(1, league.sportCategory.id());
        assertEquals("Football", league.sportCategory.name());
    }

    @Test
    void testTourAssignment() {
        League league = new League();
        IdNamePair tour = new IdNamePair(5, "World Tour");

        league.tour = tour;

        assertNotNull(league.tour);
        assertEquals(5, league.tour.id());
        assertEquals("World Tour", league.tour.name());
    }

    @Test
    void testSportCategoryAssignment() {
        League league = new League();
        IdNamePair sportCategory = new IdNamePair(2, "Basketball");

        league.sportCategory = sportCategory;

        assertNotNull(league.sportCategory);
        assertEquals(2, league.sportCategory.id());
        assertEquals("Basketball", league.sportCategory.name());
    }

    @Test
    void testAgeCategoryAssignment() {
        League league = new League();

        league.ageCategory = 18;
        assertEquals(18, league.ageCategory);

        league.ageCategory = 0;
        assertEquals(0, league.ageCategory);

        league.ageCategory = null;
        assertNull(league.ageCategory);
    }

    @Test
    void testGenderAssignment() {
        League league = new League();

        league.gender = 1;
        assertEquals(1, league.gender);

        league.gender = 2;
        assertEquals(2, league.gender);

        league.gender = null;
        assertNull(league.gender);
    }

    @Test
    void testTypeAssignment() {
        League league = new League();

        league.type = 1;
        assertEquals(1, league.type);

        league.type = 3;
        assertEquals(3, league.type);

        league.type = null;
        assertNull(league.type);
    }

    @Test
    void testNumberOfPeriodsAssignment() {
        League league = new League();

        league.numberOfPeriods = 2;
        assertEquals(2, league.numberOfPeriods);

        league.numberOfPeriods = 4;
        assertEquals(4, league.numberOfPeriods);

        league.numberOfPeriods = null;
        assertNull(league.numberOfPeriods);
    }

    @Test
    void testAllFieldsTogether() {
        League league = new League();

        league.id = 100;
        league.name = "UEFA Champions League";
        league.tour = new IdNamePair(1, "European Competition");
        league.ageCategory = 0;
        league.gender = 1;
        league.type = 1;
        league.numberOfPeriods = 2;
        league.sportCategory = new IdNamePair(1, "Football");

        assertEquals(100, league.id);
        assertEquals("UEFA Champions League", league.name);
        assertEquals("European Competition", league.tour.name());
        assertEquals(0, league.ageCategory);
        assertEquals(1, league.gender);
        assertEquals(1, league.type);
        assertEquals(2, league.numberOfPeriods);
        assertEquals("Football", league.sportCategory.name());
    }
}
