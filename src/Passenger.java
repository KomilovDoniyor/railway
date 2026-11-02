public class Passenger {
    private String fullName;
    private String passport;
    private double balance;

    public Passenger(String fullName, String passport, double balance) {
        this.fullName = fullName;
        this.passport = passport;
        this.balance = balance < 0 ? 0 : balance;
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

    public boolean pay(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    public boolean topUp(double amount){
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }
}
