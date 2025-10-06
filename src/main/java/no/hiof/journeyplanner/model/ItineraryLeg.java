package no.hiof.journeyplanner.model;

import java.time.LocalDateTime;

public class ItineraryLeg {
    private int order;
    private Stop fromStop;
    private Stop toStop;
    private String transportType;
    private LocalDateTime plannedDeparture;
    private LocalDateTime plannedArrival;
    private LocalDateTime realDeparture;
    private LocalDateTime realArrival;
    private String disruptionNote;

    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }
    public Stop getFromStop() { return fromStop; }
    public void setFromStop(Stop fromStop) { this.fromStop = fromStop; }
    public Stop getToStop() { return toStop; }
    public void setToStop(Stop toStop) { this.toStop = toStop; }
    public String getTransportType() { return transportType; }
    public void setTransportType(String transportType) { this.transportType = transportType; }
    public LocalDateTime getPlannedDeparture() { return plannedDeparture; }
    public void setPlannedDeparture(LocalDateTime plannedDeparture) { this.plannedDeparture = plannedDeparture; }
    public LocalDateTime getPlannedArrival() { return plannedArrival; }
    public void setPlannedArrival(LocalDateTime plannedArrival) { this.plannedArrival = plannedArrival; }
    public LocalDateTime getRealDeparture() { return realDeparture; }
    public void setRealDeparture(LocalDateTime realDeparture) { this.realDeparture = realDeparture; }
    public LocalDateTime getRealArrival() { return realArrival; }
    public void setRealArrival(LocalDateTime realArrival) { this.realArrival = realArrival; }
    public String getDisruptionNote() { return disruptionNote; }
    public void setDisruptionNote(String disruptionNote) { this.disruptionNote = disruptionNote; }
}
