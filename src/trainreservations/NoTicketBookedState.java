package trainreservations;

public class NoTicketBookedState implements TicketBookingState {
    @Override
    public void viewTicket() {
        System.out.println("No ticket has been booked yet.");
    }
}