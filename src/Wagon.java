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
}
