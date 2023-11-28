// Mediator interface
interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

// Colleague interface
interface Colleague {
    void receiveMessage(String message);
    void sendMessage(String message);
}

// Concrete Mediator
class ConcreteMediator implements Mediator {
    private Colleague colleague1;
    private Colleague colleague2;

    public void setColleague1(Colleague colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(Colleague colleague2) {
        this.colleague2 = colleague2;
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.receiveMessage(message);
        } else if (colleague == colleague2) {
            colleague1.receiveMessage(message);
        }
    }
}

// Concrete Colleague 1
class ConcreteColleague1 implements Colleague {
    private Mediator mediator;

    public ConcreteColleague1(Mediator mediator) {
        this.mediator = mediator;
        mediator.setColleague1(this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Colleague 1 received message: " + message);
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }
}

// Concrete Colleague 2
class ConcreteColleague2 implements Colleague {
    private Mediator mediator;

    public ConcreteColleague2(Mediator mediator) {
        this.mediator = mediator;
        mediator.setColleague2(this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Colleague 2 received message: " + message);
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }
}

// Client code
public class MediatorPatternExample {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        colleague1.sendMessage("Hello from Colleague 1!"); // Output: Colleague 2 received message: Hello from Colleague 1!
        colleague2.sendMessage("Hi from Colleague 2!");    // Output: Colleague 1 received message: Hi from Colleague 2!
    }
}