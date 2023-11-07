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