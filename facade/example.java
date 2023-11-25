// Subsystem class 1
class SubsystemOne {
    public void operationOne() {
        System.out.println("Subsystem One - Operation One");
    }
}

// Subsystem class 2
class SubsystemTwo {
    public void operationTwo() {
        System.out.println("Subsystem Two - Operation Two");
    }
}

// Subsystem class 3
class SubsystemThree {
    public void operationThree() {
        System.out.println("Subsystem Three - Operation Three");
    }
}

// Facade class
class Facade {
    private SubsystemOne subsystemOne;
    private SubsystemTwo subsystemTwo;
    private SubsystemThree subsystemThree;

    public Facade() {
        this.subsystemOne = new SubsystemOne();
        this.subsystemTwo = new SubsystemTwo();
        this.subsystemThree = new SubsystemThree();
    }

    public void performOperations() {
        System.out.println("Facade - Performing Operations");
        subsystemOne.operationOne();
        subsystemTwo.operationTwo();
        subsystemThree.operationThree();
    }
}

// Client code
public class FacadePatternExample {
    public static void main(String[] args) {
        // Using the Facade to simplify interactions with the subsystem
        Facade facade = new Facade();
        facade.performOperations();
    }
}