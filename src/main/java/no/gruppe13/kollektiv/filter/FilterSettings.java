package no.gruppe13.kollektiv.filter;

import no.gruppe13.kollektiv.shared.Mode;
import java.util.EnumSet;

// Hvilke transporttyper er tillatt når vi viser lister?
public class FilterSettings {
    private final EnumSet<Mode> allowedModes;
    private final boolean alwaysAllowWalk; // behold gange 'legs' i reiser

    private FilterSettings(EnumSet<Mode> allowedModes, boolean alwaysAllowWalk) {
        this.allowedModes = EnumSet.copyOf(allowedModes);
        this.alwaysAllowWalk = alwaysAllowWalk;
    }

    // Standard: alt tillatt (unntatt WALK/OTHER som håndteres for seg selv)
    public static FilterSettings allOn() {
        EnumSet<Mode> all = EnumSet.of(
            Mode.BUS, Mode.TRAIN, Mode.TRAM, Mode.METRO, Mode.FERRY
        );
        return new FilterSettings(all, true);
    }

    public EnumSet<Mode> getAllowedModes() {
        return EnumSet.copyOf(allowedModes);
    }

    public boolean isAlwaysAllowWalk() {
        return alwaysAllowWalk;
    }

    // Ny instans med nye valg. om tomt, så fallback til allOn().
    public FilterSettings withAllowed(EnumSet<Mode> modes) {
        if (modes == null || modes.isEmpty()) {
            return allOn();
        }
        return new FilterSettings(modes, this.alwaysAllowWalk);
    }
}