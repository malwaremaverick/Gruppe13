package no.gruppe13.kollektiv.domain;

import no.gruppe13.kollektiv.shared.Mode;

// en del av reisen med en transporttype.
public class Leg {
    private final Mode mode;
    private final String fromStop;
    private final String toStop;

    public Leg(Mode mode, String fromStop, String toStop) {
        this.mode = mode;
        this.fromStop = fromStop;
        this.toStop = toStop;
    }

    public Mode getMode() { return mode; }
    public String getFromStop() { return fromStop; }
    public String getToStop() { return toStop; }
}