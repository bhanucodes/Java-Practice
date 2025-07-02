import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Practice6 {
    public static void main(String[] args) {
        
        // Singly Linkedlist-----------------------Java's LinkedList is internally a Doubly Linked List, even when accessed via Queue or List.So you are simulating a singly linked list, but under the hood, it’s doubly linked.Best simulation:Use Queue interface.
        // Way 1 : List - LinkedList
        List <Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(5);
        ll.add(3);

        System.out.println(ll);

        //Way 2 : Queue - LinkedList

        Queue <String> ll2 = new LinkedList<>();
        ll2.offer("Apple");
        ll2.offer("Banana");
        ll2.offer("Mango");

        System.out.println(ll2);



        // Doubly LinkedList --------------------------------------------------------------------------
        Deque <Integer> dll = new LinkedList<>();
        dll.add(3);
        dll.addFirst(1);
        dll.add(2);
        System.out.println(dll);


        // Circular Linkedlist ----------- just for simulation we can use Deque-ArrayDeque/LinkedList- but actually Neither Deque nor ArrayDeque maintains circular links.Internally, ArrayDeque is a resizable array, not a circular node-based structure.You’ll need to manually implement circular behavior using DSA.
        
        Deque <Integer> cll = new LinkedList<>();
        cll.add(1);
        cll.add(2);
        cll.add(3);
        cll.addFirst(1);
        System.out.println(cll); // using this just to create circular linked list illusion.
    }
}

/*
 * Great thinking! You're connecting **data structures** like
 * **Singly/Doubly/Circular Linked Lists** with **Java Collection Framework**
 * classes — let's clarify **what’s possible, what’s not, and why.**
 * 
 * ---
 * 
 * ## ✅ 1. **Singly Linked List**
 * 
 * You asked:
 * 
 * > Can we use `Queue` + `LinkedList` for singly linked list?
 * 
 * ### ✔️ Yes, partially.
 * 
 * ```java
 * Queue<Integer> q = new LinkedList<>();
 * ```
 * 
 * ### But:
 * 
 * Java's `LinkedList` is internally a **Doubly Linked List**, even when
 * accessed via `Queue` or `List`.
 * So **you are simulating a singly linked list**, but under the hood, it’s
 * doubly linked.
 ** 
 * Best simulation:**
 * 
 * Use `Queue` interface if you're only doing **enqueue/dequeue (FIFO)**.
 * But if you need full control like `next` pointer, create a custom `Node`
 * class manually (as done in DSA).
 * 
 * ---
 * 
 * ## ✅ 2. **Doubly Linked List**
 * 
 * You asked:
 * 
 * > Can we use `Deque` + `LinkedList` for doubly linked list?
 * 
 * ### ✔️ Absolutely.
 * 
 * ```java
 * Deque<Integer> dq = new LinkedList<>();
 * ```
 * 
 * ### Why this works well:
 * 
 * Java's `LinkedList` **is implemented as a doubly linked list.**
 * `Deque` interface gives you access to **both ends** (head/tail).
 * You get methods like:
 * 
 * `addFirst()`, `addLast()`
 * `removeFirst()`, `removeLast()`
 * `peekFirst()`, `peekLast()`
 * 
 * So:
 * 
 * > ✅ Best built-in choice for doubly linked list = `Deque` + `LinkedList`
 * 
 * ---
 * 
 * ## ⚠️ 3. **Circular Linked List**
 * 
 * You asked:
 * 
 * > Can we use `Deque` + `ArrayDeque` for circular linked list?
 * 
 * ### ❌ No, not truly.
 * 
 * Neither `Deque` nor `ArrayDeque` maintains **circular links**.
 * Internally, `ArrayDeque` is **a resizable array**, not a circular node-based
 * structure.
 * 
 * ### You’ll **need to manually implement** circular behavior like:
 * 
 * ```java
 * class Node {
 * int data;
 * Node next;
 * 
 * Node(int data) {
 * this.data = data;
 * this.next = this; // circular link
 * }
 * }
 * ```
 * 
 * > ✅ Circular Linked List = **manual implementation only**
 * > ❌ No built-in class in Java Collections Framework supports circular linking
 * 
 * ---
 * 
 * ## ✅ Summary Table
 * 
 * | Linked List Type | Java Built-in Support? | Best Class / Interface |
 * | -------------------- | ---------------------- |
 * --------------------------------------------------- |
 * | Singly Linked List | ❌ (simulate only) | `Queue + LinkedList` (limited) or
 * custom Node class |
 * | Doubly Linked List | ✅ Yes | `Deque + LinkedList` |
 * | Circular Linked List | ❌ No | Manual custom implementation only |
 * 
 * ---
 * 
 * If you want, I can give you:
 * 
 * A full implementation of a circular linked list
 * Diagrams showing how LinkedList vs Deque vs ArrayDeque behave internally
 * 
 * Let me know!
 * 
 */
