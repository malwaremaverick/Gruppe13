package no.gruppe13.kollektiv.prefs;

import no.gruppe13.kollektiv.filter.FilterSettings;
import no.gruppe13.kollektiv.shared.Mode;

import java.util.EnumSet;

// Lagrer i minnet. Kan byttes til db senere.
public class InMemoryPreferencesStore implements PreferencesStore {
    private EnumSet<Mode> cached = FilterSettings.allOn().getAllowedModes();

    @Override
    public EnumSet<Mode> loadSelectedModes() {
        return EnumSet.copyOf(cached);
    }

    @Override
    public void saveSelectedModes(EnumSet<Mode> modes) {
        cached = (modes == null || modes.isEmpty())
                ? FilterSettings.allOn().getAllowedModes()
                : EnumSet.copyOf(modes);
    }
}

