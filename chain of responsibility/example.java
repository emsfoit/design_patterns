// Handler interface
interface Handler {
    void handleRequest(Request request);
}

// Request class
class Request {
    private int value;

    public Request(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

// ConcreteHandler 1
class ConcreteHandler1 implements Handler {
    private static final int THRESHOLD = 10;
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getValue() <= THRESHOLD) {
            System.out.println("Request handled by ConcreteHandler1");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// ConcreteHandler 2
class ConcreteHandler2 implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        System.out.println("Request handled by ConcreteHandler2");
    }
}

// Client code
public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        // Creating the chain of handlers
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNextHandler(handler2);

        // Initiating a request
        Request request = new Request(5);
        handler1.handleRequest(request);
        /*
        Output:
        Request handled by ConcreteHandler1
        */

        // Initiating another request
        Request request2 = new Request(15);
        handler1.handleRequest(request2);
        /*
        Output:
        Request handled by ConcreteHandler2
        */
    }
}