package injavaintake6.week8.factorypattern_abstract;

public class Circle extends AbstractShape {

    public Circle() {
        this.edge = 1.0;
    }

    public Circle(double radius) {
        setEdge(radius);
    }

    public void draw() {
        System.out.println("Draw Circle");
    }
}
