package CapgeminiTraining.Java.Assignment3;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Test fail-safe iterators within multithreaded environment.
 * Note:
 * Fail-fast examples → ArrayList, HashSet, HashMap, etc.
 * Fail-safe examples → CopyOnWriteArrayList, ConcurrentHashMap, etc.
 */

public class Q9 {
    
    public static CopyOnWriteArrayList<Integer> failSafe(CopyOnWriteArrayList<Integer> list) {
        Iterator<Integer> itr = list.iterator();
        
        while (itr.hasNext()) {
            Integer num = itr.next();
            System.out.println(num);

            // Modifying the list during iteration
            list.add(78);
        }
        return list;
    }

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(new Integer[] {1, 3, 5, 8});
        failSafe(list);
    }
}
