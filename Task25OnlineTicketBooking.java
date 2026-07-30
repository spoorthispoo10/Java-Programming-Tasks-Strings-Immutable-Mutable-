import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Custom Exception
class SeatNotAvailableException extends Exception {

    public SeatNotAvailableException(String message) {
        super(message);
    }
}

// User Class
class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Generic Utility Class
class DisplayUtility<T> {

    public void display(T data) {
        System.out.println(data);
    }
}

// Booking System
class TicketBookingSystem {

    private ArrayList<User> users = new ArrayList<>();

    private HashMap<Integer, String> seats =
            new HashMap<>();

    // Add user
    public void addUser(User user) {

        users.add(user);

        System.out.println(
                "User added: " + user.getName());
    }

    // Add seats
    public void addSeat(int seatNumber) {

        seats.put(seatNumber, "Available");
    }

    // Synchronized booking method
    public synchronized void bookTicket(
            String userName,
            int seatNumber)
            throws SeatNotAvailableException {

        if (!seats.containsKey(seatNumber)) {

            throw new SeatNotAvailableException(
                    "Seat does not exist.");
        }

        if (!seats.get(seatNumber)
                .equals("Available")) {

            throw new SeatNotAvailableException(
                    "Seat " + seatNumber
                            + " is already booked.");
        }

        seats.put(seatNumber, userName);

        StringBuilder confirmation =
                new StringBuilder();

        confirmation.append("\n===== BOOKING CONFIRMATION =====\n");
        confirmation.append("User: ");
        confirmation.append(userName);
        confirmation.append("\nSeat Number: ");
        confirmation.append(seatNumber);
        confirmation.append("\nStatus: Confirmed");
        confirmation.append("\n================================");

        System.out.println(confirmation);
    }

    // Display seats
    public void displaySeats() {

        System.out.println("\nSeat Availability:");

        for (Integer seat : seats.keySet()) {

            System.out.println(
                    "Seat " + seat
                            + " : "
                            + seats.get(seat));
        }
    }

    // Search booking
    public void searchBooking(String userName) {

        boolean found = false;

        for (Integer seat : seats.keySet()) {

            if (seats.get(seat)
                    .equals(userName)) {

                System.out.println(
                        "User " + userName
                                + " booked Seat "
                                + seat);

                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No booking found.");
        }
    }

    // Update booking
    public synchronized void updateBooking(
            String userName,
            int oldSeat,
            int newSeat)
            throws SeatNotAvailableException {

        if (!seats.containsKey(oldSeat)
                || !seats.get(oldSeat)
                .equals(userName)) {

            throw new SeatNotAvailableException(
                    "Old booking not found.");
        }

        if (!seats.containsKey(newSeat)
                || !seats.get(newSeat)
                .equals("Available")) {

            throw new SeatNotAvailableException(
                    "New seat is not available.");
        }

        seats.put(oldSeat, "Available");
        seats.put(newSeat, userName);

        System.out.println(
                "Booking updated successfully.");
    }
}

// Booking Thread
class BookingThread extends Thread {

    private TicketBookingSystem system;
    private String userName;
    private int seatNumber;

    public BookingThread(
            TicketBookingSystem system,
            String userName,
            int seatNumber) {

        this.system = system;
        this.userName = userName;
        this.seatNumber = seatNumber;
    }

    public void run() {

        try {

            system.bookTicket(
                    userName,
                    seatNumber);

        } catch (SeatNotAvailableException e) {

            System.out.println(
                    userName + ": "
                            + e.getMessage());
        }
    }
}

// Main Class
public class Task25OnlineTicketBooking {

    public static void main(String[] args) {

        TicketBookingSystem system =
                new TicketBookingSystem();

        // Add users
        User user1 = new User("Rahul");
        User user2 = new User("Ananya");

        system.addUser(user1);
        system.addUser(user2);

        // Add seats
        system.addSeat(1);
        system.addSeat(2);
        system.addSeat(3);

        // Multiple users try to book
        // the same seat simultaneously
        Thread thread1 =
                new BookingThread(
                        system,
                        "Rahul",
                        1);

        Thread thread2 =
                new BookingThread(
                        system,
                        "Ananya",
                        1);

        thread1.start();
        thread2.start();

        try {

            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {

            System.out.println(
                    "Thread interrupted.");
        }

        // Display seats
        system.displaySeats();

        // Search booking
        system.searchBooking("Rahul");

        // Update booking
        try {

            system.updateBooking(
                    "Rahul",
                    1,
                    2);

        } catch (SeatNotAvailableException e) {

            System.out.println(
                    e.getMessage());
        }

        // Display final seats
        system.displaySeats();

        // Generic utility
        DisplayUtility<String> utility =
                new DisplayUtility<>();

        utility.display(
                "Ticket Booking System Completed");
    }
}