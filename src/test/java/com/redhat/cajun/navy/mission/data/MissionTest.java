package com.redhat.cajun.navy.mission.data;

import io.vertx.core.json.Json;
import org.junit.Test;

import static org.junit.Assert.*;

public class MissionTest {


    @Test
    public void testMissonEncode(){
        String value = "{\"id\":\"421f3e01-4cab-4022-a578-7fd4ac6038b0\",\"incidentId\":\"98965816-e6eb-4edc-9b85-9a6b6ca474b3\",\"responderId\":\"responderId\",\"responderStartLat\":29.789,\"responderStartLong\":-95.6332,\"incidentLat\":29.7476,\"incidentLong\":-95.3691,\"destinationLat\":29.7576,\"destinationLong\":-95.3591,\"responderLocationHistory\":null,\"status\":null,\"route\":{\"distance\":31988.1,\"duration\":1888.8,\"steps\":[{\"distance\":2.6,\"duration\":5.5,\"name\":\"Park Row\",\"instruction\":\"Head west on Park Row\",\"weight\":37.7,\"loc\":{\"lat\":29.788405,\"long\":-95.633189}},{\"distance\":1521.4,\"duration\":114.0,\"name\":\"Park Row\",\"instruction\":\"Make a U-turn and continue on Park Row\",\"weight\":180.3,\"loc\":{\"lat\":29.788405,\"long\":-95.633216}},{\"distance\":338.0,\"duration\":48.599999999999994,\"name\":\"North Eldridge Parkway\",\"instruction\":\"Turn right onto North Eldridge Parkway\",\"weight\":104.8,\"loc\":{\"lat\":29.787386,\"long\":-95.617788}},{\"distance\":546.6,\"duration\":30.499999999999996,\"name\":\"Katy Freeway Frontage Road\",\"instruction\":\"Turn left onto Katy Freeway Frontage Road\",\"weight\":49.5,\"loc\":{\"lat\":29.784352,\"long\":-95.617898}},{\"distance\":385.5,\"duration\":17.6,\"name\":\"\",\"instruction\":\"Take the ramp on the left towards I-10 East\",\"weight\":23.2,\"loc\":{\"lat\":29.784316,\"long\":-95.612236}},{\"distance\":10673.3,\"duration\":413.40000000000003,\"name\":\"Katy Freeway (I-10; US 90 East)\",\"instruction\":\"Merge left onto I-10\",\"weight\":420.0000000000001,\"loc\":{\"lat\":29.784559,\"long\":-95.608252}},{\"distance\":486.3,\"duration\":20.8,\"name\":\"\",\"instruction\":\"Take exit 761 towards Wirt Road\",\"weight\":27.9,\"loc\":{\"lat\":29.784066,\"long\":-95.497698}},{\"distance\":2931.5,\"duration\":177.6,\"name\":\"Katy Freeway Frontage Road\",\"instruction\":\"Merge right onto Katy Freeway Frontage Road\",\"weight\":245.60000000000002,\"loc\":{\"lat\":29.783618,\"long\":-95.492688}},{\"distance\":1068.9,\"duration\":47.900000000000006,\"name\":\"\",\"instruction\":\"Take the ramp on the left towards I-10 East\",\"weight\":54.300000000000004,\"loc\":{\"lat\":29.783622,\"long\":-95.462369}},{\"distance\":8463.1,\"duration\":362.1,\"name\":\"Katy Freeway (I-10; US 90)\",\"instruction\":\"Merge left onto I-10\",\"weight\":369.2,\"loc\":{\"lat\":29.779563,\"long\":-95.452603}},{\"distance\":240.9,\"duration\":34.8,\"name\":\"\",\"instruction\":\"Take exit 768B on the left towards I-45 South: Galveston\",\"weight\":40.3,\"loc\":{\"lat\":29.773936,\"long\":-95.368035}},{\"distance\":1154.5,\"duration\":71.0,\"name\":\"I-45 South\",\"instruction\":\"Merge left onto I-45 South\",\"weight\":77.0,\"loc\":{\"lat\":29.772132,\"long\":-95.366655}},{\"distance\":432.2,\"duration\":21.2,\"name\":\"\",\"instruction\":\"Take exit 47D towards Dallas Street\",\"weight\":28.2,\"loc\":{\"lat\":29.763482,\"long\":-95.370338}},{\"distance\":1081.7,\"duration\":62.4,\"name\":\"Pierce Elevated\",\"instruction\":\"Continue onto Pierce Elevated\",\"weight\":76.8,\"loc\":{\"lat\":29.761611,\"long\":-95.374144}},{\"distance\":809.2,\"duration\":136.9,\"name\":\"Pierce Street\",\"instruction\":\"Turn left onto Pierce Street\",\"weight\":257.2,\"loc\":{\"lat\":29.75207,\"long\":-95.375137}},{\"distance\":77.9,\"duration\":15.0,\"name\":\"Caroline Street\",\"instruction\":\"Turn right onto Caroline Street\",\"weight\":28.7,\"loc\":{\"lat\":29.747922,\"long\":-95.368254}},{\"distance\":49.4,\"duration\":22.2,\"name\":\"\",\"instruction\":\"Turn right\",\"weight\":89.3,\"loc\":{\"lat\":29.74734,\"long\":-95.368703}},{\"distance\":0.0,\"duration\":0.0,\"name\":\"\",\"instruction\":\"You have arrived at your 1st destination\",\"weight\":0.0,\"loc\":{\"lat\":29.747578,\"long\":-95.369117}},{\"distance\":49.8,\"duration\":27.8,\"name\":\"\",\"instruction\":\"Head northwest\",\"weight\":126.8,\"loc\":{\"lat\":29.747578,\"long\":-95.369117}},{\"distance\":1294.6,\"duration\":183.10000000000002,\"name\":\"San Jacinto Street\",\"instruction\":\"Turn left onto San Jacinto Street\",\"weight\":387.2,\"loc\":{\"lat\":29.74786,\"long\":-95.369372}},{\"distance\":202.6,\"duration\":35.4,\"name\":\"Rusk Street\",\"instruction\":\"Turn right onto Rusk Street\",\"weight\":92.4,\"loc\":{\"lat\":29.757403,\"long\":-95.362002}},{\"distance\":178.0,\"duration\":41.0,\"name\":\"Austin Street\",\"instruction\":\"Turn left onto Austin Street\",\"weight\":53.1,\"loc\":{\"lat\":29.756362,\"long\":-95.36028}},{\"distance\":0.0,\"duration\":0.0,\"name\":\"Austin Street\",\"instruction\":\"You have arrived at your destination, on the right\",\"weight\":0.0,\"loc\":{\"lat\":29.757685,\"long\":-95.359243}}]}}";
        Mission m = Json.decodeValue(value, Mission.class);
        System.out.println(m);
        assertNotNull(m);
        assertNotNull(m.getRoute());
        assertNotNull(m.getRoute().getSteps());
    }

