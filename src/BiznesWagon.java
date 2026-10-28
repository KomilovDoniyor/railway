public class BiznesWagon extends Wagon {

    public BiznesWagon(int number, int seatCount) {
        super(number, seatCount);
    }

    @Override
    public String getType() {
        return "Biznes";
    }

    @Override
    public double getMultiplier() {
        return 2;
    }
}
