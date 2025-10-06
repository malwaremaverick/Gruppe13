package no.hiof.journeyplanner.model;

import java.util.List;

public class JourneyPlan {
    private String id;
    private List<ItineraryLeg> legs;
    private long totalDurationMinutes;
    private double score;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public List<ItineraryLeg> getLegs() { return legs; }
    public void setLegs(List<ItineraryLeg> legs) { this.legs = legs; }
    public long getTotalDurationMinutes() { return totalDurationMinutes; }
    public void setTotalDurationMinutes(long totalDurationMinutes) { this.totalDurationMinutes = totalDurationMinutes; }
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
}
