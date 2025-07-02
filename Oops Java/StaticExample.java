class Math {
    static void sum (int a , int b){
        System.out.println(a+b);
    }

    static void difference (int a, int b){
        if(a>b){
            System.out.println(a-b);
        }
        else{
            System.out.println(b-a);
        }
    }
}

public class StaticExample {
    public static void main(String[] args) {
        
        Math m = new Math();
        m.sum(1, 2);

        Math.sum(10, 8);
        Math.difference(5, 12);
    }
}
