import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Trip[] trips = createTrips();
    private static final TicketOffice office = new TicketOffice(trips);

    public static void main(String[] args) {

//        enterPassengerInfo();
        printMenu();

        int check = Integer.parseInt(scanner.nextLine().trim());
        switch (check) {
            case 1:
                findAllTrips();
                Trip trip = findOneTripById();
                findOneWagon(trip);
                break;
        }

    }

    private static void printMenu() {
        System.out.println("""
                \tMenu\t
                1. Barcha reyslarni ko'rish
                2. Reys qidirish (qayerdan -> qayerga)
                3. Chipta sotib olish
                4. Mening chiptalarim
                5. Chiptani qaytarish
                6. Balansni to'ldirish
                0. Chiqish""");
        System.out.print("\nRaqam kiriting: ");
    }

    private static void enterPassengerInfo() {
        System.out.println("\n\nAssalomu alaykum! Poyezdlar platformasiga xush kelibsiz!");
        System.out.print("\uD83D\uDC64Iltmos F.I.SH kiriting: ");
        String name = scanner.nextLine();
        System.out.print("\uD83D\uDCC4 Pasport seriyasi va raqami (masalan: AA1234567): ");
        String passport = scanner.nextLine();
        System.out.print("💳 Boshlang'ich hisob balansini kiriting (so'mda, masalan: 50000): ");
        double balance = Double.parseDouble(scanner.nextLine());
        System.out.println("\nPassenger ma'lumotlari\n\n\uD83D\uDC64Ism: " + name + "\n\uD83D\uDCC4Passport: " + passport + "\n💳 Balance: " + balance);
        System.out.print("Malumotlarni tasdiqlaysizmi (y/n): ");
        String check = scanner.nextLine();
        switch (check) {
            case "y":
                new Passenger(name, passport, balance);
                System.out.println("\n=========================================");
                System.out.println(" ✅ Rahmat! Ma'lumotlar muvaffaqiyatli saqlandi.");
                System.out.println("=========================================\n");
                break;
            case "n":
                System.err.println("❌ Amaliyot bekor qilindi.");
                return;
            default:
                System.err.println("⚠️ Noto'g'ri buyruq kiritildi!");
                return;
        }
    }

    private static Trip[] createTrips() {
        Wagon[] wagon1 = {
                new PlaskartWagon(1, 54),
                new BiznesWagon(2, 36),
                new KupeWagon(3, 18)
        };
        Wagon[] wagon2 = {
                new PlaskartWagon(1, 54),
                new BiznesWagon(2, 36),
        };
        Train train1 = new Train("AA001", "Afrosiyob", wagon1);
        Train train2 = new Train("AA002", "Sharq", wagon2);
        Trip[] result = new Trip[]{
                new Trip(1, "Toshkent", "Samarqand", "2026-11-05", "08:00", 120_000, train1),
                new Trip(2, "Toshkent", "Buxoro", "2026-11-05", "09:00", 200_000, train2),
                new Trip(3, "Toshkent", "Xiva", "2026-11-05", "21:00", 250_000, train1),
                new Trip(4, "Toshkent", "Andijon", "2026-11-05", "07:30", 110_000, train2),
                new Trip(5, "Samarqand", "Buxoro", "2026-11-05", "11:30", 90_000, train1),
                new Trip(6, "Toshkent", "Qarshi", "2026-11-06", "07:00", 140_000, train2),
                new Trip(7, "Buxoro", "Toshkent", "2026-11-06", "15:00", 200_000, train1),
                new Trip(8, "Samarqand", "Toshkent", "2026-11-06", "18:00", 120_000, train2),
                new Trip(9, "Andijon", "Toshkent", "2026-11-06", "16:00", 110_000, train1),
                new Trip(10, "Toshkent", "Termiz", "2026-11-06", "19:30", 220_000, train2)
        };
        return result;
    }

    private static void findAllTrips() {
        System.out.println("\n=========================================");
        System.out.println("            REYS MA'LUMOTLARI            ");
        System.out.println("=========================================");
        for (Trip trip : trips) trip.print();
        System.out.println("\n=========================================");
        System.out.println("Jami: " + trips.length + " ta reys");
        System.out.println("=========================================");

    }

    private static Trip findOneTripById() {
        while (true) {
            System.out.print("\nID raqamni kiriting!: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            Trip trip = office.findTripById(id);
            if (trip != null) {
                trip.printWagons();
                return trip;
            }
            System.out.println("Kechirasiz bunday " + id + " tripId raqamli findTrip mavjud emas!");
        }
    }

    private static void findOneWagon(Trip trip) {
        while (true) {
            System.out.print("\nVagon raqamini kiriting!: ");
            int number = Integer.parseInt(scanner.nextLine().trim());
            Wagon wagon = trip.findOne(number);
            if (wagon != null) {
                System.out.printf("💰 Bu vagonda o'rin narxi: %,.0f so'm%n", trip.getBasePrice() * wagon.getMultiplier());
                wagon.printSeats();
                return;
            }
            System.out.println("Kechirasiz " + number + " raqamli vagon bu poyezdda yo'q!");
        }
    }

    private static void buyTicket(){
        
    }

}