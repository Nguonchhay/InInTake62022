package injavaintake6.week8.factorypattern;

public class ShapeFactory {
    public static ShapeInterface getShape(String shapeName) {
        if (shapeName.equalsIgnoreCase("circle")) {
            MyCircle c = new MyCircle();
            return c;
        } else if (shapeName.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (shapeName.equalsIgnoreCase("square")) {
            return new Square();
        } else {
            return null;
        }
    }
}
