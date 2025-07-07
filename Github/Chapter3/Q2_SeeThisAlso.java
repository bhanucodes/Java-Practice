

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Prove that Hash Set is unordered & Linked Hash Set is ordered.
 */

public class Q2_SeeThisAlso {
    public static void main(String[] args) {
        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add(10);
        lhs.add(30);
        lhs.add(5);
        lhs.add(89);
        lhs.add(1);

        HashSet hs = new HashSet();
        hs.add(10);
        hs.add(30);
        hs.add(5);
        hs.add(89);
        hs.add(1);

        ordered(lhs);
        unordered(hs);
    }

    public static LinkedHashSet ordered(LinkedHashSet lhs){
        System.out.println("printing linkedHashSet");
        for(Object i : lhs){
            System.out.println(i);
        }
        return lhs;
    }

    public static HashSet unordered(HashSet hs){
        System.out.println("printing HashSet");
        for(Object i : hs){
            System.out.println(i);
        }
        return hs;
    }
}

// See the concepts below!!

/*
 * Excellent observation again! You're absolutely right to question this — **returning the `LinkedHashSet` from the method is unnecessary** in this context, and you’re spot on: it’s likely only written that way for **learning or demonstration purposes**.

Let me break it down for you in the simplest way possible:

---

## 🔍 The method:

```java
public static LinkedHashSet ordered(LinkedHashSet lhs) {
    System.out.println("printing linkedHashSet");
    for(Object i : lhs) {
        System.out.println(i);
    }
    return lhs;
}
```

### ✅ What it's doing:

* It takes a `LinkedHashSet` called `lhs` as a **parameter**.
* It prints each element in the set.
* Then it returns the same `LinkedHashSet` back.

---

## ❓ Your doubt:

> “Why are we returning the `LinkedHashSet` when we’re already printing the elements?”

---

### ✅ Answer: You're 100% correct — **returning is not needed** here.

### Here's why:

* The method is just **printing**, not modifying anything.
* Returning `lhs` doesn't serve any purpose unless you're going to **use that return value** somewhere.

---

### 🔸 In your code:

```java
ordered(lhs);
```

* You are **not storing or using** the return value.
* So this part:

  ```java
  return lhs;
  ```

  is **doing nothing** useful.

---

## 🔧 Correct, clean version:

If you're only printing, the best way is:

```java
public static void ordered(LinkedHashSet lhs) {
    System.out.println("Printing LinkedHashSet:");
    for (Object i : lhs) {
        System.out.println(i);
    }
}
```

* Now the method has return type `void`, because it **does not return anything**.
* Cleaner and clearer for learning and real use.

---

### ✅ Final Summary:

| Concept                              | Status                                                 |
| ------------------------------------ | ------------------------------------------------------ |
| Passing `LinkedHashSet` as parameter | ✅ Necessary (we need data to print)                    |
| Returning the same `LinkedHashSet`   | ❌ Not needed here (unless we want to reuse it outside) |
| Using `void` instead of return       | ✅ Cleaner, better in this case                         |

---

### 💡 Tip:

Only return a collection from a method when:

* You’re modifying it
* You’re building it inside the method
* Or you need it later in the program

---

 */

 /*
  * Great! Let's break down this method **line-by-line**, step-by-step, and explain *why* `LinkedHashSet` is used in the function definition and parameter.

---

### ✅ Function in Focus:

```java
public static LinkedHashSet ordered(LinkedHashSet lhs){
    System.out.println("printing linkedHashSet");
    for(Object i : lhs){
        System.out.println(i);
    }
    return lhs;
}
```

---

### 🔍 Let's understand each part:

#### 🔸 `public static LinkedHashSet ordered(...)`

* This is the **method signature**.
* It says:
  👉 “This method is **public** (can be accessed from anywhere), **static** (can be called without creating an object), and it **returns** a `LinkedHashSet` object.”
* `LinkedHashSet` is the **return type**, meaning after the method finishes executing, it will return a `LinkedHashSet` object.

---

#### 🔸 `LinkedHashSet lhs` — **Method parameter**

* This means: The method expects an **input argument** of type `LinkedHashSet`.
  You will pass a `LinkedHashSet` into the method when calling it.
* In the `main` method, you did:

  ```java
  ordered(lhs);
  ```

  So you’re passing an object `lhs` of type `LinkedHashSet` to the function.

---

#### 🔸 `for(Object i : lhs)`

* This is a **for-each loop**.
* It loops through every element inside the passed `LinkedHashSet` (`lhs`), one-by-one.
* `Object i` → each element is treated as a general `Object` type (you could use `Integer` if using generics).
* Prints each element in the `LinkedHashSet`.

---

#### 🔸 `return lhs;`

* After printing all elements, the method **returns** the same `LinkedHashSet` object that was passed in.

---

### ✅ Why is `LinkedHashSet` used in both function definition and parameter?

* Because you're working specifically with `LinkedHashSet` in your program (which maintains **insertion order**), you want to make sure the function receives and returns a `LinkedHashSet`.
* If you had used `Set` (interface), it would be more generic and could accept any kind of set (`HashSet`, `TreeSet`, etc.).
* But since you're specifically working with `LinkedHashSet` (to prove it maintains order), you explicitly use that class name.

---

### ✨ Summary (In Simple Terms):

* You create a `LinkedHashSet` in `main()`, add elements to it.
* You pass it to `ordered(lhs)`.
* The method accepts it (`LinkedHashSet lhs`), loops through it, prints each element.
* Then it returns the same set back (though you’re not using the return value).

---

### 🔁 Optional Cleaner Version with Generics:

If you want to make this better and type-safe:

```java
public static LinkedHashSet<Integer> ordered(LinkedHashSet<Integer> lhs){
    System.out.println("Printing LinkedHashSet (Ordered):");
    for(Integer i : lhs){
        System.out.println(i);
    }
    return lhs;
}
```

This ensures that only **Integer values** can be added, and avoids treating everything as just `Object`.

---

Would you like me to now explain `unordered()` or `main()` next?


Excellent questions! Let's break this down **super simply** and **step-by-step** so that even if you're new to Java, you'll understand everything from the root level:

---

## 🔹 1. **Why is `Object` used in `for(Object i : lhs)`?**

### 💡 Because:

`lhs` is declared as a **raw** `LinkedHashSet`, like this:

```java
LinkedHashSet lhs = new LinkedHashSet();
```

* There is **no type specified** inside `<>`, so Java doesn't know what kind of elements it contains.
* Java assumes it can be **anything**, so the safest guess is `Object` (which is the **parent of all classes** in Java).

So, when looping:

```java
for (Object i : lhs) {
    System.out.println(i);
}
```

The programmer says: “I don't know the exact type, so treat every element as a general `Object`.”

---

### 🤔 But what's the problem with this?

* You lose **type safety**.
* You might accidentally put `String`, `Integer`, or even `null` into the same collection — and get **runtime errors**.
* You may have to use **type casting** later if you want to use it as an `Integer`.

---

## 🔸 2. What is **Generics** in Java?

### ✅ Simple Definition:

> **Generics** means defining a **specific type** for your collection (like `LinkedHashSet`, `ArrayList`, etc.), so that Java knows exactly **what type of data** it will hold.

---

### 🔁 Without Generics (Raw Type):

```java
LinkedHashSet lhs = new LinkedHashSet(); // raw type
lhs.add(10);
lhs.add("Hello"); // ❌ No error now, but risky
```

Here, Java allows different types — dangerous.

---

### ✅ With Generics:

```java
LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
lhs.add(10);       // ✅ Allowed
lhs.add("Hello");  // ❌ Compile-time error
```

Now Java knows: **“Only integers are allowed in this set.”**
→ This is called **type safety**.

---

### 🔄 Looping With Generics:

If you use generics, your loop becomes cleaner:

```java
for (Integer i : lhs) {
    System.out.println(i);
}
```

No need for casting. Java knows `i` is always an `Integer`.

---

## 🧠 So... What’s the Final Answer?

### ❓ **Why did the original code use `Object`?**

Because the collection was declared like this:

```java
LinkedHashSet lhs = new LinkedHashSet(); // No type given
```

That’s a **raw type**, so each element is assumed to be an `Object`.

---

### ✅ **How to fix it? Use Generics like this:**

```java
LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
for (Integer i : lhs) {
    System.out.println(i);
}
```

Now your code is:

* ✅ Type-safe
* ✅ Clean
* ✅ More professional

---

Let me know if you want a full rewrite of your code with generics applied step-by-step!

  */

  /*
   * Fantastic questions! You're thinking like a real Java developer — **this is the level of curiosity that leads to mastery**. Let's answer everything **step-by-step** and **from the root level**, in a way that connects the dots clearly.

---

## ✅ Question 1:

### Can we create collection objects **directly using classes** like:

```java
LinkedHashSet lhs = new LinkedHashSet();
```

instead of the usual:

```java
Set<Integer> lhs = new LinkedHashSet<>();
```

---

### 🔹 Short Answer:

**Yes, both are allowed.** But the second one (using interface + generics) is **better and recommended**.

---

### 🔍 Deep Explanation:

#### ✅ This is **valid Java**:

```java
LinkedHashSet lhs = new LinkedHashSet();
```

But this is called a **raw type** (introduced before Generics existed — before Java 1.5).
This works, but:

* ❌ It's **not type-safe**
* ❌ Java **won’t stop you** from adding multiple data types
* ❌ You **lose compile-time checking**

---

#### ✅ This is **better and preferred**:

```java
Set<Integer> lhs = new LinkedHashSet<>();
```

Why?

| Concept                 | Benefits                                                                       |
| ----------------------- | ------------------------------------------------------------------------------ |
| `Set` (interface)       | More **flexible** — can switch between `HashSet`, `LinkedHashSet`, etc. easily |
| `<Integer>` (generics)  | **Type-safe** — ensures only integers are added                                |
| `<>` (diamond operator) | Lets compiler **infer type** on the right side (Java 7+)                       |

---

### ✅ Real-World Best Practice:

Use:

```java
Set<String> names = new LinkedHashSet<>();
```

Avoid:

```java
LinkedHashSet names = new LinkedHashSet(); // Raw and unsafe
```

---

## ✅ Question 2:

### Did the concept of **Generics come later**?

### 🔸 Yes. Generics were introduced in:

> **Java 5 (JDK 1.5)** — as part of a major update called **"Tiger"** (2004)

---

### 🔙 Before Generics (Java 1.4 and earlier):

```java
ArrayList list = new ArrayList();
list.add("hello");
list.add(123);  // ✅ No error!
```

But then you'd need to cast:

```java
String name = (String) list.get(0); // Ugly and risky
```

---

### 🔜 After Generics (Java 5 and later):

```java
ArrayList<String> list = new ArrayList<>();
list.add("hello");
list.add(123);  // ❌ Compile-time error!
```

Now casting is gone:

```java
String name = list.get(0); // Clean and safe
```

---

## 🧠 Summary: What Have You Understood Correctly?

| Concept                                            | ✅ You are Right About...                          |
| -------------------------------------------------- | ------------------------------------------------- |
| Interface + Class (e.g., `Set = new HashSet<>();`) | ✅ Best practice for flexibility                   |
| Using Generics                                     | ✅ Makes code type-safe, clean, and avoids casting |
| Creating collection directly                       | ✅ Possible, but not recommended (raw type)        |
| Generics came later in Java                        | ✅ Yes! Introduced in Java 5 (2004 update)         |

---

## 🛠️ Bonus Tip:

Use interfaces for declarations:

```java
List<Integer> list = new ArrayList<>();
Set<String> set = new LinkedHashSet<>();
Map<Integer, String> map = new HashMap<>();
```

So you can switch implementations later without changing other code.

---

Would you like a visual chart or a cheat sheet on **all collection interfaces vs classes** and how to declare them correctly with generics?

   */