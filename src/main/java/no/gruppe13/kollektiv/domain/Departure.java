package no.gruppe13.kollektiv.domain;


import no.gruppe13.kollektiv.shared.Mode;
import java.time.LocalDateTime;

// Enkelt objekt som beskriver en avgang.
public class Departure {
    private final Mode mode;              // buss, tog, ...
    private final String line;            // linjenummer, f.eks. "31"
    private final String destination;     // retning/sluttstopp
    private final LocalDateTime plannedTime; // planlagt tid
    private final int delayMinutes;       // forsinkelse i min

    public Departure(Mode mode, String line, String destination,
                     LocalDateTime plannedTime, int delayMinutes) {
        this.mode = mode;
        this.line = line;
        this.destination = destination;
        this.plannedTime = plannedTime;
        this.delayMinutes = delayMinutes;
    }

    public Mode getMode() { return mode; }
    public String getLine() { return line; }
    public String getDestination() { return destination; }
    public LocalDateTime getPlannedTime() { return plannedTime; }
    public int getDelayMinutes() { return delayMinutes; }
}