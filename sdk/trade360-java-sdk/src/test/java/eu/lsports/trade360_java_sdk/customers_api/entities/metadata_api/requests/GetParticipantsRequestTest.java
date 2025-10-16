package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import eu.lsports.trade360_java_sdk.common.entities.enums.AgeCategory;
import eu.lsports.trade360_java_sdk.common.entities.enums.Gender;
import eu.lsports.trade360_java_sdk.common.entities.enums.ParticipantType;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class GetParticipantsRequestTest {

    @Test
    void testConstructorWithFilterAndPagination() {
        GetParticipantsRequest.ParticipantsFilter filter = new GetParticipantsRequest.ParticipantsFilter(
            Arrays.asList(1, 2, 3),
            Arrays.asList(10, 20),
            Arrays.asList(100, 200),
            "Team Name",
            Gender.MEN,
            AgeCategory.YOUTH,
            ParticipantType.CLUB
        );
        GetParticipantsRequest request = new GetParticipantsRequest(filter, 1, 50);
        
        assertNotNull(request);
        assertNotNull(request.filter());
        assertEquals(filter, request.filter());
        assertEquals(1, request.page());
        assertEquals(50, request.pageSize());
    }

    @Test
    void testConstructorWithNullFilter() {
        GetParticipantsRequest request = new GetParticipantsRequest(null, 1, 50);
        
        assertNotNull(request);
        assertNull(request.filter());
        assertEquals(1, request.page());
        assertEquals(50, request.pageSize());
    }

    @Test
    void testParticipantsFilterWithAllFields() {
        Iterable<Integer> ids = Arrays.asList(1, 2, 3);
        Iterable<Integer> sportIds = Arrays.asList(10, 20);
        Iterable<Integer> locationIds = Arrays.asList(100, 200);
        String name = "Test Name";
        Gender gender = Gender.WOMEN;
        AgeCategory ageCategory = AgeCategory.REGULAR;
        ParticipantType type = ParticipantType.NATIONAL;
        
        GetParticipantsRequest.ParticipantsFilter filter = new GetParticipantsRequest.ParticipantsFilter(
            ids, sportIds, locationIds, name, gender, ageCategory, type
        );
        
        assertNotNull(filter);
        assertEquals(ids, filter.ids());
        assertEquals(sportIds, filter.sportIds());
        assertEquals(locationIds, filter.locationIds());
        assertEquals(name, filter.name());
        assertEquals(gender, filter.gender());
        assertEquals(ageCategory, filter.ageCategory());
        assertEquals(type, filter.type());
    }

    @Test
    void testParticipantsFilterWithNullFields() {
        GetParticipantsRequest.ParticipantsFilter filter = new GetParticipantsRequest.ParticipantsFilter(
            null, null, null, null, null, null, null
        );
        
        assertNotNull(filter);
        assertNull(filter.ids());
        assertNull(filter.sportIds());
        assertNull(filter.locationIds());
        assertNull(filter.name());
        assertNull(filter.gender());
        assertNull(filter.ageCategory());
        assertNull(filter.type());
    }

    @Test
    void testParticipantsFilterWithEmptyCollections() {
        Iterable<Integer> empty = Collections.emptyList();
        
        GetParticipantsRequest.ParticipantsFilter filter = new GetParticipantsRequest.ParticipantsFilter(
            empty, empty, empty, "", null, null, null
        );
        
        assertNotNull(filter);
        assertEquals(empty, filter.ids());
        assertEquals(empty, filter.sportIds());
        assertEquals(empty, filter.locationIds());
        assertEquals("", filter.name());
    }

    @Test
    void testParticipantsFilterWithMixedNullAndNonNull() {
        Iterable<Integer> sportIds = Arrays.asList(1, 2);
        
        GetParticipantsRequest.ParticipantsFilter filter = new GetParticipantsRequest.ParticipantsFilter(
            null, sportIds, null, "Name", Gender.MIX, null, ParticipantType.INDIVIDUAL
        );
        
        assertNotNull(filter);
        assertNull(filter.ids());
        assertEquals(sportIds, filter.sportIds());
        assertNull(filter.locationIds());
        assertEquals("Name", filter.name());
        assertEquals(Gender.MIX, filter.gender());
        assertNull(filter.ageCategory());
        assertEquals(ParticipantType.INDIVIDUAL, filter.type());
    }

    @Test
    void testDifferentPageSizes() {
        GetParticipantsRequest.ParticipantsFilter filter = new GetParticipantsRequest.ParticipantsFilter(
            null, null, null, null, null, null, null
        );
        
        GetParticipantsRequest request1 = new GetParticipantsRequest(filter, 1, 10);
        GetParticipantsRequest request2 = new GetParticipantsRequest(filter, 2, 50);
        GetParticipantsRequest request3 = new GetParticipantsRequest(filter, 5, 100);
        
        assertEquals(1, request1.page());
        assertEquals(10, request1.pageSize());
        assertEquals(2, request2.page());
        assertEquals(50, request2.pageSize());
        assertEquals(5, request3.page());
        assertEquals(100, request3.pageSize());
    }

    @Test
    void testWithNullPageAndPageSize() {
        GetParticipantsRequest.ParticipantsFilter filter = new GetParticipantsRequest.ParticipantsFilter(
            null, null, null, null, null, null, null
        );
        
        GetParticipantsRequest request = new GetParticipantsRequest(filter, null, null);
        
        assertNotNull(request);
        assertNull(request.page());
        assertNull(request.pageSize());
    }

    @Test
    void testWithNullPage() {
        GetParticipantsRequest.ParticipantsFilter filter = new GetParticipantsRequest.ParticipantsFilter(
            null, Arrays.asList(1, 2), null, null, null, null, null
        );
        
        GetParticipantsRequest request = new GetParticipantsRequest(filter, null, 50);
        
        assertNotNull(request);
        assertNull(request.page());
        assertEquals(50, request.pageSize());
    }

    @Test
    void testWithNullPageSize() {
        GetParticipantsRequest.ParticipantsFilter filter = new GetParticipantsRequest.ParticipantsFilter(
            null, Arrays.asList(1, 2), null, null, null, null, null
        );
        
        GetParticipantsRequest request = new GetParticipantsRequest(filter, 1, null);
        
        assertNotNull(request);
        assertEquals(1, request.page());
        assertNull(request.pageSize());
    }
}

