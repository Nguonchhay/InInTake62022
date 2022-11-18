package injavaintake6.week6_1;

public class Aba extends AbstractBank {
    private String remark;

    public Aba(double amount) {
        super.amount = amount;
        this.remark = "";
    }

    public void pay() {
        // Call actual ABA payment API
        System.out.println("ABA : " + getAmount());
    }
}
