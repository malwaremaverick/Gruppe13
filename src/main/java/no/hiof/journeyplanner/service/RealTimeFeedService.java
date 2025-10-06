package no.hiof.journeyplanner.service;

import no.hiof.journeyplanner.model.Disruption;
import java.util.Optional;

public class RealTimeFeedService {
    public Optional<Disruption> getDelay(String routeId) {
        if (routeId.equals("Train-RE20")) {
            return Optional.of(new Disruption("minor", "+3 min forsinkelse"));
        }
        return Optional.empty();
    }
}
