package no.hiof.journeyplanner;

import no.hiof.journeyplanner.model.JourneyPlan;
import no.hiof.journeyplanner.service.JourneyPlannerService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class JourneyPlannerServiceTest {

    @Test
    void arriveByPlansJourneyAndAppliesRealtimeDelay() {
        JourneyPlannerService svc = new JourneyPlannerService();
        LocalDateTime arriveBy = LocalDateTime.parse("2025-09-25T17:30:00");
        JourneyPlan plan = svc.planJourney("Askim", "Halden", arriveBy);
        assertNotNull(plan);
        assertEquals(1, plan.getLegs().size());
        assertEquals(75, plan.getTotalDurationMinutes());
        assertEquals(arriveBy, plan.getLegs().get(0).getRealArrival());
    }
}
