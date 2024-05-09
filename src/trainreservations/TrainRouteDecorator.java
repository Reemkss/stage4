package trainreservations;

import java.util.List;

public abstract class TrainRouteDecorator extends TrainRoute {
    protected TrainRoute trainRoute;

    public TrainRouteDecorator(TrainRoute trainRoute) {
        this.trainRoute = trainRoute;
    }

    @Override
    public String getSource() {
        return trainRoute.getSource();
    }

    @Override
    public String getDestination() {
        return trainRoute.getDestination();
    }

    @Override
    public String getSchedule() {
        return trainRoute.getSchedule();
    }

    @Override
    public List<Seat> getAvailableSeats() {
        return trainRoute.getAvailableSeats();
    }
}