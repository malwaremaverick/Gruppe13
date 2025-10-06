package no.gruppe13.kollektiv.prefs;

import no.gruppe13.kollektiv.shared.Mode;
import java.util.EnumSet;

// lagrer hva brukeren har valgt (tilpasses/endres senere til ekte lagring).
public interface PreferencesStore {
    EnumSet<Mode> loadSelectedModes();
    void saveSelectedModes(EnumSet<Mode> modes);

}