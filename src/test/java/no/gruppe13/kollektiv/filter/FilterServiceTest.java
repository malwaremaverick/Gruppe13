package no.gruppe13.kollektiv.filter;

import no.gruppe13.kollektiv.domain.Departure;
import no.gruppe13.kollektiv.domain.Journey;
import no.gruppe13.kollektiv.domain.Leg;
import no.gruppe13.kollektiv.shared.Mode;
import no.gruppe13.kollektiv.shared.ModeMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Her tester jeg F4 (filtrering av transportmidler):
 * - filterDepartures: at bare valgte transporttyper vises i avgangslista
 * - filterJourneys: at en reise bare er med hvis alle bein følger filteret
 * - fallback når filteret blir tomt 
 * - mapping fra API-strenger til vår Mode-enum
 *
 */
class FilterServiceTest {


    /**
     * Lager en enkel avgang med bestemt transporttype eller mode. Lagt til randome verider også siden de er irrelebvante for filtreringen.  
     */
    private Departure dep(Mode m) {
        return new Departure(
            m,                        // transporttype vi vil teste
            "X",                      
            "Y",                      
            LocalDateTime.now(),      
            0                         
        );
    }

    /**
     * Lager en reise med legs med de bestemte transporttypene/modes.
     * Brukes for å teste at ALLE legs er tillatt i filteret.
     */
    private Journey j(Mode... modes) {
        List<Leg> legs = new ArrayList<>();
        for (Mode m : modes) {
            legs.add(new Leg(m, "A", "B")); // from/to er irrelevant for filtreringen
        }
        return new Journey(legs);
    }

    
    // ----TESTER FOR AVGANGER----
   

    @Test
    @DisplayName("Departures: viser kun tillatte transporttyper (f.eks. BUS og TRAIN)")
    void departures_respectsAllowedModes() {
        
        List<Departure> input = List.of(
            dep(Mode.BUS),
            dep(Mode.TRAM),
            dep(Mode.TRAIN)
        );
        FilterSettings fs = FilterSettings
            .allOn()                                  
            .withAllowed(EnumSet.of(Mode.BUS, Mode.TRAIN)); 

       
        List<Departure> out = FilterService.filterDepartures(input, fs);

       
        assertEquals(2, out.size(), "Forventer kun BUS og TRAIN i resultatet");
        assertTrue(out.stream().allMatch(d ->
                d.getMode() == Mode.BUS || d.getMode() == Mode.TRAIN),
            "Resultatet skal ikke inneholde andre modes enn BUS/ TRAIN");
    }


    // ---- TESTER FOR REISER (A→B) ----


    @Test
    @DisplayName("Journeys: ALLE bein må være tillatt; WALK (gange) er alltid OK")
    void journeys_allLegsMustBeAllowed_walkIsAllowed() {
        
        List<Journey> input = List.of(
            j(Mode.TRAIN, Mode.WALK),
            j(Mode.BUS, Mode.TRAM),
            j(Mode.FERRY)
        );
        FilterSettings fs = FilterSettings
            .allOn()
            .withAllowed(EnumSet.of(Mode.TRAIN, Mode.BUS)); 

        List<Journey> out = FilterService.filterJourneys(input, fs);

        assertEquals(1, out.size(), "Forventer at kun reisen med TRAIN+WALK er tillatt");
        List<Mode> modesOfFirst = out.get(0).getLegs().stream().map(Leg::getMode).toList();
        assertEquals(List.of(Mode.TRAIN, Mode.WALK), modesOfFirst);
    }

    // ---- FALLBACK  -----

    @Test
    @DisplayName("Tomt filter: faller tilbake til 'alt på'")
    void emptyAllowedModes_fallsBackToAllOn() {

        FilterSettings fs = FilterSettings.allOn().withAllowed(EnumSet.noneOf(Mode.class));
        List<Departure> input = List.of(dep(Mode.BUS), dep(Mode.TRAM));

        List<Departure> out = FilterService.filterDepartures(input, fs);

        assertEquals(2, out.size(), "Tomt filter skal gi fallback til 'alt på'");
    }

    // ----- MAPPING FRA API → ENUM ----

    @Test
    @DisplayName("ModeMapper: aksepterer forskjellige navn av samme type kjøretøy (rail/train, subway/metro, boat/ferry)")
    void mapper_mapsCommonApiValues() {

        assertEquals(Mode.BUS,   ModeMapper.fromApi("bus"));
        assertEquals(Mode.TRAIN, ModeMapper.fromApi("rail"));   
        assertEquals(Mode.TRAIN, ModeMapper.fromApi("train"));
        assertEquals(Mode.TRAM,  ModeMapper.fromApi("TrAm"));   t
        assertEquals(Mode.METRO, ModeMapper.fromApi("subway")); 
        assertEquals(Mode.METRO, ModeMapper.fromApi("metro"));
        assertEquals(Mode.FERRY, ModeMapper.fromApi("boat"));   
        assertEquals(Mode.FERRY, ModeMapper.fromApi("ferry"));
        assertEquals(Mode.WALK,  ModeMapper.fromApi("foot"));   
        assertEquals(Mode.WALK,  ModeMapper.fromApi("walk"));
        assertEquals(Mode.OTHER, ModeMapper.fromApi("ufo"));    // ukjent → OTHER
        assertEquals(Mode.OTHER, ModeMapper.fromApi(null));     // null → OTHER
    }

\    // ---- PERSISTENS ----

    @Test
    @DisplayName("PreferencesStore: lagre og lese valgte modes (roundtrip)")
    void preferences_roundtrip() {

        var store = new no.gruppe13.kollektiv.prefs.InMemoryPreferencesStore();
        EnumSet<Mode> chosen = EnumSet.of(Mode.BUS, Mode.TRAIN);

        store.saveSelectedModes(chosen);
        EnumSet<Mode> loaded = store.loadSelectedModes();

        assertEquals(chosen, loaded, "Lest sett skal matche det som ble lagret");
    }
}