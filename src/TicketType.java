public enum TicketType {
    ACTIVE("Foal"), RETURNED("Qaytarilgan");

    private final String label;


    TicketType(String label) {
        this.label = label;
    }

    public String getName() {
        return label;
    }
}
