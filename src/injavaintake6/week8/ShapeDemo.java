package injavaintake6.week8;

import injavaintake6.week8.factorypattern.ShapeFactory;
import injavaintake6.week8.factorypattern.ShapeInterface;

public class ShapeDemo {
    public static void launch() {
        ShapeInterface circle1 = ShapeFactory.getShape("circle");
        circle1.draw();
    }
}
