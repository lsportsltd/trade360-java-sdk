package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Participant;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GetOutrightEventsResultElementTest {
    @Test
    void testConstructorAndFields() {
        GetOutrightEventsResultElement element = new GetOutrightEventsResultElement();
        element.id = 1;
        element.name = "event";
        element.type = 2;
        element.events = Collections.emptyList();
        assertEquals(1, element.id);
        assertEquals("event", element.name);
        assertEquals(2, element.type);
        assertNotNull(element.events);
    }

    @Test
    void testDeserializeKeepsParticipantExtraData() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String payload = """
                [
                  {
                    "Id": 1,
                    "Name": "Horse Racing",
                    "Type": 1,
                    "Events": [
                      {
                        "FixtureId": 20749385,
                        "OutrightFixture": {
                          "FixtureName": "Dundalk",
                          "Participants": [
                            {
                              "Id": 52071799,
                              "Name": "Suerte",
                              "ExtraData": [
                                { "Name": "Form", "Value": "1-2-3" },
                                { "Name": "JockeyWeight", "Value": "58" },
                                { "Name": "IsRunning", "Value": "true" },
                                { "Name": "ProgramNumber", "Value": "7" },
                                { "Name": "TrainerName", "Value": "A. Trainer" },
                                { "Name": "Jockey", "Value": "R. Smith" },
                                { "Name": "Breeder", "Value": "B. Breeder" }
                              ]
                            },
                            {
                              "Id": 52071800,
                              "Name": "No Extra"
                            }
                          ]
                        }
                      }
                    ]
                  }
                ]
                """;

        List<GetOutrightEventsResultElement> response = objectMapper.readValue(
                payload, new TypeReference<List<GetOutrightEventsResultElement>>() {});

        assertEquals(1, response.size());
        OutrightEventElement event = response.get(0).events.iterator().next();
        assertEquals(20749385, event.fixtureId);

        List<Participant> participants = (List<Participant>) event.outrightFixture.participants;
        assertEquals(2, participants.size());

        Participant suerte = participants.get(0);
        assertEquals(52071799, suerte.id);
        assertEquals("Suerte", suerte.name);
        Map<String, String> extraData = new HashMap<>();
        for (NameValuePair pair : suerte.extraData) {
            extraData.put(pair.name, pair.value);
        }
        assertEquals("1-2-3", extraData.get("Form"));
        assertEquals("58", extraData.get("JockeyWeight"));
        assertEquals("true", extraData.get("IsRunning"));
        assertEquals("7", extraData.get("ProgramNumber"));
        assertEquals("A. Trainer", extraData.get("TrainerName"));
        assertEquals("R. Smith", extraData.get("Jockey"));
        assertEquals("B. Breeder", extraData.get("Breeder"));

        assertNull(participants.get(1).extraData);
    }
}
