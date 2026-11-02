public class TicketOffice {
    private static final int MAX_TICKETS = 100;
    private static final double REFUND_PERCENT = 0.9;

    private Ticket[] tickets;
    private Trip[] trips;
    private int ticketCount;

    public TicketOffice(Trip[] trips) {
        this.trips = trips;
        this.tickets = new Ticket[MAX_TICKETS];
        this.ticketCount = 0;
    }

    public Trip findTripById(int id) {
        for (Trip trip : trips) {
            if (trip.getId() == id) return trip;
        }

        return null;
    }

    public Ticket sell(Passenger passenger, Trip trip, Wagon wagon, Seat seat) {
        double price = trip.getBasePrice() * wagon.getMultiplier();
        if (this.ticketCount > MAX_TICKETS) {
            System.out.println("❌ Kassada bo'sh joy qolmadi!");
            return null;
        }
        if (seat.isBooked()) {
            System.out.println("❌ " + seat.getNumber() + "-o'rin allaqachon band!");
            return null;
        }
        if (!passenger.pay(price)) {
            System.out.printf("❌ Balans yetarli emas. Narx: %,.0f so'm, balans: %,.0f so'm%n",
                    price, passenger.getBalance());
            return null;
        }
        seat.book();
        Ticket ticket = new Ticket(ticketCount + 1, passenger, trip, wagon, seat, price);
        tickets[ticketCount] = ticket;
        ticketCount++;
        return ticket;
    }
}
