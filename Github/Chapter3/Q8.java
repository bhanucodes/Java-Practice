import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Q8 {
    public static void failSafe(Map<String, String> cityCode){

        Iterator<Map.Entry<String, String>> itr = cityCode.entrySet().iterator();

        while(itr.hasNext()){
            Map.Entry<String, String> entry = itr.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());

            cityCode.put("Uttrakhand", "India");  // ✅ Safe to modify
        }
    }

    public static void main(String[] args) {
        Map<String, String> cityCode = new ConcurrentHashMap<>();  // ✅ Thread-safe map
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("New York", "USA");

        failSafe(cityCode);   // Call the method → no exception
    }
}

/*
Excellent questions! You're asking about the **difference between raw types vs generic types** in Java — this is key for writing type-safe, modern Java code.

Let’s break it down in detail:

---

## ✅ **1. Declaring the Iterator**

### 🔴 Old-style (Raw Type – Not Type-Safe):

```java
Iterator itr = cityCode.entrySet().iterator();  // ❌ Raw Iterator
```

* This does **not specify** what kind of data the iterator is returning.
* You will need to **type-cast** every item manually.
* Not recommended in modern Java (unsafe, prone to `ClassCastException`).

---

### ✅ Modern, Type-Safe Style (Using Generics):

```java
Iterator<Map.Entry<String, String>> itr = cityCode.entrySet().iterator();  // ✅ Generic Iterator
```

* This explicitly says: “I’m iterating over a set of `Map.Entry<String, String>` objects.”
* No need for casting later.
* It helps the compiler catch mistakes **at compile-time**, not runtime.

---

## ✅ **2. Iterating and Accessing Entries**

### 🔴 Old Way (Using Raw Types + Manual Casting):

```java
Map.Entry m1 = (Map.Entry)itr.next();  // ❌ Raw entry + explicit cast
System.out.println(m1.getKey() + " " + m1.getValue());
```

* You don’t specify `<String, String>`, so compiler can’t verify types.
* You must cast explicitly.
* If map stores other types (say Integer), this can cause **runtime exception**.

---

### ✅ New Way (Generics – Type-Safe):

```java
Map.Entry<String, String> entry = itr.next();  // ✅ No cast needed
System.out.println(entry.getKey() + " " + entry.getValue());
```

* Compiler knows that `entry` contains a `String` key and a `String` value.
* Cleaner, safer, modern code.
* This is how Java recommends we write code after **Java 5 (when generics were introduced)**.

---

## 🎯 Summary: When to Use What

| Style            | Code                                            | Type-Safe? | Cast Required? | Recommended? |
| ---------------- | ----------------------------------------------- | ---------- | -------------- | ------------ |
| Raw Iterator     | `Iterator itr = ...`                            | ❌ No       | ✅ Yes          | ❌ No         |
| Generic Iterator | `Iterator<Map.Entry<String, String>> itr = ...` | ✅ Yes      | ❌ No           | ✅ Yes        |
| Raw Entry        | `Map.Entry m1 = (Map.Entry)...`                 | ❌ No       | ✅ Yes          | ❌ No         |
| Generic Entry    | `Map.Entry<String, String> entry = ...`         | ✅ Yes      | ❌ No           | ✅ Yes        |

---

## 🔥 Final Best Practice

✅ **Always** use generics in collections and iterators to:

* Avoid casting
* Prevent bugs
* Make your code readable and compiler-friendly

---

Want me to give you:

* 💡 A rewrite of your original code with the best generic style?
* 🧪 A small quiz on raw vs generic to practice?

Let me know!

*/

