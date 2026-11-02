public class Seat {
    private int number;
    //Shu joy band emasligini bildiradi
    private boolean booked;

    public Seat(int number) {
        this.number = number;
        this.booked = false;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        this.booked = true;
    }

    public void free() {
        this.booked = false;
    }

}
