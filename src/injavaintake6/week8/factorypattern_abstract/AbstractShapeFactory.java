package injavaintake6.week8.factorypattern_abstract;

public class AbstractShapeFactory {
    public static AbstractShape getShape(String shapeName) {
        if (shapeName.equalsIgnoreCase("circle")) {
            Circle c = new Circle();
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
