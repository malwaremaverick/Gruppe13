package no.gruppe13.kollektiv.shared;


 class ModeMapper {
    private ModeMapper() {}

    public static Mode fromApi(String raw) {
        if (raw == null) return Mode.OTHER;
        String s = raw.trim().toLowerCase();

        // oversetter ulike typer navn/inputs til samme mode 
        switch (s) {
            case "bus": return Mode.BUS;
            case "train":
            case "rail": return Mode.TRAIN;
            case "tram": return Mode.TRAM;
            case "metro":
            case "subway": return Mode.METRO;
            case "ferry":
            case "boat": return Mode.FERRY;
            case "walk":
            case "foot": return Mode.WALK;
            default: return Mode.OTHER; // ukjent type, så fall tilbake
        }
    }
}