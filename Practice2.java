import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Practice2 {
    public static void main(String[] args) {
        Deque<String> animals = new ArrayDeque<>();
        animals.push("Lion");
        animals.push("Tiger");
        animals.push("Pig");
        animals.push("Cow");

        System.out.println(animals);
        animals.pop();
        System.out.println(animals);
    }
}

/*
 * Excellent question!
 * 
 * It depends on **what kind of behavior you want** in your program — because
 * `Stack` and `List` serve **very different purposes**.
 * 
 * ---
 * 
 * ## 🔍 Difference Between Stack and List:
 * 
 * | Feature | `Stack` | `List` |
 * | ----------- | -------------------------------------------------- |
 * ---------------------------------------- |
 * | Type | LIFO (Last In, First Out) | Ordered collection (like an array) |
 * | Main Use | For backtracking, undo operations, recursive logic | For storing
 * and accessing items by index |
 * | Key Methods | `push()`, `pop()`, `peek()` | `add()`, `get()`, `remove()` |
 * | Data Flow | Push from top, pop from top | Access any index |
 * | Flexibility | Specialized (LIFO only) | More general-purpose |
 * 
 * ---
 * 
 * ## ✅ When to use `Stack`?
 * 
 * Use `Stack` when you need **LIFO behavior**, for example:
 * 
 * Undo/Redo functionality
 * Browser back-button logic
 * Tree/graph DFS (Depth First Search)
 * Recursive algorithms
 * Parsing brackets or expression evaluation
 * 
 * ```java
 * Stack<Integer> stack = new Stack<>();
 * stack.push(1);
 * stack.push(2);
 * System.out.println(stack.pop()); // 2
 * ```
 * 
 * ---
 * 
 * ## ✅ When to use `List`?
 * 
 * Use `List` when you need:
 * 
 * Random access to any element by index
 * General-purpose dynamic array
 * Iteration in insertion order
 * 
 * ```java
 * List<String> names = new ArrayList<>();
 * names.add("Rama");
 * names.add("Krishna");
 * System.out.println(names.get(1)); // Krishna
 * ```
 * 
 * ---
 * 
 * ## ⚠️ One Important Note:
 * 
 * Java's `Stack` is a **legacy class** (from old Java days).
 * If you're writing modern code, prefer:
 * 
 * ```java
 * Deque<Integer> stack = new ArrayDeque<>();
 * stack.push(10);
 * stack.pop();
 * ```
 * 
 * Why?
 * 
 * `ArrayDeque` is faster
 * `Stack` is synchronized (overhead for single-threaded use)
 * 
 * ---
 * 
 * ## ✅ Final Recommendation:
 * 
 * | Your Need | Use This |
 * | ---------------------- |
 * ----------------------------------------------------------- |
 * | LIFO (stack behavior) | `Deque<T> stack = new ArrayDeque<>();` ✅ Modern &
 * efficient |
 * | Dynamic indexable list | `List<T> list = new ArrayList<>();` ✅ Common usage
 * |
 * | Need both? | Use both separately as per logic |
 * 
 * ---
 * 
 * Let me know your use-case, and I’ll recommend exactly what’s best for you.
 * 
 */

 /*
  * Ah, got it! You're asking:

> ❓ **Which declaration is better:**

```java
Stack<String> animals = new Stack<>();
// or
List<String> animals = new Stack<>();
// or something else?
```

Let’s break it down clearly.

---

## 🧠 Key Concepts:

### 🔹 `Stack` is a **legacy class** (extends `Vector`, synchronized — outdated for modern use).

### 🔹 `List` is a general-purpose ordered collection (but doesn’t support stack-specific methods like `.push()` and `.pop()`).

### 🔹 **Modern Java (Java 6+) prefers:** `Deque` for stack behavior.

---

## ✅ Recommendation (Modern, Best Practice):

```java
Deque<String> animals = new ArrayDeque<>();
animals.push("Lion");
animals.push("Tiger");
System.out.println(animals.pop());  // Output: Tiger
```

### ✔️ Why?

* `Deque` is **meant for both stack (LIFO)** and **queue (FIFO)** behavior.
* `ArrayDeque` is **faster**, **not synchronized**, and **modern**.
* Has all stack methods: `push()`, `pop()`, `peek()`.

---

## 🤔 But if you **must** use `Stack`:

### Option 1:

```java
Stack<String> animals = new Stack<>();
```

✔️ Use this if you need **full access to stack methods** (`push()`, `pop()`, etc.).

### Option 2:

```java
List<String> animals = new Stack<>();
```

❌ Not recommended — because:

* You're **hiding stack-specific methods** (`push()`, `pop()`, `peek()`).
* You're **coding to a wrong interface** (`List` isn't a stack!).

---

## ✅ Final Verdict

| Option                                        | Recommended?     | Notes                                    |
| --------------------------------------------- | ---------------- | ---------------------------------------- |
| `Stack<String> animals = new Stack<>();`      | ⚠️ Okay (legacy) | Use only if `Stack` is required          |
| `List<String> animals = new Stack<>();`       | ❌ No             | Hides stack behavior                     |
| `Deque<String> animals = new ArrayDeque<>();` | ✅ Yes            | ✔️ Best modern way to use stack behavior |

---

Would you like a comparison PDF or code cheatsheet for `Stack vs Deque` usage too?

  */

  /*
   * Absolutely! Here's a complete **Java Collection Framework summary** — showing which **interface**, which **implementation**, and **when to use what**.

---

# ✅ Java Collections – Interface, Implementation, Best Use Case

---

## 🟦 **1. List Interface**

* **Used when:** You want an **ordered** collection that allows **duplicates** and index-based access.

| Implementation | When to Use                                                                   | Key Features                      |
| -------------- | ----------------------------------------------------------------------------- | --------------------------------- |
| `ArrayList`    | When you need **fast access by index** and rarely insert/delete in the middle | Dynamic array, fast random access |
| `LinkedList`   | When you need **frequent insertions/deletions** at start/middle               | Doubly-linked list, slower access |
| `Vector`       | When you need a **thread-safe** list (rare)                                   | Synchronized, legacy              |
| `Stack`        | When you need **LIFO (Last-In, First-Out)** behavior                          | Legacy class, use `Deque` instead |

---

## 🟩 **2. Set Interface**

* **Used when:** You want a **collection of unique elements** (no duplicates).

| Implementation  | When to Use                                   | Key Features                                      |
| --------------- | --------------------------------------------- | ------------------------------------------------- |
| `HashSet`       | When you need a **fast, unordered** set       | No duplicates, fast lookup                        |
| `LinkedHashSet` | When you need to **maintain insertion order** | Ordered + fast                                    |
| `TreeSet`       | When you need a **sorted set**                | Automatically sorts elements (natural/comparator) |

---

## 🟨 **3. Queue Interface**

* **Used when:** You need **FIFO (First-In, First-Out)** behavior or task scheduling.

| Implementation  | When to Use                                      | Key Features                       |
| --------------- | ------------------------------------------------ | ---------------------------------- |
| `LinkedList`    | As a **Queue** or **Deque**                      | Double-ended queue + List features |
| `PriorityQueue` | When you need elements processed by **priority** | Uses natural order or comparator   |
| `ArrayDeque`    | When you need a fast **queue or stack**          | No size limit, better than `Stack` |

---

## 🟧 **4. Deque Interface (Double-Ended Queue)**

* **Used when:** You need to insert/remove from **both ends**, or simulate a **stack** or **queue**.

| Implementation | When to Use                                          | Key Features                   |
| -------------- | ---------------------------------------------------- | ------------------------------ |
| `ArrayDeque`   | Best choice for **stack** or **queue** behavior      | Fast, modern, no sync overhead |
| `LinkedList`   | When you need Deque with **bidirectional traversal** | Slightly slower, more memory   |

---

## 🟥 **5. Map Interface**

* **Used when:** You need to store **key-value pairs**.

| Implementation  | When to Use                                   | Key Features                  |
| --------------- | --------------------------------------------- | ----------------------------- |
| `HashMap`       | Default choice for fast lookup                | No order, allows one null key |
| `LinkedHashMap` | When you want to maintain **insertion order** | Ordered map                   |
| `TreeMap`       | When you want **sorted keys**                 | Sorted by natural/comparator  |
| `Hashtable`     | When you want a **thread-safe legacy** map    | Synchronized, slower          |

---

# 🔥 Bonus: What to Use in Common Situations

| Problem Type                             | Best Interface + Class                 |
| ---------------------------------------- | -------------------------------------- |
| Random access list                       | `List` + `ArrayList`                   |
| Frequent insert/delete from start/middle | `List` + `LinkedList`                  |
| Unique, unordered items                  | `Set` + `HashSet`                      |
| Sorted unique items                      | `Set` + `TreeSet`                      |
| Insertion order set                      | `Set` + `LinkedHashSet`                |
| FIFO queue                               | `Queue` + `ArrayDeque` or `LinkedList` |
| Priority-based processing                | `Queue` + `PriorityQueue`              |
| Stack behavior (LIFO)                    | `Deque` + `ArrayDeque`                 |
| Key-value lookup                         | `Map` + `HashMap`                      |
| Sorted map                               | `Map` + `TreeMap`                      |
| Ordered map                              | `Map` + `LinkedHashMap`                |

---

Let me know if you want a visual diagram version, interview-focused table, or code snippets for any of these.

   */