public class Trip implements Printable {
    private int id;
    private String fromCity;
    private String toCity;
    private String date;
    private String time;
    private double basePrice;
    private Train train;

    public Trip(int id, String fromCity, String toCity, String date, String time, double basePrice, Train train) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.date = date;
        this.time = time;
        this.basePrice = basePrice;
        this.train = train;
    }

    public int getId() {
        return id;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Train getTrain() {
        return this.train;
    }

    @Override
    public void print() {
        System.out.println("🆔 ID        : " + getId());
        System.out.println("🚆 Poyezd    : " + getTrain().getName());
        System.out.println("📅 Sana      : " + getDate());
        System.out.println("⏰ Vaqt      : " + getTime());
        System.out.println("📍 Qayerdan  : " + getFromCity());
        System.out.println("🏁 Qayerga   : " + getToCity());
        System.out.printf("💰 Narxi     : %,.0f so'm%n", getBasePrice());
        System.out.println("-----------------------------------");
    }

    public void printWagon() {
        Wagon[] wagons = getTrain().getWagons();
        System.out.println("🚆 Poyezd       : " + getTrain().getName() + " (" + getTrain().getNumber() + ")");
        System.out.println("🚃 Vagonlar soni: " + wagons.length);
        System.out.println("-----------------------------------");
        for (Wagon wagon : wagons) {
            int free = 0;
            for (Seat seat : wagon.getSeats()) {
                if (!seat.isBooked()) free++;
            }
            System.out.printf("  %d-vagon | %-9s | %d o'rin | bo'sh: %d%n",
                    wagon.getNumber(), wagon.getType(), wagon.getSeats().length, free);
        }
        System.out.println("-----------------------------------");
    }

    ;

}
