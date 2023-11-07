
public class Singleton {
    private static Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {
        // Initialization code, if any
    }

    // Static method to get the single instance of Singleton
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods and properties of the Singleton class
    public void doSomething() {
        System.out.println("Doing something in Singleton");
    }
}

// Usage of the Singleton:

public class Main {
    public static void main(String[] args) {
        // Accessing the Singleton instance
        Singleton singletonObject = Singleton.getInstance();
        singletonObject.doSomething(); // Output: Doing something in Singleton

        // Trying to create a new instance, but it returns the same instance
        Singleton anotherInstance = Singleton.getInstance();
        System.out.println(singletonObject == anotherInstance); // Output: true (the same instance)
    }
}
