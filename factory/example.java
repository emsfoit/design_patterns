// Shape interface
interface Shape {
    void draw();
}

// Concrete implementations of Shape interface
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// Factory class to create objects of shapes
class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }

        return null;
    }
}

// Usage of the factory to create shapes
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Create different shapes using the factory
        Shape circle = shapeFactory.createShape("CIRCLE");
        circle.draw(); // Output: Drawing Circle

        Shape square = shapeFactory.createShape("SQUARE");
        square.draw(); // Output: Drawing Square

        Shape rectangle = shapeFactory.createShape("RECTANGLE");
        rectangle.draw(); // Output: Drawing Rectangle
    }
}
