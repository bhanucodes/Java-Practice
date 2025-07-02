import java.util.ArrayDeque;
import java.util.Deque;

public class Practice4 {
    public static void main(String[] args) {

        Deque <Integer> dq = new ArrayDeque<>();
        dq.offer(1);
        dq.offer(2);

        System.out.println(dq);

        dq.offerFirst(3);
        System.out.println(dq);
        dq.offerLast(6);
        System.out.println(dq);
        // offerLast use kro last me ya sirf last use kro..baat same hi parega
        
        System.out.println(dq.pollLast());
        System.out.println(dq);
    }
}



















/*
 * Great question! Let's answer it simply and clearly:

---

## ❓ You want to implement a double-ended queue using `ArrayDeque`.

Which is better?

### ✅ Option 1 (Recommended):

```java
Deque<String> dq = new ArrayDeque<>();
```

### ❌ Option 2 (Not Recommended):

```java
ArrayDeque<String> dq = new ArrayDeque<>();
```

---

## ✅ Why `Deque` on the left is **better**:

| Aspect                | `Deque` = new `ArrayDeque<>()`                                  | `ArrayDeque` = new `ArrayDeque<>()`   |
| --------------------- | --------------------------------------------------------------- | ------------------------------------- |
| ✅ Coding to interface | Yes                                                             | ❌ No                                  |
| ✅ Flexibility         | High – You can replace with `LinkedList` or other `Deque` later | Low – Tied to this one class          |
| ✅ Clean API usage     | Exposes only what you need (push, pop, poll, offer...)          | Exposes everything (more than needed) |
| ✅ Best Practice       | ✔️ Yes (modern Java style)                                      | ❌ No (rigid)                          |

---

## 🎯 Real-Life Analogy:

* `Deque dq = new ArrayDeque<>()`
  ➤ "I want a vehicle. Right now, I'm using a car."

* `ArrayDeque dq = new ArrayDeque<>()`
  ➤ "I want a Maruti Swift. I can't change it later, even if a better vehicle appears."

---

## ⚡ Summary

> ✅ **Always prefer:**

```java
Deque<T> dq = new ArrayDeque<>();
```

Because:

* You get **flexibility** (can switch to other `Deque` types).
* You follow the principle: **"Code to interface, not to implementation."**

---

Let me know if you'd like a diagram or cheatsheet comparing this for all major interfaces like List, Set, Queue, etc.

 */