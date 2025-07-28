@FunctionalInterface
interface A {
    void show();

}

// Using Functional Interface using a class - Traditional Way
class B implements A {
    public void show() {
        System.out.println("using Traditional way to implement a functional interface");
    }
}

public class FunctionalInterfaceSAM {
    public static void main(String[] args) {

        // using traditional class
        A obj = new B();
        obj.show();

        // using Anonymous Inner ClassF
        A object = new A() {

            public void show() {
                System.out.println("Using Inner class way");
            }
        };
        object.show();

        // using lambda

        A objekt = () -> {
            System.out.println("Using lambda expression");
        };

        objekt.show();
    }
}
