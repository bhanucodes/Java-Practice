import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Practice7 {
    public static void main(String[] args) {
        Set<Integer> hashset = new HashSet<>();
        hashset.add(1);
        hashset.add(3);
        hashset.add(2);
        hashset.add(4);

        System.out.println(hashset);

        Set<Integer> lhashset = new LinkedHashSet<>();
        lhashset.add(1);
        lhashset.add(3);
        lhashset.add(2);
        lhashset.add(4);

        System.out.println(lhashset);

        Set <String> treeSet = new TreeSet<>();
        treeSet.add("AB");
        treeSet.add("AA");
        treeSet.add("AC");

        System.out.println(treeSet);
    }
}


/*

Excellent question! Let's break it down simply and clearly.

---

## 🔷 `Set` Interface in Java – Recap:

All three classes — `HashSet`, `LinkedHashSet`, and `TreeSet` — **implement the `Set` interface**, but **they work differently internally**.

---

## ✅ Do they use Hashing?

| Set Type        | Uses Hashing? | Explanation                                                                                      |
| --------------- | ------------- | ------------------------------------------------------------------------------------------------ |
| `HashSet`       | ✅ Yes         | Stores elements using their **hashCode()** in a **HashMap** internally                           |
| `LinkedHashSet` | ✅ Yes         | Also uses **hashing**, but maintains **insertion order** using a **doubly linked list**          |
| `TreeSet`       | ❌ No          | Uses a **Red-Black Tree** (Self-balancing BST) based on **natural ordering** or a **Comparator** |

---

## 🔍 Internal Working Summary:

### 1️⃣ `HashSet`

* Backed by a **HashMap**.
* Uses `hashCode()` and `equals()` to store and compare elements.
* No order guarantee.

```java
Set<String> hs = new HashSet<>();
hs.add("Banana");
hs.add("Apple");
```

---

### 2️⃣ `LinkedHashSet`

* Backed by a **LinkedHashMap**.
* Uses **hashing** + maintains **insertion order**.
* Slightly slower than `HashSet` (due to linked list overhead).

```java
Set<String> lhs = new LinkedHashSet<>();
lhs.add("Banana");
lhs.add("Apple");  // Order will be preserved
```

---

### 3️⃣ `TreeSet`

* **No hashing.**
* Backed by a **TreeMap** (a Red-Black Tree).
* Elements are **sorted** (natural or custom Comparator).
* Requires elements to be **Comparable** or provided with a **Comparator**.

```java
Set<String> ts = new TreeSet<>();
ts.add("Banana");
ts.add("Apple");  // Sorted output: Apple, Banana
```

---

## ✅ Final Summary Table

| Set Type        | Uses Hashing? | Maintains Order?  | Sorted? | Backed By       |
| --------------- | ------------- | ----------------- | ------- | --------------- |
| `HashSet`       | ✅ Yes         | ❌ No order        | ❌ No    | `HashMap`       |
| `LinkedHashSet` | ✅ Yes         | ✅ Insertion order | ❌ No    | `LinkedHashMap` |
| `TreeSet`       | ❌ No          | ✅ Sorted order    | ✅ Yes   | `TreeMap`       |

---

Let me know if you want a **PDF chart**, code comparisons, or an internal diagram for how these are stored in memory!





 * Great question! Let's break it down clearly:

---

## ✅ Code Recap:

```java
Set<String> treeSet = new TreeSet<>();
treeSet.add("AB");
treeSet.add("CD");
treeSet.add("EF");

System.out.println(treeSet);  // Output: [AB, CD, EF]
```

---

## 🔍 How did `TreeSet` sort the elements?

### ✅ Internally, `TreeSet` uses a **Red-Black Tree** (a type of self-balancing binary search tree) to store elements in **sorted order**.

---

## 🧠 Sorting Logic:

When you do:

```java
treeSet.add("AB");
treeSet.add("CD");
treeSet.add("EF");
```

Java checks how to compare each element using:

### ➤ `compareTo()` method of `String` class

Because `String` implements the **`Comparable<String>`** interface, and it defines:

```java
public int compareTo(String other)
```

---

### 🔡 So `TreeSet` sorts the strings in **natural lexicographical (dictionary) order**:

```text
"AB" < "CD" < "EF"
```

Why?

* Java compares characters one by one using their **Unicode values**.

---

## 🧪 Example:

```java
System.out.println("AB".compareTo("CD")); // Negative → AB < CD
System.out.println("EF".compareTo("CD")); // Positive → EF > CD
```

So:

* `"AB"` is placed first
* `"CD"` next
* `"EF"` last

---

## ✅ What if you want **custom sorting**?

You can use a **custom comparator**:

```java
Set<String> treeSet = new TreeSet<>((a, b) -> b.compareTo(a)); // reverse order
```

---

## 📌 Summary:

| Property         | Value                        |
| ---------------- | ---------------------------- |
| Data structure   | Red-Black Tree               |
| Sorting based on | Natural order (`Comparable`) |
| For `String`     | Uses `compareTo()` method    |
| Output           | Always sorted                |

---

Let me know if you want a demo where we sort custom objects in a TreeSet or a visual Red-Black tree diagram!

 */