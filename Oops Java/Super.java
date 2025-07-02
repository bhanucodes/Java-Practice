
class Animal {
    String color = "Black";

    static void print(){
        System.out.println("I am super");
    }

}

class Horse extends Animal {

    void colorOfSuper() {
        System.out.println(super.color);
        super.print();
    }

    static void  pp (){
        System.out.println("PPPP");
    }
}

public class Super {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.colorOfSuper();

        Horse.pp();
        
    }
}
