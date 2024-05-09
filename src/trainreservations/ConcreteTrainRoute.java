package trainreservations;

import java.util.ArrayList;
import java.util.List;

public class ConcreteTrainRoute extends TrainRoute {
    private String source;
    private String destination;
    private String schedule;
    private List<Seat> availableSeats;

    public ConcreteTrainRoute(String source, String destination, String schedule, List<Seat> availableSeats) {
        this.source = source;
        this.destination = destination;
        this.schedule = schedule;
        this.availableSeats = availableSeats;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public String getSchedule() {
        return schedule;
    }

    @Override
    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public List<Seat> generateSeats(int numberOfSeats) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.add(new Seat(String.valueOf(i)));
        }
        return seats;
    }
}