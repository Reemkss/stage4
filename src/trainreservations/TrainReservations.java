package trainreservations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainReservations {
    private static TicketBookingState currentState = new NoTicketBookedState();

    public static void main(String[] args) {
        System.out.println("Welcome to the Train Ticket Booking System!");

        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Ticket");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    bookTicket(sc);
                    break;
                case 2:
                    currentState.viewTicket();
                    break;
                case 3:
                    System.out.println("Thank you for using the Train Ticket Booking System. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        sc.close();
    }

    private static void bookTicket(Scanner scanner) {
        System.out.print("\nEnter passenger name: ");
        String passengerName = scanner.nextLine();
        System.out.print("Enter passenger ID number: ");
        String passengerIdNumber = scanner.nextLine();
        Passenger passenger = new Passenger(passengerName, passengerIdNumber);

        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        String schedule = selectSchedule(scanner);
        List<Seat> availableSeats = new ConcreteTrainRoute(source, destination, schedule, new ArrayList<>()).generateSeats(50);

        TrainRoute route = new ConcreteTrainRoute(source, destination, schedule, availableSeats);

        System.out.print("Do you want to add food service? (y/n): ");
        String foodChoice = scanner.nextLine();
        if (foodChoice.equalsIgnoreCase("y")) {
            route = new FoodServiceDecorator(route);
        }

        System.out.print("Do you want to add WiFi service? (y/n): ");
        String wifiChoice = scanner.nextLine();
        if (wifiChoice.equalsIgnoreCase("y")) {
            route = new WifiDecorator(route);
        }

        SeatAvailabilityLogger logger = new SeatAvailabilityLogger();
        SeatAvailabilityObservable seatAvailability = new SeatAvailabilityObservable(availableSeats);
        seatAvailability.addObserver(logger);

        System.out.println("Available seats:");
        for (Seat seat : seatAvailability.getAvailableSeats()) {
            System.out.print(seat.getSeatNumber() + " ");
        }
        System.out.println();

        System.out.print("Enter seat number to reserve: ");
        String selectedSeatNumber = scanner.nextLine();
        Seat selectedSeat = null;
        for (Seat seat : seatAvailability.getAvailableSeats()) {
            if (seat.getSeatNumber().equals(selectedSeatNumber)) {
                selectedSeat = seat;
                Command reserveSeatCommand = new ReserveSeatCommand(seatAvailability, seat);
                reserveSeatCommand.execute();
                break;
            }
        }

        TicketBookingSystemProxy bookingProxy = new TicketBookingSystemProxy();
        TrainTicket ticket = bookingProxy.bookTicket(route, passenger, selectedSeat);

        Command printTicketCommand = new PrintTicketCommand(ticket);
        printTicketCommand.execute();

        currentState = new TicketBookedState(ticket);
    }

    private static String selectSchedule(Scanner scanner) {
        System.out.println("Available schedules:");
        System.out.println("1. 08:00 AM");
        System.out.println("2. 12:00 PM");
        System.out.println("3. 04:00 PM");

        System.out.print("Enter schedule number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                return "08:00 AM";
            case 2:
                return "12:00 PM";
            case 3:
                return "04:00 PM";
            default:
                System.out.println("Invalid choice. Defaulting to 08:00 AM.");
                return "08:00 AM";
        }
    }
}