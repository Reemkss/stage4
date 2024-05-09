package trainreservations;

import java.util.Date;

public class TicketBookingSystem {
    private static TicketBookingSystem instance;

    private TicketBookingSystem() {
    }

    public static TicketBookingSystem getInstance() {
        if (instance == null) {
            instance = new TicketBookingSystem();
        }
        return instance;
    }

    public TrainTicket bookTicket(TrainRoute route, Passenger passenger, Seat seat) {
        String ticketRoute = route.getSource() + " to " + route.getDestination();
        String currentDate = new Date().toString();
        route.getAvailableSeats().remove(seat);
        return new TrainTicket(ticketRoute, currentDate, passenger, seat);
    }
}