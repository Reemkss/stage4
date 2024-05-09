package trainreservations;

public class ReserveSeatCommand implements Command {
    private SeatAvailabilityObservable seatAvailability;
    private Seat seat;

    public ReserveSeatCommand(SeatAvailabilityObservable seatAvailability, Seat seat) {
        this.seatAvailability = seatAvailability;
        this.seat = seat;
    }

    @Override
    public void execute() {
        seatAvailability.reserveSeat(seat);
    }
}