The // Implementation interface
interface DrawingAPI {
    void drawCircle(int x, int y, int radius);
}

// Concrete implementation 1
class DrawingAPI1 implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("API1 - Drawing circle at " + x + ":" + y + " with radius " + radius);
    }
}

// Concrete implementation 2
class DrawingAPI2 implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("API2 - Drawing circle at " + x + ":" + y + " with radius " + radius);
    }
}

// Abstraction
abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    abstract void draw();
}

// Refined Abstraction
class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}

// Client code
public class BridgePatternExample {
    public static void main(String[] args) {
        DrawingAPI api1 = new DrawingAPI1();
        DrawingAPI api2 = new DrawingAPI2();

        Shape circle1 = new Circle(1, 2, 3, api1);
        Shape circle2 = new Circle(4, 5, 6, api2);

        circle1.draw(); // Output: API1 - Drawing circle at 1:2 with radius 3
        circle2.draw(); // Output: API2 - Drawing circle at 4:5 with radius 6
    }
} is a structural design pattern that separates abstraction from implementation, allowing them to vary independently. It involves creating a bridge interface that contains a reference to an implementation interface. This helps in decoupling abstraction (such as an abstraction class or interface) from the implementation, allowing both to evolve independently without affecting each other.

Key components of the Bridge Pattern:

1. **Abstraction:** This is the interface or abstract class that defines the high-level operations or features. It maintains a reference to an object of the implementation interface.

2. **Refined Abstraction:** This is a subclass of the abstraction that can add additional features or fine-tune existing features.

3. **Implementation:** This is the interface that defines the low-level operations or features. It is implemented by concrete classes.

4. **Concrete Implementation:** These are the classes that implement the implementation interface.

Here's a simplified example in Java:

```java
// Implementation interface
interface DrawingAPI {
    void drawCircle(int x, int y, int radius);
}

// Concrete implementation 1
class DrawingAPI1 implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("API1 - Drawing circle at " + x + ":" + y + " with radius " + radius);
    }
}

// Concrete implementation 2
class DrawingAPI2 implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("API2 - Drawing circle at " + x + ":" + y + " with radius " + radius);
    }
}

// Abstraction
abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    abstract void draw();
}

// Refined Abstraction
class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}

// Client code
public class BridgePatternExample {
    public static void main(String[] args) {
        DrawingAPI api1 = new DrawingAPI1();
        DrawingAPI api2 = new DrawingAPI2();

        Shape circle1 = new Circle(1, 2, 3, api1);
        Shape circle2 = new Circle(4, 5, 6, api2);

        circle1.draw(); // Output: API1 - Drawing circle at 1:2 with radius 3
        circle2.draw(); // Output: API2 - Drawing circle at 4:5 with radius 6
    }
}
```

In this example:

- The `DrawingAPI` interface defines the low-level drawing operations.

- `DrawingAPI1` and `DrawingAPI2` are concrete implementations of the `DrawingAPI` interface.

- The `Shape` class is the abstraction, which has a reference to the `DrawingAPI` interface. It declares the high-level `draw` method.

- The `Circle` class is a refined abstraction that extends `Shape` and provides a specific implementation of the `draw` method using the `DrawingAPI`.

The Bridge Pattern allows the abstraction (`Shape`) and the implementation (`DrawingAPI`) to vary independently. It promotes flexibility and extensibility by allowing new shapes and drawing APIs to be added without modifying existing code.