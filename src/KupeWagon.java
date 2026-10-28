public class KupeWagon extends Wagon {

    public KupeWagon(int number, int seatCount) {
        super(number, seatCount);
    }

    @Override
    public String getType() {
        return "Kupe";
    }

    @Override
    public double getMultiplier() {
        return 1.5;
    }
}
