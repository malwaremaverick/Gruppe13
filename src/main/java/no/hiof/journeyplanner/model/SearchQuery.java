package no.hiof.journeyplanner.model;

import java.time.LocalDateTime;

public class SearchQuery {
    private String id;
    private String fromStop;
    private String toStop;
    private LocalDateTime arriveBy;

    public SearchQuery() {}

    public SearchQuery(String id, String fromStop, String toStop, LocalDateTime arriveBy) {
        this.id = id;
        this.fromStop = fromStop;
        this.toStop = toStop;
        this.arriveBy = arriveBy;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFromStop() { return fromStop; }
    public void setFromStop(String fromStop) { this.fromStop = fromStop; }
    public String getToStop() { return toStop; }
    public void setToStop(String toStop) { this.toStop = toStop; }
    public LocalDateTime getArriveBy() { return arriveBy; }
    public void setArriveBy(LocalDateTime arriveBy) { this.arriveBy = arriveBy; }

    @Override
    public String toString() {
        return "SearchQuery{" +
                "id='" + id + '\'' +
                ", fromStop='" + fromStop + '\'' +
                ", toStop='" + toStop + '\'' +
                ", arriveBy=" + arriveBy +
                '}';
    }
}
