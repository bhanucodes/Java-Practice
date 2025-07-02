import java.util.Queue;
import java.util.LinkedList;
public class Practice3 {
    public static void main(String[] args) {
        Queue <Integer> q = new LinkedList<>();

        q.offer(1);
        q.offer(2);
        q.offer(3);
       

        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q);
        q.poll(); // remove kro - removes 1st element of queue
        // System.out.println(q.poll()); // kya remove hua 
        System.out.println(q); // kya bacha hai
    }
}
