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