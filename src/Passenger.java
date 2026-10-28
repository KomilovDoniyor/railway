public class Passenger {
    private String fullName;
    private String passport;
    private double balance;

    public Passenger(String fullName, String passport, double balance) {
        this.fullName = fullName;
        this.passport = passport;
        setBalance(balance);
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassport() {
        return passport;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.err.println("Balans manfiy bolishi mumkin emas!");
        } else {
            this.balance = balance;
        }
    }
}
