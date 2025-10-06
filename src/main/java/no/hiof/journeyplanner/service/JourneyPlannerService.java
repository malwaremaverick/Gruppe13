package no.hiof.journeyplanner.service;

import no.hiof.journeyplanner.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class JourneyPlannerService {

    private final RealTimeFeedService realTimeFeedService = new RealTimeFeedService();

    public JourneyPlan planJourney(String from, String to, LocalDateTime arriveBy) {
        Stop sFrom = new Stop("S-A", from);
        Stop sTo = new Stop("S-B", to);

        ItineraryLeg leg = new ItineraryLeg();
        leg.setOrder(1);
        leg.setFromStop(sFrom);
        leg.setToStop(sTo);
        leg.setTransportType("Train");
        leg.setPlannedArrival(arriveBy.minusMinutes(3));
        leg.setPlannedDeparture(arriveBy.minusMinutes(78));

        realTimeFeedService.getDelay("Train-RE20").ifPresent(disruption -> {
            leg.setRealArrival(leg.getPlannedArrival().plusMinutes(3));
            leg.setDisruptionNote(disruption.getMessage());
        });

        JourneyPlan plan = new JourneyPlan();
        plan.setId(UUID.randomUUID().toString());
        plan.setLegs(List.of(leg));
        plan.setTotalDurationMinutes(75);
        plan.setScore(0.95);

        return plan;
    }
}
