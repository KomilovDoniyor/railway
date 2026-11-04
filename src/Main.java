import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Trip[] trips = createTrips();
    private static final TicketOffice office = new TicketOffice(trips);

    public static void main(String[] args) {

        Passenger passenger = enterPassengerInfo();
        if (passenger == null) return;
        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            int check = scanner.nextInt();
            switch (check) {
                case 1:
                    findTicket();
                    break;
                case 2:
                    searchTrips(office);
                    break;
                case 3:
                    buyForTicket(passenger);
                    break;
                case 6:
                    addBalance(passenger);
                    break;
                case 0:
                    isRunning = false;
                    break;

            }
        }
    }

    private static void addBalance(Passenger passenger) {
        System.out.println("To`ldirmoqchi bolgan summangizni kiriting: ");
        double balance = scanner.nextDouble();
         if (passenger.addBalance(balance)){
             System.out.println("Sizning balancingiz to`ldirildi! " + balance);
             System.out.println("Sizning umumiy balanceinigiz " + passenger.getBalance());

         }else {
             System.out.println("Balance manfiy bo`lmasligi kerak!");
         }
    }

    private static void printMenu() {
        System.out.println("""
                \tMenu\t
                1. Barcha reyslarni ko'rish   //Komol
                2. Reys qidirish (qayerdan -> qayerga) //Komol
                3. Chipta sotib olish //Komol
                4. Mening chiptalarim //Abrorbek
                5. Chiptani qaytarish //Abrorbek
                6. Balansni to'ldirish //Nuriddin
                0. Chiqish"""); //Nuridd
        System.out.print("\nRaqam kiriting: ");
    }

    private static Passenger enterPassengerInfo() {
        System.out.println("\n\nAssalomu alaykum! Poyezdlar platformasiga xush kelibsiz!");
        System.out.print("\uD83D\uDC64Iltmos F.I.SH kiriting: ");
        String name = scanner.nextLine();
        System.out.print("\uD83D\uDCC4 Pasport seriyasi va raqami (masalan: AA1234567): ");
        String passport = scanner.nextLine();
        System.out.print("💳 Boshlang'ich hisob balansini kiriting (so'mda, masalan: 50000): ");
        double balance = Double.parseDouble(scanner.nextLine());
        System.out.println("\nPassenger ma'lumotlari\n\n\uD83D\uDC64Ism: " + name + "\n\uD83D\uDCC4Passport: " + passport + "\n💳 Balance: " + balance);
        while (true) {
            System.out.print("Malumotlarni tasdiqlaysizmi (y/n): ");
            String check = scanner.nextLine().trim().toLowerCase();
            if (check.equals("y")) {
                Passenger passenger = new Passenger(name, passport, balance);
                System.out.println("\n=========================================");
                System.out.println(" ✅ Rahmat! Ma'lumotlar muvaffaqiyatli saqlandi.");
                System.out.println("=========================================\n");
                return passenger;
            } else if (check.equals("n")) {
                System.out.println("❌ Amaliyot bekor qilindi.");
                return null;
            } else {
                System.out.println("⚠️ Noto'g'ri buyruq kiritildi! Iltimos, 'y' yoki 'n' ni tanlang.\n");
            }
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

    private static void findTicket() {
        while (true) {
            findAllTrips();
            Trip trip = findOneTripById();
            if (trip == null) return;
            while (true) {
                Wagon wagon = findOneWagon(trip);
                if (wagon == null) break;
                Seat seat = chooseSeat(trip, wagon);
                if (seat == null) continue;
                return;
            }
        }


    }

    private static void buyForTicket(Passenger passenger) {
        while (true) {
            findAllTrips();
            Trip trip = findOneTripById();
            if (trip == null) return;

            while (true) {
                Wagon wagon = findOneWagon(trip);
                if (wagon == null) break;

                Seat seat = chooseSeat(trip, wagon);
                if (seat == null) continue;
                if (buyTicket(seat) == null) continue;

                Ticket ticket = office.sell(passenger, trip, wagon, seat);

                if (ticket != null) {
                    ticket.print();
                    System.out.printf("💳 Qolgan balans: %,.0f so'm%n%n%n", passenger.getBalance());
                }

                return;
            }
        }
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
            System.out.print("\nID raqamni kiriting (0 - orqaga): ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (id == 0) return null;
            Trip trip = office.findTripById(id);
            if (trip != null) return trip;
            System.out.println("Kechirasiz bunday " + id + " tripId raqamli findTrip mavjud emas!");
        }
    }

    private static Wagon findOneWagon(Trip trip) {
        trip.printWagons();
        while (true) {
            System.out.print("\nVagon raqamini kiriting (0 - orqaga): ");
            int number = Integer.parseInt(scanner.nextLine().trim());
            if (number == 0) return null;
            Wagon wagon = trip.findOne(number);
            if (wagon != null) {
                System.out.printf("💰 Bu vagonda o'rin narxi: %,.0f so'm%n", trip.getBasePrice() * wagon.getMultiplier());
                wagon.printSeats();
                return wagon;
            }
            System.out.println("Kechirasiz " + number + " raqamli vagon bu poyezdda yo'q!");
        }
    }

    private static Seat chooseSeat(Trip trip, Wagon wagon) {
        double price = trip.getBasePrice() * wagon.getMultiplier();
        while (true) {
            System.out.print("O'rin raqamni kiritng (0 - orqaga): ");
            int number = Integer.parseInt(scanner.nextLine().trim());
            if (number == 0) return null;
            Seat seat = null;
            for (Seat s : wagon.getSeats()) {
                if (s.getNumber() == number) {
                    seat = s;
                    break;
                }
            }
            if (seat == null) {
                System.out.println("❌ " + number + " raqamli o'rin bu vagonda yo'q!");
                continue;
            }
            if (seat.isBooked()) {
                System.out.println("❌ " + number + "-o'rin band. Boshqa o'rin tanlang.");
                continue;
            }
            System.out.println("\n=========================================");
            System.out.println("           O'RIN MA'LUMOTLARI            ");
            System.out.println("=========================================");
            System.out.println("🆔 Reys     : " + trip.getId());
            System.out.println("🚆 Poyezd   : " + trip.getTrain().getName() + " (" + trip.getTrain().getNumber() + ")");
            System.out.println("📍 Qayerdan : " + trip.getFromCity());
            System.out.println("🏁 Qayerga  : " + trip.getToCity());
            System.out.println("📅 Sana     : " + trip.getDate());
            System.out.println("⏰ Vaqt     : " + trip.getTime());
            System.out.println("🚃 Vagon    : " + wagon.getNumber() + "-vagon (" + wagon.getType() + ")");
            System.out.println("💺 O'rin    : " + seat.getNumber());
            System.out.printf("💰 Narxi    : %,.0f so'm%n", price);
            System.out.println("=========================================");
            return seat;
        }
    }

    private static void searchTrips(TicketOffice ticketOffice) {
        System.out.println("Qayerdan: ");
        String from = scanner.nextLine();
        System.out.println("Qayerga: ");
        String to = scanner.nextLine();
        ticketOffice.searchTrips(from, to);
    }

    private static Seat buyTicket(Seat seat) {
        while (true) {
            System.out.print("Shu o'rinni olasizmi? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y")) return seat;
            if (answer.equals("n")) {
                System.out.println("Bekor qilindi.");
                return null;
            }
            System.out.println("⚠️ Faqat y yoki n kiriting.");
        }
    }
}