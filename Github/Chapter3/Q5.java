import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Q5 {
    public static void main(String[] args) {
       
        Map<Integer, String> map = new HashMap<>();
        map.put(101, "Ravi");
        map.put(102, "Riya");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key +"=>"+value);
        }

        Set<Map.Entry<Integer, String>> set = map.entrySet();
        System.out.println(set);
    }
}
