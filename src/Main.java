import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stop stop1 = new Stop("1", "Oslo Bussterminal");
        Stop stop2 = new Stop("2", "Jernbanetorget");

        List<Stop> stops = Arrays.asList(stop1, stop2);

        Map<String, List<Departure>> departures = new HashMap<>();
        departures.put("1", Arrays.asList(
                new Departure("31", "Snarøya", "12:10"),
                new Departure("37", "Nydalen", "12:15")
        ));
        departures.put("2", Arrays.asList(
                new Departure("5", "Vestli", "12:05"),
                new Departure("18", "Majorstuen", "12:12")
        ));

        StopService service = new StopService(stops, departures);

        Stop found = service.findStopByName("Oslo Bussterminal");
        if (found != null) {
            System.out.println(found.getName() + ":");
            for (Departure d : service.getDeparturesForStop(found.getId())) {
                System.out.println(d);
            }
        } else {
            System.out.println("Fant ikke stoppet.");
        }
    }
}

//tester funksjonen til klassene