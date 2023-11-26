The Flyweight Design Pattern is a structural design pattern that is used to minimize memory usage or computational expenses by sharing as much as possible with related objects. It is particularly useful when a large number of similar objects need to be created and a significant portion of the object's state is shared among them.

Key components of the Flyweight Pattern:

1. **Flyweight Interface:** This is an interface or abstract class that defines the methods that must be implemented by concrete flyweight objects. These methods typically include operations that can be shared among multiple objects.

2. **Concrete Flyweight:** This is the concrete implementation of the flyweight interface. It contains the intrinsic state that can be shared among multiple objects. The intrinsic state is immutable and generally independent of the context in which the flyweight is used.

3. **Flyweight Factory:** This is a factory class that manages the creation and reuse of flyweight objects. It typically includes a pool or cache of existing flyweight objects and provides a way to retrieve or create new flyweights.

4. **Client:** This is the class or module that uses the flyweight objects. It may maintain an extrinsic state, which is the state that varies and is not shared among flyweight objects.

Here's a simple example in Java to illustrate the Flyweight Pattern:

```java
import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface CoffeeOrder {
    void serveCoffee(CoffeeContext context);
}

// Concrete flyweight
class CoffeeFlavor implements CoffeeOrder {
    private final String flavor;

    public CoffeeFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public void serveCoffee(CoffeeContext context) {
        System.out.println("Serving coffee flavor " + flavor + " to table " + context.getTableNumber());
    }
}

// Context for extrinsic state
class CoffeeContext {
    private final int tableNumber;

    public CoffeeContext(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }
}

// Flyweight factory
class CoffeeFlavorFactory {
    private Map<String, CoffeeFlavor> flavors = new HashMap<>();

    public CoffeeFlavor getCoffeeFlavor(String flavor) {
        if (!flavors.containsKey(flavor)) {
            flavors.put(flavor, new CoffeeFlavor(flavor));
        }
        return flavors.get(flavor);
    }
}

// Client code
public class FlyweightPatternExample {
    public static void main(String[] args) {
        CoffeeFlavorFactory flavorFactory = new CoffeeFlavorFactory();

        // Serving coffee with intrinsic state "Caramel"
        CoffeeFlavor caramelCoffee = flavorFactory.getCoffeeFlavor("Caramel");
        caramelCoffee.serveCoffee(new CoffeeContext(1));

        // Serving coffee with intrinsic state "Vanilla"
        CoffeeFlavor vanillaCoffee = flavorFactory.getCoffeeFlavor("Vanilla");
        vanillaCoffee.serveCoffee(new CoffeeContext(2));

        // Serving coffee with intrinsic state "Caramel" again (reusing flyweight)
        CoffeeFlavor caramelCoffee2 = flavorFactory.getCoffeeFlavor("Caramel");
        caramelCoffee2.serveCoffee(new CoffeeContext(3));
    }
}
```

In this example:

- The `CoffeeOrder` interface defines the `serveCoffee` method, which is implemented by the concrete flyweight `CoffeeFlavor`.

- The `CoffeeFlavor` class represents the concrete flyweight. It has an intrinsic state (`flavor`) that can be shared among multiple objects.

- The `CoffeeContext` class represents the extrinsic state, which is the state that varies and is not shared among flyweight objects.

- The `CoffeeFlavorFactory` class is the flyweight factory, managing the creation and reuse of flyweight objects.

- The client code demonstrates creating and serving coffee with different flavors, reusing the flyweight objects when the intrinsic state is the same.

The Flyweight Pattern is useful when a large number of objects (more than 100000 object) with similar state need to be created and memory usage or computational expenses need to be minimized. It allows for efficient sharing of common state among multiple objects.

Check also the code in https://www.newthinktank.com/2012/10/flyweight-design-pattern-tutorial/