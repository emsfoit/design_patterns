// Subject interface
interface Image {
    void display();
}

// RealSubject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client code
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("example.jpg");

        // The real object is loaded only when needed
        image.display();

        // The real object is not loaded again; it is reused
        image.display();
    }
}