package injavaintake6.week6;

public class Aba {
    private double amount;
    private String remark;

    public Aba(double amount) {
        this.amount = amount;
        this.remark = "";
    }

    public double getAmount() {
        return amount;
    }

    public void pay() {
        // Call actual ABA payment API
        System.out.println("ABA : " + this.amount);
    }
}
