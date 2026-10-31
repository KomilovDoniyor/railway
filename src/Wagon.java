public abstract class Wagon {
    private int number;
    private Seat[] seats;

    public Wagon(int number, int seatCount) { //36
        this.number = number;
        this.seats = new Seat[seatCount];
        for (int i = 0; i < seatCount; i++) {
            seats[i] = new Seat(i + 1);
        }
    }

    public abstract String getType();

    public abstract double getMultiplier();

    public Seat[] getSeats() {
        return this.seats;
    }

    public int getNumber() {
        return this.number;
    }

    public  void  printSeats(){
        System.out.printf("%n🚃 %d-vagon (%s) — %d o'rin%n", number, getType(), seats.length);
        System.out.println("-----------------------------------");
        for (int i = 0; i < seats.length; i++) {
            System.out.printf("%3d %s   ", seats[i].getNumber(), seats[i].isBooked() ? "❌" : "✅");
            if ((i + 1) % 6 == 0) System.out.println();
        }
        if (seats.length % 6 != 0) System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("✅ bo'sh    ❌ band");
    }
}
