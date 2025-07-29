import java.io.BufferedReader;
import java.io.InputStreamReader;

@FunctionalInterface
interface Sum {
    int sum (int i, int j);
}

public class LambdaExpression2 {
    public static void main(String[] args) {
        Sum s = (i, j) ->  i+j;
        System.out.println(s.sum(2, 10));

         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter a number: ");
            int num = Integer.parseInt(br.readLine());
            System.out.println("You entered: " + num);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        
    }
}
