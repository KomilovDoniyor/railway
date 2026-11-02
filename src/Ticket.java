public class Ticket implements Printable {

    private int id;
    private Passenger passenger;
    private Trip trip;
    private Wagon wagon;
    private Seat seat;
    private double price;
    private TicketType status;

    public Ticket(int id, Passenger passenger, Trip trip, Wagon wagon, Seat seat, double price) {
        this.id = id;
        this.passenger = passenger;
        this.trip = trip;
        this.wagon = wagon;
        this.seat = seat;
        this.price = price;
        this.status = TicketType.ACTIVE;
    }

    public Passenger getPassenger() {
        return this.passenger;
    }

    public TicketType getStatus() {
        return this.status;
    }
    @Override
    public void print() {
        System.out.println("\n=========================================");
        System.out.println("              CHIPTA #" + id);
        System.out.println("=========================================");
        System.out.println("👤 Yo'lovchi : " + passenger.getFullName());
        System.out.println("📄 Passport  : " + passenger.getPassport());
        System.out.println("🆔 Reys      : " + trip.getId() + " (" + trip.getFromCity() + " → " + trip.getToCity() + ")");
        System.out.println("🚆 Poyezd    : " + trip.getTrain().getName() + " (" + trip.getTrain().getNumber() + ")");
        System.out.println("📅 Sana      : " + trip.getDate() + "   ⏰ Vaqt : " + trip.getTime());
        System.out.println("🚃 Vagon     : " + wagon.getNumber() + "-vagon (" + wagon.getType() + ")");
        System.out.println("💺 O'rin     : " + seat.getNumber());
        System.out.printf("💰 Narxi     : %,.0f so'm%n", price);
        System.out.println("📌 Holati    : " + status.getName());
        System.out.println("=========================================");
    }

}
