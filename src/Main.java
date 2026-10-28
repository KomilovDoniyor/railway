import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TicketOffice office = new TicketOffice(createTrips());
        //Passenger register

        boolean running = true;
        while (running) {
            printMenu();

        }
    }

    private static void printMenu() {

    }

    private static Trip[] createTrips() {
        return null;
    }
}