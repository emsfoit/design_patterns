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

### Flyweight Examples:

The Flyweight Design Pattern is used to minimize memory usage or computational expenses by sharing as much as possible with related objects; it is particularly useful when a large number of similar objects need to be created. Here are some real-world examples where the Flyweight Pattern is applicable:

1. **Text Editors and Character Rendering:**
   - In a text editor, each character in a document can be represented as a separate object.
   - The Flyweight Pattern can be applied to share common character attributes (e.g., font, size) among multiple instances of the same character, reducing memory consumption.

2. **Graphics and Shape Rendering:**
   - In graphic design applications, individual graphical elements such as lines, circles, and rectangles may be represented as objects.
   - The Flyweight Pattern can be used to share common attributes (e.g., color, style) among multiple instances of the same graphical element, optimizing memory usage.

3. **Word Processors and Font Management:**
   - In word processors, different parts of a document may have text with varying fonts, sizes, and styles.
   - The Flyweight Pattern can be applied to share common font information among multiple instances of text with the same formatting, reducing the overall memory footprint.

4. **Game Development and Terrain Tiles:**
   - In a tile-based game, terrain tiles with different textures and properties can be represented as objects.
   - The Flyweight Pattern can be used to share common properties (e.g., texture, collision behavior) among tiles of the same type, conserving memory and improving performance.

5. **Web Caching and Content Delivery Networks (CDNs):**
   - Content Delivery Networks (CDNs) often cache and distribute content, such as images and stylesheets, to improve website performance.
   - The Flyweight Pattern can be applied to cache and share common resources among multiple requests, reducing the load on servers and improving response times.

6. **Inventory Management Systems:**
   - In an inventory system, products with similar attributes may be represented as individual objects.
   - The Flyweight Pattern can be used to share common attributes (e.g., product name, category) among instances of products with the same characteristics, optimizing memory usage.

7. **Document Object Model (DOM) in Web Browsers:**
   - In web browsers, the DOM represents the structure of a web page using objects for elements like paragraphs, images, and headings.
   - The Flyweight Pattern can be applied to share common attributes (e.g., tag name, attributes) among instances of similar DOM elements, reducing the memory footprint of the DOM tree.

8. **Financial Applications and Currency Objects:**
   - In financial applications dealing with multiple currencies, currency objects with exchange rates and symbols may be created.
   - The Flyweight Pattern can be used to share common currency information among instances of the same currency, avoiding unnecessary duplication of data.

In these examples, the Flyweight Pattern helps reduce the memory usage and computational overhead associated with creating and managing a large number of similar objects by sharing common attributes. This optimization is particularly beneficial when dealing with a large number of instances and when the shared state can be externalized and shared among multiple objects.