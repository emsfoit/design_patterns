// Product: House
class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    public House() {
        // Initialization or default values
    }

    // Getters and setters for house parts
    // ...
}

// Builder Interface
interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    void buildInterior();
    House getHouse();
}

// Concrete Builder
class ConcreteHouseBuilder implements HouseBuilder {
    private House house;

    public ConcreteHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.foundation = "Concrete";
    }

    @Override
    public void buildStructure() {
        house.structure = "Brick";
    }

    @Override
    public void buildRoof() {
        house.roof = "Tiles";
    }

    @Override
    public void buildInterior() {
        house.interior = "Modern";
    }

    @Override
    public House getHouse() {
        return house;
    }
}

// Director
class HouseDirector {
    private HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void constructHouse() {
        houseBuilder.buildFoundation();
        houseBuilder.buildStructure();
        houseBuilder.buildRoof();
        houseBuilder.buildInterior();
    }
}

// Usage of Builder Pattern
public class Main {
    public static void main(String[] args) {
        HouseBuilder houseBuilder = new ConcreteHouseBuilder();
        HouseDirector houseDirector = new HouseDirector(houseBuilder);

        houseDirector.constructHouse();
        House house = houseBuilder.getHouse();

        // Use the constructed house object
        // ...
    }
}
