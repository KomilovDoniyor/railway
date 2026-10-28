public class PlaskartWagon extends Wagon { //inheritance

    public PlaskartWagon(int number, int seatCount) {
        super(number, seatCount);
    }

    @Override
    public String getType() {
        return "Plaskart";
    }

    @Override
    public double getMultiplier() {
        return 1;
    }
}
