package injavaintake6.week6_1;

public class Acleda extends AbstractBank {

    public Acleda(double amount) {
        super.amount = amount;
    }

    public void pay() {
        // Call actual ACLEDA payment API
        System.out.println("ACLEDA : " + super.getAmount());
    }
}
