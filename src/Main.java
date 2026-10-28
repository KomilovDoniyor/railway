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
        //1. Barcha reyslarni ko'rish
        //2. Reys qidirish (qayerdan -> qayerga)
        //3. Chipta sotib olish
        //4. Mening chiptalarim
        //5. Chiptani qaytarish
        //6. Balansni to'ldirish
        //0. Chiqish
    }

    private static Trip[] createTrips() {
        return null;
    }
}