@FunctionalInterface
interface A {
    public void show();
}

@FunctionalInterface
interface B {
    public void get(int i);
}

public class LambdaExpression {
    public static void main(String[] args) {

        // Anonymous Inner Class
        A obj = new A() {
            public void show() {
                System.out.println("Called by Anonymous Inner Class");
            }
        };
        obj.show();

        // Classic Lambda Approach
        A obje = () -> {
            System.out.println("Called by classic Lambda approach ");

        };
        obje.show();

        // Simplified Lambda Synatx
        A object = () -> System.out.println("Called by Simplified Lambda Syntax");
        object.show();

        // Parameterized

        // Anonymous Inner Class
        B item = new B() {
            public void get(int i) {
                System.out.println(i + " : Anonymous Inner Class");
            };
        };
        item.get(2);

        // Classic Lambda Approach
        B item2 = (int i) -> {
            System.out.println(i + " : Classical Lambda Approcah");

        };
        item2.get(3);

        // Lambda Approach after skipping parameter type (as it is already mentioned in the abstract method inside interface)
        B item3 = (i) -> System.out.println(i + " : Lambda Approach after skipping the type");
        item3.get(4);

        // Most simplest way of Lambda Expression
        B item4 = (int i)-> {
                System.out.println(i+" : Simplest Lambda Expression");
        };
        item4.get(5);
    }
}
