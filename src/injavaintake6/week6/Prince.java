package injavaintake6.week6;

public class Prince {
    private double amount;

    public Prince(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void doPay() {
        // Call actual Prince payment API
        System.out.println("Prince : " + this.amount);
    }
}
