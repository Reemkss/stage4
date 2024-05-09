package trainreservations;

public class SeatAvailabilityLogger implements SeatAvailabilityObserver {
    @Override
    public void seatReserved(Seat reservedSeat) {
        System.out.println("Seat " + reservedSeat.getSeatNumber() + " has been reserved.");
    }
}