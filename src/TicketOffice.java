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
}
