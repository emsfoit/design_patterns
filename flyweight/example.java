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