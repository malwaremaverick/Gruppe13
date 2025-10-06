// etter at man har søkt ruter:

package no.gruppe13.kollektiv.service;

import java.util.List;
import no.gruppe13.kollektiv.domain.Journey;
import no.gruppe13.kollektiv.filter.FilterService;
import no.gruppe13.kollektiv.filter.FilterSettings;

public class JourneyService {
    public List<Journey> getFilteredJourneys(List<Journey> all, FilterSettings fs) {
        return FilterService.filterJourneys(all, fs);
    }
}