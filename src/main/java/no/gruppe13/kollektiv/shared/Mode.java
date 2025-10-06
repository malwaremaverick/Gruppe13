package no.gruppe13.kollektiv.shared;

// Typer transport vi støtter 


public enum Mode {
    // Navn i koden            // Navn som kan vises i UI
    BUS("Buss"),
    TRAIN("Tog"),
    TRAM("Trikk"),
    METRO("T-bane"),
    FERRY("Ferge"),
    WALK("Gange"),     // brukes om man må gå for å bytte mellom transportmidler/holdeplass. skal ofet være alltid tillatt.  
    OTHER("Annet");    // ukjent type fra API eller noe vi ikke har mappet enda

    private final String displayName;

    Mode(String displayName) {
        this.displayName = displayName;
    }

    // Tekst vi kan vise i UI senere
    public String displayName() {
        return displayName;
    }

}