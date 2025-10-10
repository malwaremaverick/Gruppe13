import java.util.*;

public class StopService {
    private List<Stop> stops;
    private Map<String, List<Departure>> departuresByStop;

    public StopService(List<Stop> stops, Map<String, List<Departure>> departuresByStop) {
        this.stops = stops;
        this.departuresByStop = departuresByStop;
    }

    public Stop findStopByName(String name) {
        for (Stop stop : stops) {
            if (stop.getName().equalsIgnoreCase(name)) {
                return stop;
            }
        }
        return null;
    }

    public List<Departure> getDeparturesForStop(String stopId) {
        return departuresByStop.getOrDefault(stopId, new ArrayList<>());
    }
}