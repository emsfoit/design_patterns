The Command Design Pattern is a behavioral design pattern that turns a request into a standalone object. This object contains all the information about the request, allowing for the parameterization of clients with different requests, queuing of requests, and the support of undoable operations.

Key components of the Command Pattern:

1. **Command:** This is an interface or an abstract class that declares the `execute` method. It represents an operation or a request.

2. **ConcreteCommand:** Implements the `Command` interface. It defines a binding between a specific action and a receiver (an object that performs the action).

3. **Invoker:** Asks the command to execute the request. It does not need to know the specifics of the command or the receiver.

4. **Receiver:** Knows how to perform the operation associated with the command.

5. **Client:** Creates a concrete command and associates it with a receiver. It also associates the command with an invoker.

Here's a simple example in Java to illustrate the Command Pattern:

```java
// Command interface
interface Command {
    void execute();
}

// ConcreteCommand
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client
public class CommandPatternExample {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOnCommand);

        // Pressing the button invokes the command
        remoteControl.pressButton(); // Output: Light is ON
    }
}
```

In this example:

- The `Command` interface declares the `execute` method.

- The `LightOnCommand` is a concrete command that turns on the light when executed.

- The `Light` is the receiver that knows how to perform the operation (turn on or off the light).

- The `RemoteControl` is the invoker that is responsible for triggering the command.

- The client creates a specific command (`LightOnCommand`) and associates it with a receiver (`Light`). The invoker (`RemoteControl`) then triggers the command, and the receiver performs the associated operation.

The Command Pattern allows for decoupling the sender and receiver of a request, enabling more flexibility in handling requests and supporting operations such as undo and redo. It is commonly used in scenarios where the client should be shielded from the details of the objects that perform actions, providing a more extensible and maintainable design.