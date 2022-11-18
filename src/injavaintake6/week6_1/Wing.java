package injavaintake6.week6_1;

public class Wing extends AbstractBank {
    private String note;

    public Wing(double fee) {
        super.amount = fee;
    }

    public void pay() {
        // Call actual Wing payment API
        System.out.println("Wing : " + super.getAmount());
    }
}
