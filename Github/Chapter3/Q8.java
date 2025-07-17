public class Q8 {
    public static void main(String[] args) {
        
    }
}
 * Here is the **exact question** for your provided Java code, written in a clear and Capgemini M1/A4 exam-friendly format:

---

## ✅ **Question 8a: Fail-Fast Iterator Behavior**

---

### 💡 **Problem Statement:**

Write a Java program to demonstrate the behavior of **fail-fast iterators** in a multithreaded or modification scenario.

You are given a `HashMap` storing city names as keys and their respective countries as values. While iterating over the map using an iterator, try modifying the map by adding a new key-value pair. Observe and explain the behavior.

---

### ✅ **Requirements:**

1. Create a method named `failFast(Map<String, String> cityCode)`:

   * It should iterate through the given map using an iterator.
   * During iteration, insert a new entry into the map (e.g., `"Uttrakhand" -> "India"`).
   * Print each key-value pair before the modification occurs.

2. In the `main()` method:

   * Initialize a `HashMap<String, String>` with at least 3 key-value pairs.
   * Call the `failFast()` method and observe the behavior.

---

### 🔍 **Expected Output:**

The program should throw a `ConcurrentModificationException` at runtime because `HashMap` uses a **fail-fast iterator**, which does not allow structural modification of the map while iterating.

---

### 📌 **Concept to Demonstrate:**

* **Fail-fast iterators** (e.g., in `ArrayList`, `HashSet`, `HashMap`) immediately throw a `ConcurrentModificationException` if the structure of the collection is modified **after the creation of the iterator**, except through the iterator's own `remove()` method.
* This behavior ensures consistency and avoids unpredictable results in single-threaded or multithreaded environments.

---

Let me know if you'd also like the **fail-safe version** using `ConcurrentHashMap`.

