package injavaintake6.week8.factorypattern_abstract;

public class Square extends AbstractShape {

    public Square() {
        setEdge(1.0);
    }

    public Square(double edge) {
        setEdge(edge);
    }

    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}
