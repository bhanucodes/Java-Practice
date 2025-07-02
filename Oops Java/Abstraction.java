class Bhagwan {

    

    void property() {
        System.out.println("Earth");
    }

    Bhagwan() {
        System.out.println("GOD");
    }
}

class Insaan extends Bhagwan {
    void karm() {
        System.out.println("Breathe from mouth");
    }
    Insaan (){
        System.out.println("4limbs 1 head body");
    }
}

class Animal extends Bhagwan {
    void karm() {
        System.out.println("Breathe through Gills");
    }
}

public class Abstraction {
    public static void main(String[] args) {

        Insaan aadmi = new Insaan();
 
    }
}
