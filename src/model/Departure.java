public class Departure {
    private String line;
    private String destination;
    private String time;

    public Departure(String line, String destination, String time) {
        this.line = line;
        this.destination = destination;
        this.time = time;
    }

    public String getLine() { return line; }
    public void setLine(String line) { this.line = line; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String toString() {
        return line + " til " + destination + " kl. " + time;
    }
}