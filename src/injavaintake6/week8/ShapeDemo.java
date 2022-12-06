package injavaintake6.week8;

import injavaintake6.week8.factorypattern.ShapeFactory;
import injavaintake6.week8.factorypattern.ShapeInterface;
import injavaintake6.week8.factorypattern_abstract.AbstractShape;
import injavaintake6.week8.factorypattern_abstract.AbstractShapeFactory;

public class ShapeDemo {
    public static void launch() {
//        interfaceDemo();
        abstractDemo();
    }

    public static void interfaceDemo() {
        ShapeInterface circle1 = ShapeFactory.getShape("circle");
        circle1.draw();
    }

    public static void abstractDemo() {
        AbstractShape circle1 = AbstractShapeFactory.getShape("circle");
        circle1.setEdge(2.5);
        circle1.draw();
        System.out.println("Edge: " + circle1.getEdge());
    }
}
