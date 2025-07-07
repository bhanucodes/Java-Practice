import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q2 {
    public static void main(String[] args) {
        // in Hashset : unique element, uses Hashing
        // in Linked hashset: insertion order mainitained, unique elements, uses
        // Linkedlist + Hashing


        // This is the better code!
        Set<Integer> s = new HashSet<>();
        s.add(10);
        s.add(30);
        s.add(5);
        s.add(89);
        s.add(1);

        System.out.println(s);

        Set<Integer> ls = new LinkedHashSet<>();
        ls.add(10);
        ls.add(30);
        ls.add(5);
        ls.add(89);
        ls.add(1);

        System.out.println(ls);
    }

    
}
