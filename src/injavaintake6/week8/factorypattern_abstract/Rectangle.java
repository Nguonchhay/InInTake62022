package injavaintake6.week8.factorypattern_abstract;

public class Rectangle extends AbstractShape {

    protected double height;

    public Rectangle() {
        setEdge(2);
        setHeight(4);
    }

    public Rectangle(double width, double height) {
        setEdge(width);
        setHeight(height);
    }

    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