/*
 * Let’s break down **both versions** of your code:

---

# 🔴 **1. FAIL-FAST CODE (Using HashMap)**

```java
package CapgeminiTraining.Java.Assignment3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Assignment3Q8a {
    public static void failFast(Map<String, String> cityCode){

        Iterator itr = cityCode.entrySet().iterator();  // 1️⃣ Create iterator

        while(itr.hasNext()){                            // 2️⃣ Iterate through map
            Map.Entry m1 = (Map.Entry)itr.next();        // 3️⃣ Get each key-value pair
            System.out.println(m1.getKey()+" "+m1.getValue());

            cityCode.put("Uttrakhand","India");          // 4️⃣ Modify map while iterating ❌
        }
    }

    public static void main(String[] args) {
        Map<String, String> cityCode = new HashMap<>();  // 0️⃣ HashMap is NOT thread-safe
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("New York", "USA");

        failFast(cityCode);   // Call the method → will throw Exception
    }
}
```

---

## ✅ What Happens Step-by-Step?

### 💡 HashMap is **fail-fast**, so modifying it during iteration will throw a `ConcurrentModificationException`.

### Breakdown:

| Step                                       | What Happens                                                                   |
| ------------------------------------------ | ------------------------------------------------------------------------------ |
| ✅ `iterator()` is called                   | The iterator is created at the **start state** of the map.                     |
| ✅ `itr.next()`                             | Retrieves one entry (key-value pair).                                          |
| ❌ `cityCode.put(...)`                      | When you change the map, the structure changes.                                |
| 🚨 On next `itr.hasNext()` or `itr.next()` | JVM sees the structure is modified ⇒ throws `ConcurrentModificationException`. |

---

## ❌ Output (Exception)

```
Delhi India
Exception in thread "main" java.util.ConcurrentModificationException
```

---

# ✅ **2. FAIL-SAFE CODE (Using ConcurrentHashMap)**

```java
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Assignment3Q8b {
    public static void failSafe(Map<String, String> cityCode){

        Iterator<Map.Entry<String, String>> itr = cityCode.entrySet().iterator();

        while(itr.hasNext()){
            Map.Entry<String, String> entry = itr.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());

            cityCode.put("Uttrakhand", "India");  // ✅ Safe to modify
        }
    }

    public static void main(String[] args) {
        Map<String, String> cityCode = new ConcurrentHashMap<>();  // ✅ Thread-safe map
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("New York", "USA");

        failSafe(cityCode);   // Call the method → no exception
    }
}
```

---

## ✅ What Happens Step-by-Step?

| Step                                                                                                                              | What Happens |
| --------------------------------------------------------------------------------------------------------------------------------- | ------------ |
| ✅ `ConcurrentHashMap` allows concurrent read/write.                                                                               |              |
| ✅ While iterating, you modify it ⇒ no exception.                                                                                  |              |
| ✅ You’ll still get a **consistent snapshot** of the map.                                                                          |              |
| ⚠️ Note: The new entry (`Uttrakhand`) **might not** be visible during this iteration, depending on timing and internal structure. |              |

---

## ✅ Output (Safe Execution):

```
Delhi : India
Moscow : Russia
New York : USA
```

☝ It will **not** print `"Uttrakhand"` because the iterator was already made **before** the new entry was inserted.

---

# 📊 Final Comparison: Fail-Fast vs Fail-Safe

| Feature                       | Fail-Fast (`HashMap`)             | Fail-Safe (`ConcurrentHashMap`)             |
| ----------------------------- | --------------------------------- | ------------------------------------------- |
| Can modify during iteration?  | ❌ No                              | ✅ Yes                                       |
| Thread-safe?                  | ❌ No                              | ✅ Yes                                       |
| Throws exception if modified? | ✅ Yes                             | ❌ No                                        |
| Common examples               | `HashMap`, `ArrayList`, `HashSet` | `ConcurrentHashMap`, `CopyOnWriteArrayList` |
| Use-case                      | Single-threaded apps              | Multi-threaded/concurrent apps              |

---

# 🔚 Summary: When to Use What?

* **Use `HashMap`** if:

  * You’re in a **single-threaded** environment.
  * You don’t modify during iteration.

* **Use `ConcurrentHashMap`** if:

  * You’re in a **multi-threaded** or concurrent setup.
  * You need **safe iteration with modification**.

---

 */