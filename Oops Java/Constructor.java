class Human {
    int limbs = 4;
    int head = 1;
    String place = "Earth";

    Human(){ 
        System.out.println("Raaaaaam");
        //Non Parameterised constructor
    }

    Human(int limbs){
        System.out.println("The no. of limbs with which the child is born -" + limbs);
        // Parameterised constructor
    }

    Human (String color){
        System.out.println("The color of the child is "+color);
        // Parameterised constructor
    }

}

public class Constructor {
    public static void main(String[] args) {
        Human manu = new Human();
        Human kaalu = new Human("Gora");
        Human babu = new Human (10);
        // The phenomenon of calling suitable constructor according to the type of object creasted is called Constructor Overloading.---->> Polymorphism ka example
    }
}
