interface CloneableShape extends Cloneable {
    CloneableShape clone();
    void draw();
}

// Concrete prototype
class Circle implements CloneableShape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public CloneableShape clone() {
        return new Circle(this.radius);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius " + radius);
    }
}

// Client class
public class ShapeClient {
    public static void main(String[] args) {
        // Creating a prototype instance
        CloneableShape circlePrototype = new Circle(10);

        // Creating new objects by cloning the prototype
        CloneableShape circle1 = circlePrototype.clone();
        CloneableShape circle2 = circlePrototype.clone();

        // Drawing the circles
        circle1.draw(); // Output: Drawing Circle with radius 10
        circle2.draw(); // Output: Drawing Circle with radius 10
    }
}