// State interface
interface State {
    void handle(Context context);
}

// ConcreteState classes
class ConcreteStateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Handling State A");
        context.setState(new ConcreteStateB()); // Transition to State B
    }
}

class ConcreteStateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Handling State B");
        context.setState(new ConcreteStateA()); // Transition to State A
    }
}

// Context class
class Context {
    private State currentState;

    public Context() {
        this.currentState = new ConcreteStateA(); // Initial state is State A
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handle(this);
    }
}

// Client code
public class StatePatternExample {
    public static void main(String[] args) {
        Context context = new Context();

        context.request(); // Output: Handling State A
        context.request(); // Output: Handling State B
        context.request(); // Output: Handling State A
    }
}