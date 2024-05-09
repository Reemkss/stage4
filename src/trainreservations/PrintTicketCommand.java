package trainreservations;

public class PrintTicketCommand implements Command {
    private TrainTicket ticket;

    public PrintTicketCommand(TrainTicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void execute() {
        System.out.println("\nTicket Details:");
        System.out.println("Route: " + ticket.getRoute());
        System.out.println("Date: " + ticket.getDate());
        System.out.println("Passenger: " + ticket.getPassenger().getName());
        System.out.println("Seat: " + ticket.getSeat().getSeatNumber());
    }
}