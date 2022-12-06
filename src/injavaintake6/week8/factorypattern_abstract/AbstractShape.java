package injavaintake6.week8.factorypattern_abstract;

public abstract class AbstractShape {

    protected double edge;

    public abstract void draw();

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }
}
