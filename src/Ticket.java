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

    @Override
    public void print() {

    }

    public Passenger getPassenger() {
        return this.passenger;
    }

    public TicketType getStatus() {
        return this.status;
    }
}
