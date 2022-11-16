package injavaintake6.week6;

public class Acleda {
    private double amount;
    private String remark;

    public Acleda(double amount) {
        this.amount = amount;
        this.remark = "";
    }

    public double getAmount() {
        return amount;
    }

    public void pay() {
        // Call actual ACLEDA payment API
        System.out.println("ACLEDA : " + this.amount);
    }
}
