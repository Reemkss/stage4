package trainreservations;

import java.util.List;

public abstract class TrainRoute {
    public abstract String getSource();
    public abstract String getDestination();
    public abstract String getSchedule();
    public abstract List<Seat> getAvailableSeats();
}