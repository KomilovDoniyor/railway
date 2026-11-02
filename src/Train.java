public class Train {
    private String number;
    private String name;
    private Wagon[] wagons;

    public Train(String number, String name, Wagon[] wagons) {
        this.number = number;
        this.name = name;
        this.wagons = wagons;
    }

    public Train copy() {
        Wagon[] copies = new Wagon[wagons.length];
        for (int i = 0; i < wagons.length; i++) {
            copies[i] = wagons[i].copy();
        }
        return new Train(number, name, copies);
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
