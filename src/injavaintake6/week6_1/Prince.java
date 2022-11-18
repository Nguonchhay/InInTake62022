package injavaintake6.week6_1;

public class Prince extends AbstractBank{

    public Prince(double amount) {
        this.amount = amount;
    }

    public void pay() {
        // Call actual Prince payment API
        System.out.println("Prince : " + this.amount);
    }
}
