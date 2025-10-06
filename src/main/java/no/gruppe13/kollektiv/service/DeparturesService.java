

// etter at man har hentet alle avganger:

package no.gruppe13.kollektiv.service;

import java.util.List;
import no.gruppe13.kollektiv.domain.Departure;
import no.gruppe13.kollektiv.filter.FilterService;
import no.gruppe13.kollektiv.filter.FilterSettings;

public class DeparturesService {
    public List<Departure> getFilteredDepartures(List<Departure> all, FilterSettings fs) {
        return FilterService.filterDepartures(all, fs);
    }
}