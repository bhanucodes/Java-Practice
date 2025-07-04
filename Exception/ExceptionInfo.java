public class ExceptionInfo {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try{
            System.out.println(a/b);
        }
        catch(ArithmeticException object){
            System.out.println(object.getMessage());;
        }
        System.out.println("Hello");
    }
}
