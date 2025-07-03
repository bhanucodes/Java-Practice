import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Practice8 {

    public static void main(String[] args) {
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(1, "A");
        hashmap.put(3, "B");
        hashmap.put(2, "C"); // it will update the value of key=2, from B to C

        System.out.println(hashmap);

        Map<Integer, String> linkedHashmap = new LinkedHashMap<>();
        linkedHashmap.put(1, "A");
        linkedHashmap.put(3, "B");
        linkedHashmap.put(2, "C");
        System.out.println(linkedHashmap);

        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "A");
        treeMap.put(3, "B");
        treeMap.put(2, "C");
        System.out.println(treeMap);

        Integer a = 4;
        System.out.println(a);

        Character c = 'a';

        StringBuilder d = new StringBuilder();
        d.append("Bhanu");
        System.out.println(d);

        String b = "String";
        String s = new String();
        
    }
}