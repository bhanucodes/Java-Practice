class Human {
    int limbs = 4;
    int head = 1;

    void eat() {
        System.out.println("Eats Food");
    }

    void sleep() {
        System.out.println("Shuts off at Night");
    }

    void work() {
        System.out.println("Works for food");
    }
}

class Brahman extends Human {
    void work() {
        System.out.println("Worship God");
    }
    
}

class Khastriya extends Human {
    void work(int n) {
        System.out.println("To protect the Law and Land");
    }
}

class Vaishya extends Human {
    void work() {
        System.out.println("To support the economics of the land");
    }
}

class Shudra extends Human {
    void work() {
        System.out.println("To help all the above in their duties");
    }
}

public class Oops {
    public static void main(String[] args) {

        Human ram = new Human();
        System.out.println(ram.head);
        ram.work();
        ram.eat();

        ram.limbs = 64;

        // Brahman vedvyas = new Brahman();
        // System.out.println(vedvyas.head);
        // vedvyas.eat();
        // vedvyas.work();

        // Shudra sonar = new Shudra();
        // System.out.println(sonar.head);
        // System.out.println(sonar.limbs);
        // sonar.eat();
        // sonar.sleep();
        // sonar.work();
        
    }
}
