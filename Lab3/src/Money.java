public class Money {

    private int bills;
    private int cents;

    public Money(int bills, int cents) {
        this.bills = bills;
        this.cents = cents;
    }

    public int getBills() {
        return this.bills;
    }

    public int getCents() {
        return this.cents;
    }

    public void addBills(int value) {
        this.bills += value;
    }

    public void addCents(int value) {
        this.cents += value;
    }
}
