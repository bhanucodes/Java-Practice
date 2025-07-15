package CapgeminiTraining.Java.Assignment3;

import java.util.HashMap;
import java.util.Map;

class DateClass {
    private int date;
    private int month;
    private int year;

    public DateClass(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public int getDate() {
        return date;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "DateClass{" +
                "date=" + date +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}

public class Assignment3Q4 {

    public static String getEmployee(HashMap<DateClass, String> dobMap, String employeeName) {
        int day = -1, month = -1, year = -1;

        // 🔍 Step 1: Find the DOB for the given employee name
        for (Map.Entry<DateClass, String> entry : dobMap.entrySet()) {
            if (entry.getValue().equals(employeeName)) {
                day = entry.getKey().getDate();
                month = entry.getKey().getMonth();
                year = entry.getKey().getYear();
                break;
            }
        }

        if (day == -1) {
            return "Employee not found.";
        }

        // ❌ Step 2: Check if another employee has same day/month but different year
        for (Map.Entry<DateClass, String> entry : dobMap.entrySet()) {
            DateClass dob = entry.getKey();
            String name = entry.getValue();

            if (!name.equals(employeeName) &&
                    dob.getDate() == day &&
                    dob.getMonth() == month &&
                    dob.getYear() != year) {
                return "get method fails";
            }
        }

        return employeeName;
    }

    public static void main(String[] args) {
        HashMap<DateClass, String> employeeMap = new HashMap<>();

        employeeMap.put(new DateClass(4, 7, 1995), "Ajay1");
        employeeMap.put(new DateClass(4, 3, 1997), "Ajay2");
        employeeMap.put(new DateClass(4, 7, 1995), "Ajay"); // same as Ajay1
        employeeMap.put(new DateClass(4, 3, 1995), "Ajay3"); // same day/month as Ajay2, diff year

        System.out.println("Result for Ajay2: " + getEmployee(employeeMap, "Ajay2")); // → get method fails
        System.out.println("Result for Ajay3: " + getEmployee(employeeMap, "Ajay3")); // → Ajay3
        System.out.println("Result for Ajay1: " + getEmployee(employeeMap, "Ajay1")); // → Ajay1
    }
}

/*
 * That’s a very smart and important question. Let’s break it down:
 * 
 * ---
 * 
 * ### ✅ **Question: How to know what to do inside `constructor`, `getters`,
 * `setters`, and `toString()` during an exam or interview?**
 * 
 * When an exam question says:
 * 
 * > “Include a constructor, getters, setters, and a toString() method”
 * 
 * It means:
 * 
 * ---
 * 
 * ### 🔹 1. **Constructor**
 * 
 * > A constructor is used to **initialize the object** with values for its
 * fields when you create it.
 * 
 * #### ➤ **What to do:**
 * 
 * Create a constructor that accepts parameters for all private fields and sets
 * them.
 * 
 * #### 💡 How to guess?
 * 
 * Just look at what fields (variables) are present in the class.
 * 
 * #### Example:
 * 
 * ```java
 * class Student {
 * private String name;
 * private int roll;
 * 
 * // Constructor (initialize both fields)
 * public Student(String name, int roll) {
 * this.name = name;
 * this.roll = roll;
 * }
 * }
 * ```
 * 
 * ---
 * 
 * ### 🔹 2. **Getters and Setters**
 * 
 * > Getters → to **get** the values of private fields
 * > Setters → to **set**modify values of private fields
 * 
 * #### ➤ **What to do:**
 * 
 * For every private variable, write a `get` and `set` method.
 * 
 * #### 💡 How to guess?
 * 
 * Just look at each private field and write:
 * 
 * `getFieldName()`
 * `setFieldName(value)`
 * 
 * #### Example:
 * 
 * ```java
 * public String getName() {
 * return name;
 * }
 * public void setName(String name) {
 * this.name = name;
 * }
 * ```
 * 
 * ---
 * 
 * ### 🔹 3. **toString() Method**
 * 
 * > It returns a **string representation of the object**, useful when printing
 * or debugging.
 * 
 * #### ➤ **What to do:**
 * 
 * Write a method that returns all field values in a readable string format.
 * 
 * #### 💡 How to guess?
 * 
 * Include all fields in the returned string, clearly labeled.
 * 
 * #### Example:
 * 
 * ```java
 * 
 * @Override
 * public String toString() {
 * return "Student{name='" + name + "', roll=" + roll + "}";
 * }
 * ```
 * 
 * ---
 * 
 * ### ✅ So during an exam:
 * 
 * You **look at the private fields** inside the class and then:
 * 
 * Your constructor takes all those fields as parameters and assigns them.
 * Your getters and setters get/set those fields.
 * Your `toString()` prints all the field values in a readable way.
 * 
 * ---
 * 
 * ### 🔁 Example Summary:
 * 
 * ```java
 * class Employee {
 * private String name;
 * private int age;
 * 
 * // Constructor
 * public Employee(String name, int age) {
 * this.name = name;
 * this.age = age;
 * }
 * 
 * // Getters
 * public String getName() { return name; }
 * public int getAge() { return age; }
 * 
 * // Setters
 * public void setName(String name) { this.name = name; }
 * public void setAge(int age) { this.age = age; }
 * 
 * // toString
 * 
 * @Override
 * public String toString() {
 * return "Employee{name='" + name + "', age=" + age + "}";
 * }
 * }
 * ```
 * 
 * ---
 * 
 * Would you like a trick to remember and write them super-fast in exams?
 * 
 */

/*
 * Excellent question! Let's **decode** what `.entrySet()` and `Map.Entry` are,
 * and where they come from.
 * 
 * ---
 * 
 * ## 🧠 What is `.entrySet()` and `Map.Entry`?
 * 
 * When you're working with a `Map` (like `HashMap`), you usually want to **loop
 * through all key-value pairs**.
 * But you can't do that directly with `.get()` or `.keySet()` if you want both
 * **key and value**.
 * 
 * That’s where `.entrySet()` and `Map.Entry` come in.
 * 
 * ---
 * 
 * ### ✅ `.entrySet()` — What It Does
 * 
 * ```java
 * Set<Map.Entry<KeyType, ValueType>> entrySet = map.entrySet();
 * ```
 * 
 * `.entrySet()` is a method of the **`Map` interface**.
 * It returns a **Set** of `Map.Entry` objects.
 * Each `Map.Entry` object holds **one key-value pair** from the map.
 * 
 * ---
 * 
 * ### ✅ `Map.Entry<K, V>` — What It Is
 * 
 * It’s a **nested static interface inside `Map`**:
 * 
 * ```java
 * public interface Map<K, V> {
 * interface Entry<K, V> {
 * K getKey();
 * V getValue();
 * }
 * }
 * ```
 * 
 * So when you write:
 * 
 * ```java
 * for (Map.Entry<DateClass, String> entry : map.entrySet()) {
 * DateClass key = entry.getKey(); // This is the key object
 * String value = entry.getValue(); // This is the corresponding value
 * }
 * ```
 * 
 * You're saying:
 * 
 * > “Loop through each key-value pair in the map, and treat each as an object
 * of `Map.Entry`”.
 * 
 * ---
 * 
 * ## 🔍 Where Does It Come From?
 * 
 * Both `.entrySet()` and `Map.Entry` come from the **Java Collections
 * Framework**:
 * 
 * `Map` is an **interface** in `java.util`
 * `entrySet()` is a method declared in that interface
 * `Map.Entry` is a **static nested interface inside `Map`**
 * 
 * 📦 So you can find it in:
 * 
 * ```java
 * import java.util.Map;
 * import java.util.Set;
 * ```
 * 
 * ---
 * 
 * ## 🧪 Example in Your Code
 * 
 * In your method:
 * 
 * ```java
 * Set set = dob.entrySet();
 * Iterator itr = set.iterator();
 * 
 * while (itr.hasNext()) {
 * Map.Entry m1 = (Map.Entry)itr.next();
 * DateClass key = (DateClass)m1.getKey(); // Custom DOB object
 * String name = (String)m1.getValue(); // Employee name
 * }
 * ```
 * 
 * You:
 * 
 * Get all key-value pairs using `entrySet()`
 * Loop over them with `Iterator`
 * Access each entry's `.getKey()` and `.getValue()` methods
 * 
 * ---
 * 
 * ## ✅ Summary Table
 * 
 * | Concept | What it does |
 * | ------------------ | ---------------------------------------------------- |
 * | `map.entrySet()` | Returns a `Set` of all key-value pairs (`Map.Entry`) |
 * | `Map.Entry<K,V>` | Represents one key-value pair from a map |
 * | `entry.getKey()` | Returns the key of the entry |
 * | `entry.getValue()` | Returns the value of the entry |
 * | Comes from | `java.util.Map` interface (Collections Framework) |
 * 
 * ---
 * 
 * Let me know if you'd like a visual diagram or want to learn `.keySet()` vs
 * `.entrySet()` vs `.values()` — the 3 ways to loop through a map.
 * 
 */

/*
 * You're absolutely right to feel confused — the syntax with generics like
 * `Set<Map.Entry<K, V>>` **does look intimidating at first**. But once we
 * **break it down step by step**, it’ll become very easy for you.
 * 
 * ---
 * 
 * ## 💡 Step-by-Step Guide: Understand `Map.Entry` and `.entrySet()` Syntax
 * 
 * We’ll go slowly and build the concept piece by piece.
 * 
 * ---
 * 
 * ## 🔹1. Quick Recap: What is a `Map`?
 * 
 * ```java
 * Map<Integer, String> map = new HashMap<>();
 * ```
 * 
 * ✅ This means:
 * 
 * Keys are `Integer`
 * Values are `String`
 * 
 * Example values:
 * 
 * | Key | Value |
 * | --- | ------- |
 * | 101 | "Ravi" |
 * | 102 | "Priya" |
 * 
 * ---
 * 
 * ## 🔹2. The Normal Syntax You Already Know
 * 
 * You're comfortable with:
 * 
 * ```java
 * Set<String> set = new HashSet<>();
 * ```
 * 
 * So let's **compare that** with:
 * 
 * ```java
 * Set<Map.Entry<Integer, String>> entries = map.entrySet();
 * ```
 * 
 * At first glance this looks hard, but let’s **break it into 3 parts**:
 * 
 * ---
 * 
 * ## 🔸PART 1: `Set<T>` — A Set of Something
 * 
 * ```java
 * Set<Map.Entry<Integer, String>>
 * ```
 * 
 * This means:
 * 
 * > A **Set** that contains objects of type `Map.Entry<Integer, String>`
 * > (Each object represents **one key-value pair** from the map.)
 * 
 * Like how:
 * 
 * ```java
 * Set<String> s = ...
 * ```
 * 
 * ...is a set of strings,
 * 
 * This is:
 * 
 * ```java
 * Set<Map.Entry<K, V>> s = ...
 * ```
 * 
 * ...a set of key-value pairs.
 * 
 * ---
 * 
 * ## 🔸PART 2: `map.entrySet()` — Get All Key-Value Pairs
 * 
 * ```java
 * map.entrySet()
 * ```
 * 
 * ✅ This is a method of `Map`, which returns a `Set<Map.Entry<K, V>>`
 * 
 * So when you do:
 * 
 * ```java
 * Set<Map.Entry<Integer, String>> entries = map.entrySet();
 * ```
 * 
 * You're saying:
 * 
 * >
 * "Get all the key-value pairs from the map and store them as a Set of Entry objects."
 * 
 * ---
 * 
 * ## 🔸PART 3: `Map.Entry<K, V>` is Just a Pair
 * 
 * ```java
 * Map.Entry<Integer, String> entry
 * ```
 * 
 * This is a **single object** that holds:
 * 
 * One `Integer` key
 * One `String` value
 * 
 * It’s **not a method** — it’s a **type**, just like how `String name` means
 * “name is a string”.
 * 
 * So:
 * 
 * ```java
 * Map.Entry<Integer, String> entry
 * ```
 * 
 * Means:
 * 
 * > “`entry` is a key-value pair from the map.”
 * 
 * ---
 * 
 * ## 🔄 Putting it Together in a Loop
 * 
 * ```java
 * for (Map.Entry<Integer, String> entry : map.entrySet()) {
 * Integer key = entry.getKey(); // example: 101
 * String value = entry.getValue(); // example: "Ravi"
 * }
 * ```
 * 
 * Let’s break it:
 * 
 * `map.entrySet()` = list of all key-value pairs
 * `Map.Entry<Integer, String> entry` = one key-value pair
 * `entry.getKey()` = get the key
 * `entry.getValue()` = get the value
 * 
 * ---
 * 
 * ## 📦 Full Example with Comments
 * 
 * ```java
 * import java.util.*;
 * 
 * public class Example {
 * public static void main(String[] args) {
 * // Step 1: Create a map
 * Map<Integer, String> map = new HashMap<>();
 * map.put(101, "Ravi");
 * map.put(102, "Priya");
 * 
 * // Step 2: Loop over key-value pairs
 * for (Map.Entry<Integer, String> entry : map.entrySet()) {
 * // Step 3: Get key and value
 * Integer key = entry.getKey(); // Example: 101
 * String value = entry.getValue(); // Example: "Ravi"
 * 
 * // Step 4: Print them
 * System.out.println(key + " => " + value);
 * }
 * }
 * }
 * ```
 * 
 * ---
 * 
 * ## ✅ Summary of Generalized Syntax
 * 
 * | Code Part | Meaning |
 * | ----------------------- | ---------------------------------------------- |
 * | `Map<K, V>` | A map of key-value pairs |
 * | `map.entrySet()` | Returns all entries (key-value pairs) as a Set |
 * | `Set<Map.Entry<K, V>>` | A Set of all key-value pairs |
 * | `Map.Entry<K, V> entry` | One key-value pair object |
 * | `entry.getKey()` | Gets the key |
 * | `entry.getValue()` | Gets the value |
 * 
 * ---
 * 
 * ## 🔁 If This Helps:
 * 
 * Here’s a **generalized version** you can apply to **any map**:
 * 
 * ```java
 * Map<K, V> map = new HashMap<>();
 * 
 * for (Map.Entry<K, V> entry : map.entrySet()) {
 * K key = entry.getKey();
 * V value = entry.getValue();
 * }
 * ```
 * 
 * Replace `K` and `V` with your actual types:
 * 
 * For `Map<Integer, String>` → `K = Integer`, `V = String`
 * For `Map<String, Double>` → `K = String`, `V = Double`
 * 
 * ---
 * 
 * Would you like a **real-world visual image** or **analogy chart** for better
 * memory? I can also show a version using `.keySet()` or `.values()` if that's
 * easier for you.
 * 
 */

/*
 * Yes! You got it **almost 100% correct** — just a small refinement, and then
 * your understanding will be **perfect**. Let's clarify your sentence and
 * confirm your doubt:
 * 
 * ---
 * 
 * ## ✅ What This Line Does:
 * 
 * ```java
 * Set<Map.Entry<Integer, String>> entries = map.entrySet();
 * ```
 * 
 * ### 💡 Meaning:
 * 
 * 1. `map.entrySet()`
 * ➤ This method **returns all key-value pairs** from the `map`
 * ➤ These pairs are in the form of `Map.Entry<K, V>` objects
 * ➤ All those entries are stored in a **`Set`**
 * 
 * 2. `Set<Map.Entry<Integer, String>> entries`
 * ➤ You are declaring a variable named `entries`
 * ➤ It will hold a **Set of Map.Entry\<Integer, String>** objects
 * ➤ Each `Map.Entry` represents **one key-value pair** from the map
 * 
 * ---
 * 
 * ### ✅ Final Meaning:
 * 
 * > **Yes**, you are creating a Set called `entries` that will **contain all
 * the key-value pairs** from the map, where each pair is represented as an
 * object of `Map.Entry<Integer, String>`.
 * 
 * ### 🔁 In simple words:
 * 
 * > All the key-value pairs from the map will go **inside this Set** — so yes,
 * exactly as you said!
 * 
 * ---
 * 
 * ### 🔍 Real Example:
 * 
 * ```java
 * Map<Integer, String> map = new HashMap<>();
 * map.put(1, "Apple");
 * map.put(2, "Banana");
 * 
 * Set<Map.Entry<Integer, String>> entries = map.entrySet();
 * ```
 * 
 * Now the `entries` set contains:
 * 
 * ```
 * [
 * Map.Entry(1, "Apple"),
 * Map.Entry(2, "Banana")
 * ]
 * ```
 * 
 * Each item is an object with a key and a value.
 * 
 * ---
 * 
 * ## 🧠 Important Note
 * 
 * The **Set does not make copies** — it's a **view** of the map.
 * If you change a value using the entry object, it reflects in the map too!
 * 
 * ---
 * 
 * Would you like a **visual diagram** for this? Or I can show how this compares
 * with `.keySet()` and `.values()` too.
 * 
 */

/*
 * ✅ **Yes, exactly!**
 * 
 * If you want to **create a Set of all key-value pairs from a `Map`**, the
 * **standard and correct syntax** is:
 * 
 * ```java
 * Set<Map.Entry<KeyType, ValueType>> setName = map.entrySet();
 * ```
 * 
 * ---
 * 
 * ### 🔹 General Syntax:
 * 
 * ```java
 * Set<Map.Entry<K, V>> set = map.entrySet();
 * ```
 * 
 * Where:
 * 
 * | Part | Meaning |
 * | ----------------- | --------------------------------------------------- |
 * | `Set<...>` | You are creating a Set (collection of unique items) |
 * | `Map.Entry<K, V>` | Each item in the Set is a key-value pair |
 * | `map.entrySet()` | Gets all key-value pairs from the map |
 * 
 * ---
 * 
 * ### 🔹 Example 1 – Integer to String Map:
 * 
 * ```java
 * Map<Integer, String> map = new HashMap<>();
 * map.put(1, "Apple");
 * map.put(2, "Banana");
 * 
 * Set<Map.Entry<Integer, String>> entries = map.entrySet();
 * ```
 * 
 * Now `entries` contains:
 * 
 * ```
 * [
 * Entry(1, "Apple"),
 * Entry(2, "Banana")
 * ]
 * ```
 * 
 * ---
 * 
 * ### 🔹 Example 2 – String to Double Map:
 * 
 * ```java
 * Map<String, Double> prices = new HashMap<>();
 * prices.put("Pen", 10.5);
 * prices.put("Notebook", 45.0);
 * 
 * Set<Map.Entry<String, Double>> productEntries = prices.entrySet();
 * ```
 * 
 * ---
 * 
 * ### 📌 So YES:
 * 
 * Whenever you want to create a Set that stores **key-value pairs from a Map**,
 * this is the **correct syntax to follow**:
 * 
 * ```java
 * Set<Map.Entry<K, V>> mySet = myMap.entrySet();
 * ```
 * 
 * No shortcut — this is the clean and standard way in Java.
 * 
 * ---
 * 
 * Let me know if you want to create your **own custom Set of Map.Entry**
 * without a Map (e.g. manually), or if you'd like to understand how this
 * behaves under the hood!
 * 
 */

/*
 * Great question! 🧠
 * You're asking:
 * 
 * > “We did this: `Map → Set<Map.Entry<K, V>>` using `.entrySet()` — but can we
 * do the **opposite** (i.e., create a Map from a Set of `Map.Entry<K, V>`)?”
 * 
 * ✅ **Yes, we can do the reverse** — that is, we can go from a
 * `Set<Map.Entry<K, V>>` back to a `Map<K, V>`.
 * Let’s understand how.
 * 
 * ---
 * 
 * ## 🔁 Vice Versa: Set of `Map.Entry<K, V>` → Map\<K, V>
 * 
 * Let’s say you already have a Set of key-value pairs:
 * 
 * ```java
 * Set<Map.Entry<Integer, String>> entries = ...; // Assume it’s already filled
 * ```
 * 
 * You can loop through this `Set` and **put the entries back into a Map**:
 * 
 * ---
 * 
 * ### ✅ Step-by-step Example
 * 
 * ```java
 * Map<Integer, String> newMap = new HashMap<>();
 * 
 * for (Map.Entry<Integer, String> entry : entries) {
 * Integer key = entry.getKey();
 * String value = entry.getValue();
 * newMap.put(key, value);
 * }
 * ```
 * 
 * Now, `newMap` will contain all the key-value pairs from the `entries` set.
 * 
 * ---
 * 
 * ### 📦 Complete Working Code
 * 
 * ```java
 * import java.util.*;
 * 
 * public class ReverseEntrySet {
 * public static void main(String[] args) {
 * // Step 1: Create a map
 * Map<Integer, String> originalMap = new HashMap<>();
 * originalMap.put(1, "Apple");
 * originalMap.put(2, "Banana");
 * 
 * // Step 2: Convert map to Set of entries
 * Set<Map.Entry<Integer, String>> entries = originalMap.entrySet();
 * 
 * // Step 3: Convert entries back to a new map
 * Map<Integer, String> newMap = new HashMap<>();
 * 
 * for (Map.Entry<Integer, String> entry : entries) {
 * newMap.put(entry.getKey(), entry.getValue());
 * }
 * 
 * // Step 4: Print new map
 * System.out.println("New Map: " + newMap);
 * }
 * }
 * ```
 * 
 * 🖨️ **Output:**
 * 
 * ```
 * New Map: {1=Apple, 2=Banana}
 * ```
 * 
 * ---
 * 
 * ## ✅ Summary Table
 * 
 * | From | To | How |
 * | ---------------------- | ---------------------- |
 * ------------------------------------------------------------ |
 * | `Map<K, V>` | `Set<Map.Entry<K, V>>` | Use `map.entrySet()` |
 * | `Set<Map.Entry<K, V>>` | `Map<K, V>` | Use `newMap.put(entry.getKey(),
 * entry.getValue())` in a loop |
 * 
 * ---
 * 
 * ## 🚀 Bonus: Can You Do This Without Loop?
 * 
 * There’s **no built-in method** like `Map.ofEntries(...)` that takes a
 * `Set<Entry<K, V>>` directly in Java — so **looping is the standard and
 * cleanest way**.
 * 
 * ---
 * 
 * Let me know if you’d like to see how to **manually create a `Set<Map.Entry<K,
 * V>>` without a map**, or how to **clone** maps using `entrySet()`!
 * 
 */

/*
 * ✅ Yes! You're absolutely right.
 * 
 * Looping over a `Set<Map.Entry<K, V>>` and putting each key-value pair into
 * another map is **one of the valid ways to copy data** from one `Map` to
 * another.
 * 
 * ---
 * 
 * ## 🔁 Ways to Add Data from One Map to Another in Java
 * 
 * There are actually **3 standard ways** to do this:
 * 
 * ---
 * 
 * ### ✅ **1. Using a `for-each` loop (like we just did)**
 * 
 * ```java
 * Map<K, V> newMap = new HashMap<>();
 * 
 * for (Map.Entry<K, V> entry : originalMap.entrySet()) {
 * newMap.put(entry.getKey(), entry.getValue());
 * }
 * ```
 * 
 * This is clear, step-by-step, and gives you full control.
 * You can even apply filters here (like only copy certain keys).
 * 
 * ---
 * 
 * ### ✅ **2. Using `putAll()` method — easiest and fastest way**
 * 
 * ```java
 * Map<K, V> newMap = new HashMap<>();
 * newMap.putAll(originalMap);
 * ```
 * 
 * This copies **all key-value pairs** from `originalMap` into `newMap`.
 * Internally, it does the same thing as the loop, just cleaner.
 * 
 * ---
 * 
 * ### ✅ **3. Using Java 8+ Streams (more advanced)**
 * 
 * ```java
 * Map<K, V> newMap = originalMap.entrySet()
 * .stream()
 * .collect(Collectors.toMap(
 * Map.Entry::getKey,
 * Map.Entry::getValue
 * ));
 * ```
 * 
 * Useful when you want to **filter** or **transform** entries during copying.
 * Needs `import java.util.stream.*;`
 * 
 * ---
 * 
 * ## 🧠 So, to answer your question:
 * 
 * > **Yes**, looping through `entrySet()` and adding entries with `put()` is
 * one way to copy data from one map to another.
 * > But if you want to do it quickly and directly, `putAll()` is the simplest
 * and most efficient way.
 * 
 * ---
 * 
 * ## 🚀 BONUS — Example with All 3 Methods:
 * 
 * ```java
 * Map<Integer, String> originalMap = new HashMap<>();
 * originalMap.put(1, "Apple");
 * originalMap.put(2, "Banana");
 * 
 * // 1. Using loop
 * Map<Integer, String> map1 = new HashMap<>();
 * for (Map.Entry<Integer, String> entry : originalMap.entrySet()) {
 * map1.put(entry.getKey(), entry.getValue());
 * }
 * 
 * // 2. Using putAll()
 * Map<Integer, String> map2 = new HashMap<>();
 * map2.putAll(originalMap);
 * 
 * // 3. Using Streams
 * Map<Integer, String> map3 = originalMap.entrySet()
 * .stream()
 * .collect(Collectors.toMap(
 * Map.Entry::getKey,
 * Map.Entry::getValue
 * ));
 * ```
 * 
 * Let me know if you want to **copy only selected keys**, or **merge two maps
 * with duplicate keys** — I can show that too!
 * 
 */