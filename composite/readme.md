The Composite Design Pattern is a structural design pattern that lets you compose objects into tree structures to represent part-whole hierarchies. It allows clients to treat individual objects and compositions of objects uniformly. In simpler terms, the pattern is used when clients need to treat both individual objects and compositions of objects in a uniform manner.

Key components of the Composite Pattern:

1. **Component:** This is the abstract class or interface that declares the common interface for all concrete classes (both leaf and composite). It defines the operations that can be performed on individual objects or compositions.

2. **Leaf:** This is the class that implements the Component interface for individual objects in the composition.

3. **Composite:** This is the class that implements the Component interface but also contains a collection of child components. It represents a composition of objects and defines operations that are specific to compositions.

Here's a simple example in Java to illustrate the Composite Pattern:

```java
import java.util.ArrayList;
import java.util.List;

// Component interface
interface Component {
    void operation();
}

// Leaf class
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + " - Operation");
    }
}

// Composite class
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite - Operation");
        for (Component child : children) {
            child.operation();
        }
    }
}

// Client code
public class CompositePatternExample {
    public static void main(String[] args) {
        Component leaf1 = new Leaf("1");
        Component leaf2 = new Leaf("2");
        Component leaf3 = new Leaf("3");

        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);

        Composite composite2 = new Composite();
        composite2.add(leaf3);

        composite.add(composite2);

        // Calling operation on individual leaf
        leaf1.operation(); // Output: Leaf 1 - Operation

        // Calling operation on composite
        composite.operation();
        /*
        Output:
        Composite - Operation
        Leaf 1 - Operation
        Leaf 2 - Operation
        Composite - Operation
        Leaf 3 - Operation
        */
    }
}
```

In this example:

- The `Component` interface declares the `operation` method, which is implemented by both `Leaf` and `Composite` classes.

- The `Leaf` class represents individual objects and implements the `Component` interface.

- The `Composite` class represents compositions of objects and contains a collection of child components. It also implements the `Component` interface.

- The client code demonstrates creating a composition of objects and calling the `operation` method on both individual objects (leaves) and compositions (composites).

The Composite Pattern is useful when you need to represent part-whole hierarchies, and clients should be able to treat individual objects and compositions of objects uniformly. It simplifies the client code by providing a consistent interface for both leaf and composite classes.