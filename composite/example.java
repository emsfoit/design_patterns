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