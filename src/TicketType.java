public enum TicketType {
    ACTIVE("Foal"), RETURNED("Qaytarilgan");

    private final String getName;

    TicketType(String getName) {
        this.getName = getName;
    }
}
