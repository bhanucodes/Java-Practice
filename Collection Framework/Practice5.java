import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Practice5 {
    public static void main(String[] args) {
        Queue <Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);

        System.out.println(pq);
    }
}


/*
 * Great! Let's understand it in the **simplest way** with real-life examples:

---

## 🟢 What is a Heap?

A **Heap** is a special **tree-based** data structure where:

* Every parent node follows a certain **ordering rule** with its children.
* It’s **complete** → always fills left to right (like a binary tree).

There are **two types**:

---

## 🔽 **1. Min-Heap**

👉 The **smallest** element is always at the **top (root)**.

### 🔹 Rule:

**Parent ≤ Children**

### 🔹 Example (visual):

```
     1
   /   \
  3     5
 / \   /
4   8 10
```

### 🔹 Real-Life Analogy:

* Think of **Google Maps traffic**, where you always want the **shortest distance** → top of heap gives you **minimum**.

### 🔹 In Java:

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
```

---

## 🔼 **2. Max-Heap**

👉 The **largest** element is always at the **top (root)**.

### 🔹 Rule:

**Parent ≥ Children**

### 🔹 Example:

```
     10
   /    \
  7      5
 / \    /
2   4  1
```

### 🔹 Real-Life Analogy:

* Think of a **battle game leaderboard**, where the **highest scorer stays on top**.

### 🔹 In Java:

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
```

---

## 🔁 Quick Comparison:

| Feature      | Min-Heap                | Max-Heap                                         |
| ------------ | ----------------------- | ------------------------------------------------ |
| Root Element | Smallest                | Largest                                          |
| Use Case     | Shortest path, Dijkstra | Leaderboard, priority tasks                      |
| Java Code    | `new PriorityQueue<>()` | `new PriorityQueue<>(Comparator.reverseOrder())` |

---

Let me know if you'd like a visual diagram PDF or want to build a custom min/max heap class from scratch!

 */
/*
 * Perfect! Let's dive deep into **`PriorityQueue` in Java**, covering:

---

### ✅ 1. **Default Behavior**

### ✅ 2. **Reverse Order (Max-Heap)**

### ✅ 3. **Custom Priority (using Comparator)**

### ✅ 4. **All Important Methods**

### ✅ 5. **Tips & Pitfalls**

---

## 🧠 1. Default `PriorityQueue` → Min-Heap

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(3);
pq.offer(1);
pq.offer(2);
System.out.println(pq.poll()); // 1 (smallest comes first)
```

---

## 🔁 2. Reverse Order → Max-Heap

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
pq.add(10);
pq.add(30);
pq.add(20);
System.out.println(pq.poll()); // 30
```

---

## 🔥 3. Custom Priority Using Comparator

### 📌 a. **String by Length**

```java
PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> a.length() - b.length());
pq.offer("elephant");
pq.offer("cat");
pq.offer("dog");
System.out.println(pq.poll()); // cat (shortest string first)
```

### 📌 b. **Sort Integers by Absolute Value**

```java
PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a) - Math.abs(b));
pq.offer(-5);
pq.offer(3);
pq.offer(1);
System.out.println(pq.poll()); // 1
```

### 📌 c. **Custom Class (e.g., Task Priority)**

```java
class Task {
    int priority;
    String name;

    Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

PriorityQueue<Task> taskQueue = new PriorityQueue<>((a, b) -> b.priority - a.priority); // Max priority first
taskQueue.offer(new Task(2, "Cook"));
taskQueue.offer(new Task(1, "Sleep"));
taskQueue.offer(new Task(5, "Study"));

System.out.println(taskQueue.poll()); // Study (Priority: 5)
```

---

## ✅ 4. All Important Methods (with Examples)

| Method               | Purpose                              | Example                        |
| -------------------- | ------------------------------------ | ------------------------------ |
| `add(E e)`           | Add element (throws if fails)        | `pq.add(5)`                    |
| `offer(E e)`         | Add element (returns false if fails) | `pq.offer(5)`                  |
| `peek()`             | View top element (no remove)         | `pq.peek()`                    |
| `poll()`             | Remove and return top                | `pq.poll()`                    |
| `remove(Object o)`   | Remove specific element              | `pq.remove(10)`                |
| `contains(Object o)` | Check if element exists              | `pq.contains(3)`               |
| `isEmpty()`          | Check if empty                       | `pq.isEmpty()`                 |
| `clear()`            | Remove all elements                  | `pq.clear()`                   |
| `size()`             | Current number of elements           | `pq.size()`                    |
| `toArray()`          | Convert to array                     | `Object[] arr = pq.toArray();` |
| `iterator()`         | Traverse (no guaranteed order)       | `for (int x : pq) {}`          |

---

## ⚠️ Important Notes

* **Not Sorted When Printed:** PriorityQueue maintains a **heap**, not sorted order.
* **Duplicates Allowed:** Yes.
* **Null not allowed.** Throws `NullPointerException`.

---

## 📌 Summary – Choose Based on Use Case

| Use Case                    | Comparator                           |
| --------------------------- | ------------------------------------ |
| Min-Heap (default)          | none                                 |
| Max-Heap                    | `Comparator.reverseOrder()`          |
| Custom logic                | `(a, b) -> customComparison`         |
| Custom object with priority | Comparator by field (`obj.priority`) |

---

Would you like this as a **printable PDF cheatsheet** with code snippets and diagrams? Or maybe want to simulate real-world examples like hospital queue, CPU scheduling, etc.?

 */