    @Test
    public void testMissionEquals(){
        String j1 = "{\"id\":\"6932de7b-8435-4ded-8f32-c3e5b704998c\",\"messageType\":\"CreateMissionCommand\",\"invokingService\":\"ProcessService\",\"timestamp\":1552899692390,\"body\":{\"incidentId\":\"98965816-e6eb-4edc-9b85-9a6b6ca474b3\",\"responderId\":\"responderId\",\"responderStartLat\":\"31.12345\",\"responderStartLong\":\"-71.98765\",\"incidentLat\":\"30.12345\",\"incidentLong\":\"-70.98765\",\"destinationLat\":\"32.12345\",\"destinationLong\":\"-72.98765\"}}";
        String j2 = "{\"id\":\"6932de7b-8435-4ded-8f32-c3e5b704999c\",\"messageType\":\"CreateMissionCommand\",\"invokingService\":\"ProcessService\",\"timestamp\":1552899692390,\"body\":{\"incidentId\":\"98965816-e6eb-4edc-9b85-9a6b6ca474b3\",\"responderId\":\"responderId\",\"responderStartLat\":\"29.7890\",\"responderStartLong\":\"-95.6332\",\"incidentLat\":\"29.7476\",\"incidentLong\":\"-95.3691\",\"destinationLat\":\"29.7576\",\"destinationLong\":\"-95.3591\"}}";


        MissionCommand m1 = Json.decodeValue(j1, MissionCommand.class);
        MissionCommand m2 = Json.decodeValue(j2, MissionCommand.class);

        assertEquals(m1.getBody(), m2.getBody());

    }

    public void testMissionNotEquals() {
        String j1 = "{\"id\":\"6932de7b-8435-4ded-8f32-c3e5b704998c\",\"messageType\":\"CreateMissionCommand\",\"invokingService\":\"ProcessService\",\"timestamp\":1552899692390,\"body\":{\"incidentId\":\"98965816-e6eb-4edc-9b85-9a6b6ca474b3\",\"responderId\":\"responderAAd\",\"responderStartLat\":\"31.12345\",\"responderStartLong\":\"-71.98765\",\"incidentLat\":\"30.12345\",\"incidentLong\":\"-70.98765\",\"destinationLat\":\"32.12345\",\"destinationLong\":\"-72.98765\"}}";
        String j2 = "{\"id\":\"6932de7b-8435-4ded-8f32-c3e5b704999c\",\"messageType\":\"CreateMissionCommand\",\"invokingService\":\"ProcessService\",\"timestamp\":1552899692390,\"body\":{\"incidentId\":\"98965816-e6eb-4edc-9b85-9a6b6ca474b3\",\"responderId\":\"responderId\",\"responderStartLat\":\"29.7890\",\"responderStartLong\":\"-95.6332\",\"incidentLat\":\"29.7476\",\"incidentLong\":\"-95.3691\",\"destinationLat\":\"29.7576\",\"destinationLong\":\"-95.3591\"}}";


        MissionCommand m1 = Json.decodeValue(j1, MissionCommand.class);
        MissionCommand m2 = Json.decodeValue(j2, MissionCommand.class);

        assertNotEquals(m1.getBody(), m2.getBody());
    }
}