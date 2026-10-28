public class Train {
    private String number;
    private String name;
    private Wagon[] wagons;

    public Train(String number, String name, Wagon[] wagons) {
        this.number = number;
        this.name = name;
        this.wagons = wagons;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Wagon[] getWagons() {
        return wagons;
    }
}
