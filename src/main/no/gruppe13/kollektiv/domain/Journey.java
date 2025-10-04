package no.gruppe13.kollektiv.domain;

import java.util.List;

// En reise = liste av "legs".
public class Journey {
    private final List<Leg> legs;

    public Journey(List<Leg> legs) {
        this.legs = List.copyOf(legs);
    }

    public List<Leg> getLegs() {
        return legs;
    }
}