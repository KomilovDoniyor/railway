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
        return train;
    }

    @Override
    public void print() {
        System.out.println("🆔 ID        : " + getId());
        System.out.println("🚆 Poyezd    : " + getTrain());
        System.out.println("📅 Sana      : " + getDate());
        System.out.println("⏰ Vaqt      : " + getTime());
        System.out.println("📍 Qayerdan  : " + getFromCity());
        System.out.println("🏁 Qayerga   : " + getToCity());
        System.out.printf("💰 Narxi     : %,.0f so'm%n", getBasePrice());
        System.out.println("-----------------------------------");
    }
}
