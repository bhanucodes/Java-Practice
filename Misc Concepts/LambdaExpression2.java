@FunctionalInterface
interface Sum {
    int sum (int i, int j);
}

public class LambdaExpression2 {
    public static void main(String[] args) {
        Sum s = (i, j) ->  i+j;
        System.out.println(s.sum(2, 10));

        
        
    }
}
