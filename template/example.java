// Template class
abstract class AbstractAlgorithm {
    // Template method that defines the algorithm structure
    public final void executeAlgorithm() {
        stepOne();
        stepTwo();
        stepThree();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void stepOne();
    protected abstract void stepTwo();
    protected abstract void stepThree();
}

// ConcreteTemplate subclass
class ConcreteAlgorithm extends AbstractAlgorithm {
    @Override
    protected void stepOne() {
        System.out.println("ConcreteAlgorithm - Step One");
    }

    @Override
    protected void stepTwo() {
        System.out.println("ConcreteAlgorithm - Step Two");
    }

    @Override
    protected void stepThree() {
        System.out.println("ConcreteAlgorithm - Step Three");
    }
}

// Client code
public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        AbstractAlgorithm algorithm = new ConcreteAlgorithm();
        algorithm.executeAlgorithm();
    }
}