package injavaintake6.week6_1;

public abstract class AbstractBank {

    protected double amount;

    // Define abstract method as a rule for sub-class to override
    public abstract void pay();

    public double getAmount() {
        return amount;
    }
}
