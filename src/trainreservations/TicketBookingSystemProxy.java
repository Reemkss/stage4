package trainreservations;

public class TicketBookingSystemProxy {
    private TicketBookingSystem bookingSystem;

    public TicketBookingSystemProxy() {
        bookingSystem = TicketBookingSystem.getInstance();
    }

    public TrainTicket bookTicket(TrainRoute route, Passenger passenger, Seat seat) {
        System.out.println("Performing pre-booking checks...");

        TrainTicket ticket = bookingSystem.bookTicket(route, passenger, seat);

        System.out.println("Performing post-booking operations...");

        return ticket;
    }
}