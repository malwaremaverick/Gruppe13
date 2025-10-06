package no.gruppe13.kollektiv.filter;

import no.gruppe13.kollektiv.domain.Departure;
import no.gruppe13.kollektiv.domain.Journey;
import no.gruppe13.kollektiv.domain.Leg;
import no.gruppe13.kollektiv.shared.Mode;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

// Tar inn en liste og returnerer en filtrert liste.
public final class FilterService {
    private FilterService() {}

    // A) Filtrer avgangslisten (stoppvisning)
    public static List<Departure> filterDepartures(List<Departure> source, FilterSettings fs) {
        EnumSet<Mode> allowed = fs.getAllowedModes();
        List<Departure> result = new ArrayList<>();
        for (Departure d : source) {
            if (allowed.contains(d.getMode())) {
                result.add(d);
            }
        }
        return result;
    }

    // B) Filtrer reiser (A→B): alle transport-legs må være tillatt.
    // Gange (WALK) kan beholdes hvis allowWalk = true.
    public static List<Journey> filterJourneys(List<Journey> source, FilterSettings fs) {
        EnumSet<Mode> allowed = fs.getAllowedModes();
        boolean allowWalk = fs.isAlwaysAllowWalk();

        List<Journey> result = new ArrayList<>();
        for (Journey j : source) {
            if (journeyAllowed(j, allowed, allowWalk)) {
                result.add(j);
            }
        }
        return result;
    }

    private static boolean journeyAllowed(Journey j, EnumSet<Mode> allowed, boolean allowWalk) {
        for (Leg leg : j.getLegs()) {
            Mode m = leg.getMode();
            if (m == Mode.WALK && allowWalk) continue; // behold gang-legs
            if (!allowed.contains(m)) return false;     // om "feil" bein → avbryt reisen
        }
        return true;
    }
}