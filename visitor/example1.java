// Visitor interface
interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

// ConcreteVisitor
class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("Visitor is processing ConcreteElementA");
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("Visitor is processing ConcreteElementB");
    }
}

// Element interface
interface Element {
    void accept(Visitor visitor);
}

// ConcreteElementA
class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// ConcreteElementB
class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// ObjectStructure
class ObjectStructure {
    private Element[] elements;

    public ObjectStructure(Element... elements) {
        this.elements = elements;
    }

    public void acceptVisitor(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}

// Client code
public class VisitorPatternExample {
    public static void main(String[] args) {
        ConcreteElementA elementA = new ConcreteElementA();
        ConcreteElementB elementB = new ConcreteElementB();

        ObjectStructure objectStructure = new ObjectStructure(elementA, elementB);

        Visitor visitor = new ConcreteVisitor();

        // Client invokes the visit operation on the elements
        objectStructure.acceptVisitor(visitor);
    }
}