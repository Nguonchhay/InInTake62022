package injavaintake6.week6;

public class Product {
    private String name;
    private int quantity;
    private double price;

    public Product() {
        this.name = "";
        this.quantity = 1;
        this.price = 0;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return this.price * this.quantity;
    }

    public void printInConsole() {
        System.out.println(this.name + "        " + this.quantity + "     " + this.price + "   " + this.getTotal());
    }
}
