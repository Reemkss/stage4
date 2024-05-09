package trainreservations;

public class TicketBookedState implements TicketBookingState {
    private TrainTicket bookedTicket;

    public TicketBookedState(TrainTicket bookedTicket) {
        this.bookedTicket = bookedTicket;
    }

    @Override
    public void viewTicket() {
        System.out.println("\nTicket Details:");
        System.out.println("Route: " + bookedTicket.getRoute());
        System.out.println("Date: " + bookedTicket.getDate());
        System.out.println("Passenger: " + bookedTicket.getPassenger().getName());
        System.out.println("Seat: " + bookedTicket.getSeat().getSeatNumber());
    }
}