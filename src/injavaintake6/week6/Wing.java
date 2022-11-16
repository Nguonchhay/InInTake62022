package injavaintake6.week6;

public class Wing {
    private double fee;
    private String note;

    public Wing(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void transfer() {
        // Call actual Wing payment API
        System.out.println("Wing : " + this.fee);
    }
}
