package trainreservations;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityObservable {
    private List<SeatAvailabilityObserver> observers = new ArrayList<>();
    private List<Seat> availableSeats;

    public SeatAvailabilityObservable(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void addObserver(SeatAvailabilityObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(SeatAvailabilityObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Seat reservedSeat) {
        for (SeatAvailabilityObserver observer : observers) {
            observer.seatReserved(reservedSeat);
        }
    }

    public void reserveSeat(Seat seat) {
        if (availableSeats.contains(seat)) {
            availableSeats.remove(seat);
            notifyObservers(seat);
        } else {
            System.out.println("Seat " + seat.getSeatNumber() + " is already reserved.");
        }
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }
}