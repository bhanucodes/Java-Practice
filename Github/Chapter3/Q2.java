import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q2 {
    public static void main(String[] args) {
        // in Hashset : unique element, uses Hashing
        // in Linked hashset: insertion order mainitained, unique elements, uses
        // Linkedlist + Hashing


        // This is the better code!
        Set<Integer> s = new HashSet<>();
        s.add(10);
        s.add(30);
        s.add(5);
        s.add(89);
        s.add(1);

        System.out.println(s);

        Set<Integer> ls = new LinkedHashSet<>();
        ls.add(10);
        ls.add(30);
        ls.add(5);
        ls.add(89);
        ls.add(1);

        System.out.println(ls);
    }

    
}


































// Core Concepts of Generics:: Also in HTML file and Bibcit
/*
 * Absolutely! Let’s **start from the very root level** and fully understand **Java Generics** — what they are, why they exist, how they work, and how to master them step-by-step.

---

## 🧠 What Are Generics in Java?

**Generics = Parameterized Types**

> Generics allow you to write code that can handle **different data types** while ensuring **type safety** at **compile time**.

---

### 📦 Imagine this:

You want a **box** (class) that can store anything — an `Integer`, a `String`, a `Student`, etc.
Without generics, you’d need to create a new class for every type OR use `Object` (which is risky).

**Generics solve this by allowing:**

```java
Box<Integer> intBox = new Box<>();
Box<String> strBox = new Box<>();
```

Now `Box` is flexible, reusable, and type-safe.

---

## 🔧 Why Were Generics Introduced?

Before Java 5 (2004), collections were **not type-safe**:

```java
List list = new ArrayList();
list.add("hello");
list.add(123); // allowed

String s = (String) list.get(1); // ❌ Runtime error: ClassCastException
```

### ✅ Generics fix this:

```java
List<String> list = new ArrayList<>();
list.add("hello");
// list.add(123); // ❌ Compile-time error
```

Now Java **knows** the list contains only `String`, and warns you during compilation.

---

## 📘 Syntax of Generics:

```java
ClassName<Type> variableName = new ClassName<>();
```

* `<>` is called the **diamond operator**
* `Type` is a **type parameter**, like `Integer`, `String`, `Double`, `Employee`, etc.

---

## 🔹 Core Concepts of Generics (Step-by-Step)

---

### 1️⃣ **Generic Classes**

You can define your own classes with generics:

```java
class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
```

### Usage:

```java
Box<String> b1 = new Box<>();
b1.set("Hello");

Box<Integer> b2 = new Box<>();
b2.set(100);
```

Now `T` is **replaced at compile-time** with `String` or `Integer`.

---

### 2️⃣ **Generic Methods**

```java
public class Util {
    public static <T> void print(T[] arr) {
        for (T val : arr) {
            System.out.println(val);
        }
    }
}
```

Usage:

```java
Integer[] nums = {1, 2, 3};
String[] names = {"Alice", "Bob"};

Util.print(nums);
Util.print(names);
```

Here, `<T>` is **declared before return type**, to tell Java: “T is a generic type for this method.”

---

### 3️⃣ **Generics with Collections**

```java
List<String> list = new ArrayList<>();
list.add("Namaste");
list.add("Generics");
// list.add(10); // ❌ Compile-time error
```

Generics make collection code:

* Type-safe
* Cleaner (no casting)
* Self-documented

---

### 4️⃣ **Bounded Generics**

Sometimes you want a generic type to be restricted to **a specific range of types**.

#### Example:

```java
class DataPrinter<T extends Number> {
    T value;
    void print() {
        System.out.println(value);
    }
}
```

Now:

```java
DataPrinter<Integer> d1 = new DataPrinter<>(); // ✅
DataPrinter<Double> d2 = new DataPrinter<>();  // ✅
// DataPrinter<String> d3 = new DataPrinter<>(); // ❌ Error
```

---

### 5️⃣ **Wildcards: `?`**

Used when you don’t know the exact type.

#### Example:

```java
public void printList(List<?> list) {
    for (Object o : list) {
        System.out.println(o);
    }
}
```

It means: "Accept a list of any type."

There are also:

* `<? extends Type>` → upper bound
* `<? super Type>` → lower bound

We’ll cover wildcard use cases in detail after you’re solid with the basics.

---

### 6️⃣ **Generics in Interfaces**

You can also use generics in interfaces:

```java
interface Printer<T> {
    void print(T data);
}
```

---

## ✅ Benefits of Generics:

| Feature     | Benefit                              |
| ----------- | ------------------------------------ |
| Type Safety | Errors caught at **compile time**    |
| Code Reuse  | Write once, use for any type         |
| No Casting  | No need to manually cast types       |
| Readability | Code is self-documenting and clearer |

---

## 🧪 Next Steps for You to Practice:

1. ✅ Create a generic `Box<T>` class
2. ✅ Create a generic method to print arrays
3. ✅ Create a generic class with bounded type (e.g., `T extends Number`)
4. ✅ Use generics with `ArrayList`, `HashSet`, etc.

---

Would you like me to now walk you through each of these with **real code examples**, one-by-one, in your style of learning (step-by-step, slow and clear)?

 */

 /*
  * 
  **Bilkul bhai!** Tu ne **100% sahi likha hai** — ye hai ek **perfect Generic Class in Java** 👌

Let me now explain **line-by-line**, with proper breakdown, so tujhe clear ho jaye ki kya ho raha hai iske andar:

---

## ✅ Full Code:

```java
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```

---

## 🔍 Explanation:

### 🟢 `class Box<T>`

* `T` is a **type parameter** (can be anything: `Integer`, `String`, `CustomClass`, etc.)
* It makes this class **generic**, meaning it can handle any datatype **safely** and **flexibly**
* Java doesn’t know what `T` is **yet** — it will be decided at **object creation time**

---

### 🔵 `private T value;`

* This is the **data field** (just like `int a`, `String name` etc.)
* But instead of fixed type, it's of type `T` — a **generic placeholder**
* Meaning: this class doesn't care if it's a number, string, etc.

---

### 🟡 `public void set(T value)`

* Sets the value into the box
* The type of `value` must match whatever type is passed when the object is created
* Eg: `Box<Integer>`, then this will only allow `Integer`

---

### 🔴 `public T get()`

* Gets the value from the box
* Again, returns it as the same generic type `T`

---

## 🎯 Example Usage:

```java
public class Main {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println(intBox.get());  // Output: 100

        Box<String> strBox = new Box<>();
        strBox.set("Namaste");
        System.out.println(strBox.get());  // Output: Namaste
    }
}
```

---

## 💡 What’s Happening Internally?

At compile time, Java does this:

```java
// For intBox
class Box_Integer {
    Integer value;
    void set(Integer value) {...}
    Integer get() {...}
}

// For strBox
class Box_String {
    String value;
    void set(String value) {...}
    String get() {...}
}
```

So Java **replaces `T` with the actual type** at compile-time — that’s called **Type Erasure**.

---

## ✅ Final Verdict:

| Concept        | Explanation                                             |
| -------------- | ------------------------------------------------------- |
| `T`            | Generic placeholder type                                |
| `Box<T>`       | Generic class definition                                |
| `set(T value)` | Setter that takes any type depending on object creation |
| `get()`        | Getter that returns that same type                      |
| Type Safety    | No wrong types allowed, no casting needed               |
| Reusability    | Same class works for all data types                     |

---

Would you now like me to show a small example of what happens **if you try to put the wrong data** in the box? (like trying to insert a `String` in a `Box<Integer>`)?

  */
/*
 * Bilkul bhai! Ab main tujhe **Java Generic Methods** ka concept **bilkul basics se**, **default syntax** ke saath samjhaata hoon — step-by-step, desi language mein, ekdam root se.

---

## 📦 Step 1: What is a Generic Method?

> A **Generic Method** is a method that works with **any data type** (Integer, String, Float, etc.)
> **but still gives compile-time type safety**.

So instead of writing:

```java
void printIntegers(Integer[] arr) { ... }
void printStrings(String[] arr) { ... }
```

We write just **one method**:

```java
<T> void print(T[] arr) { ... }
```

That’s called a **Generic Method**.

---

## 🧱 Step 2: Default Syntax of Generic Method

Here’s the full default template syntax:

```java
// ↓ generic declaration
<GenericType> ReturnType methodName(ParameterType) {
    // method body
}
```

For example:

```java
<T> void print(T[] arr) {
    for (T val : arr) {
        System.out.println(val);
    }
}
```

### Breakdown:

| Part      | Meaning                                             |
| --------- | --------------------------------------------------- |
| `<T>`     | Declares that `T` is a generic type for this method |
| `void`    | Method does not return anything                     |
| `print`   | Method name                                         |
| `T[] arr` | Accepts an array of any type `T`                    |

---

## 🔧 Step 3: Example Code with Explanation

```java
public class Util {

    // ✅ Generic Method
    public static <T> void printArray(T[] arr) {
        for (T val : arr) {
            System.out.println(val);
        }
    }

    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"Hello", "World"};
        Double[] dblArr = {2.3, 4.5, 6.7};

        // ✅ Call generic method
        printArray(intArr);  // T becomes Integer
        printArray(strArr);  // T becomes String
        printArray(dblArr);  // T becomes Double
    }
}
```

---

## 🧠 Step 4: Why Use `<T>` Before Return Type?

You **must tell Java**:

> “This method is going to use a generic type `T`.”

So you declare `<T>` before return type:

```java
<T> void printArray(T[] arr)
```

### If you **don’t** write `<T>`:

```java
void printArray(T[] arr)  // ❌ Compilation error: T not known!
```

That’s why:

* Always declare `<T>` before return type.

---

## 📘 Step 5: Generic Method vs Generic Class

| Feature           | Generic Method                                   | Generic Class                  |
| ----------------- | ------------------------------------------------ | ------------------------------ |
| Declared using    | `<T>` before **method return type**              | `<T>` after **class name**     |
| Example           | `<T> void print(T[] arr)`                        | `class Box<T> { ... }`         |
| Scope of `T`      | Inside that **one method only**                  | Throughout the **whole class** |
| Usage flexibility | Can have generic method inside non-generic class | Whole class becomes type-safe  |

---

## 🛠️ Extra: Method with Multiple Type Parameters

```java
public static <K, V> void printKeyValue(K key, V value) {
    System.out.println("Key: " + key + ", Value: " + value);
}
```

---

## ✅ Summary

| Concept        | Explanation                                        |
| -------------- | -------------------------------------------------- |
| Generic Method | A method that works for any type                   |
| Syntax         | `<T> returnType methodName(T param)`               |
| Must use `<T>` | Before return type, to declare the generic type    |
| Benefit        | One method for all types, with compile-time safety |

---

## 🎁 Want a Mini Assignment?

Want me to give you 2 small tasks based on generic methods for practice?
Or should I move to **Wildcard `?` and bounded generics** next?

Tere upar hai — bol bhai.

 */
/*
 * Bhai, **bahut solid question pucha hai tu!** 🔥
Chal — main pehle tera question clear karta hoon about:

---

## ❓ “Can we use generic methods **without array** as parameter?”

### ✅ **YES! Absolutely.**

Generic method kisi bhi **data type** pe kaam kar sakta hai — array ho, variable ho, object ho, list ho — **not just arrays**.

---

### 🧪 Example 1: Single value (not array)

```java
public class Util {
    public static <T> void print(T value) {
        System.out.println("Value: " + value);
    }

    public static void main(String[] args) {
        Util.print(100);              // Integer
        Util.print("Namaste Bhai");   // String
        Util.print(12.56);            // Double
    }
}
```

### Output:

```
Value: 100  
Value: Namaste Bhai  
Value: 12.56
```

> So **array is not mandatory** — `T` can be **any kind of data**.

---

### 🧪 Example 2: Comparing Two Generic Values

```java
public class CompareUtil {
    public static <T> void compare(T a, T b) {
        if (a.equals(b)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }

    public static void main(String[] args) {
        compare(5, 5);              // Integer
        compare("Hi", "Hello");     // String
    }
}
```

---

### ✅ So remember:

> Array sirf ek example hai.
> Generic method can accept **anything**: single value, 2 values, object, etc.

---

## 🔥 Now Let’s Move to: Wildcards `?` & Bounded Generics

---

# 🧩 What is `?` — The Wildcard in Java Generics?

### ❓ Problem:

Generic classes and methods are **type-specific**, like:

```java
List<Integer> li = new ArrayList<>();
List<Number> ln = new ArrayList<>();
```

Now if you try:

```java
ln = li;   // ❌ Compile error!
```

But intuitively you’d think:

> "Integer is a Number, so List<Integer> is a List<Number>"
> But **NO** — Java doesn’t allow that.

---

### ✅ Solution: Use Wildcard `?`

```java
List<?> list = new ArrayList<Integer>();
```

Now you can store **any type of list**:

* `List<Integer>`
* `List<String>`
* `List<Double>`

But: You can only **read** from it — you **can’t add** items (except `null`).

---

## ✳️ Types of Wildcards

### 1️⃣ `?` — Unbounded Wildcard

```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

* Accepts any list
* Only allows **read**, not write

---

### 2️⃣ `<? extends Type>` — Upper Bounded Wildcard

```java
public void printNumbers(List<? extends Number> list) {
    for (Number n : list) {
        System.out.println(n);
    }
}
```

* Accepts `List<Integer>`, `List<Float>`, `List<Double>`, etc.
* **“I accept anything that IS-A Number or subclass.”**

---

### 3️⃣ `<? super Type>` — Lower Bounded Wildcard

```java
public void addIntegers(List<? super Integer> list) {
    list.add(10);  // ✅
    list.add(20);  // ✅
}
```

* Accepts `List<Integer>`, `List<Number>`, `List<Object>`
* **“I accept anything that is a superclass of Integer”**

---

## ✅ Quick Summary Table

| Wildcard             | Meaning                                               |
| -------------------- | ----------------------------------------------------- |
| `<?>`                | Unknown type — read-only                              |
| `<? extends Number>` | Any subtype of `Number` — safe for reading            |
| `<? super Integer>`  | Any supertype of `Integer` — safe for writing Integer |

---

## 🔥 Bonus Visual:

### Think like this:

| Type            | Can Read          | Can Write                  |
| --------------- | ----------------- | -------------------------- |
| `<?>`           | ✅ Yes             | ❌ No                       |
| `<? extends T>` | ✅ Yes (as T)      | ❌ No (not guaranteed safe) |
| `<? super T>`   | ✅ Yes (as Object) | ✅ Yes (as T)               |

---

## 🔚 Want a Real-Life Practice?

Would you like a **3-part mini assignment** to test all wildcard types (`<?>`, `<? extends>`, `<? super>`)?

Or want me to show a real-world example like printing and adding elements to a generic list with wildcards?

Tu decide kar bhai 😎

 */

  // A question came into my mind===================================================================================================================================================
/*
 * 🔥 Excellent! You're now asking the **core foundational question** that proves you're genuinely trying to understand generics — not just memorize syntax.

Let’s explain this **step-by-step with visual imagination + deep reasoning**:

---

## 🧠 Your Question:

> How is it possible that the **same class `Box<T>`** can handle **different datatypes** like `Integer` and `String`?
> Aren’t we creating only one class?
> Then how is it behaving differently in:

```java
Box<Integer> intBox = new Box<>();
Box<String> strBox = new Box<>();
```

---

### ✅ Short Answer:

> Because of **Generics**, Java uses **Type Substitution** at **compile-time**, so it **generates type-safe versions** of the same class for each type you use.

Now let’s understand this **visually and conceptually**.

---

## 📦 Let’s say you define this class:

```java
class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
```

> `T` is just a **placeholder** — Java doesn't know yet what `T` is.
> It will **replace** `T` with whatever type you give it **at the time of object creation**.

---

### 🧪 Case 1:

```java
Box<Integer> intBox = new Box<>();
intBox.set(10);
```

At **compile time**, Java rewrites the class like this (in concept only):

```java
class Box_Integer {
    Integer value;

    void set(Integer value) {
        this.value = value;
    }

    Integer get() {
        return value;
    }
}
```

---

### 🧪 Case 2:

```java
Box<String> strBox = new Box<>();
strBox.set("Namaste");
```

Java internally treats this like:

```java
class Box_String {
    String value;

    void set(String value) {
        this.value = value;
    }

    String get() {
        return value;
    }
}
```

---

### 🎯 Key Insight:

* You write the class **only once** using `T` (a generic type).
* Java creates different **type-specific versions** of the class **behind the scenes** using **compile-time type erasure**.
* So the **same class behaves differently** depending on what type you pass into it.

---

## 💥 Without Generics (Old style):

If we wrote this without generics:

```java
class Box {
    Object value;
    void set(Object value) {
        this.value = value;
    }
    Object get() {
        return value;
    }
}
```

Now we have problems:

* You can accidentally mix types:

  ```java
  box.set("Hello");
  Integer x = (Integer) box.get(); // ❌ Runtime error!
  ```
* You have to manually **cast** the result.

---

## ✅ With Generics:

No casting, no mixing, full safety:

```java
Box<Integer> b = new Box<>();
b.set(10);              // ✅
Integer x = b.get();    // ✅ No casting needed

b.set("Hello");         // ❌ Compile-time error
```

---

## 🔁 So why create multiple `Box<T>` objects?

Because each one is **type-bound** and **type-safe**:

```java
Box<Integer> intBox = new Box<>(); // Only for Integers
Box<String> strBox = new Box<>();  // Only for Strings
```

Each one behaves as if it's a **different class**, even though it's the same class with generics under the hood.

---

### ✅ Summary (in your words):

| Concept                     | Meaning                                                         |
| --------------------------- | --------------------------------------------------------------- |
| `T` in class                | A placeholder for actual datatype                               |
| At compile time             | Java replaces `T` with real type like `Integer`, `String`, etc. |
| Why create multiple objects | Each object is safe for one type — no mixing                    |
| Benefit                     | Reusable, flexible, safe, no casting                            |

---

Would you like me to now write and walk you through **this same Box<T> example** in full Java code with both generic and non-generic versions, to compare and see the difference in action?


Haan bhai! Tu **sahi soch raha hai** — aur main tujhe iska **sahi logic** bhi batata hoon, ekdum seedhe aur desi style mein. Chal step-by-step samajhte hain:

---

## 🔥 Pehle situation kya thi (Without Generics)?

Tu kuch aise kar raha tha:

```java
Box box = new Box();
box.set(10);
System.out.println(box.get());  // 10

box.set("Namaste");
System.out.println(box.get());  // Namaste
```

### ✅ Faayda:

* Ek hi object se **sab kuch daal diya** — `Integer`, `String`, kuch bhi.
* Time bacha, memory bhi bachi.

### ❌ Problem kya thi?

* Java ko pata hi nahi hota us box ke andar **exactly kya hai**.
* Jab tu `get()` karega, tu **type cast** karega:

  ```java
  String s = (String) box.get();  // what if it’s an Integer? 💥 error!
  ```
* **Runtime crash** ho sakta hai — ClassCastException.

---

## 🔄 Now — With Generics:

```java
Box<Integer> intBox = new Box<>();
intBox.set(10);
// intBox.set("Hello"); ❌ error — compile-time!

Box<String> strBox = new Box<>();
strBox.set("Namaste");
```

### ❓Tu bolega: “Abe 2 object ban gaye! Pehle to ek se kaam chal raha tha...”

---

### ✅ Answer:

**Bhai, 2 object ban rahe hain kyunki:**

* Tu ab **type-safe** coding kar raha hai.
* Java ko har object ka **pura type pata hai** — so koi bhi galat value daali to **compile-time error** dega.
* Ye choti si price tu de raha hai — but mil raha hai:

  * ✅ No runtime crash
  * ✅ Clean & reusable code
  * ✅ Auto suggestions in IDE
  * ✅ No casting needed

---

## 📦 Real-Life Example Samajh:

* Pehle tu ek **jhola (Box)** leke sab kuch daal raha tha — aalu, tamatar, mobile phone 😆
* Ab tu keh raha:

  * "Is jhole mein sirf aalu (Integer) jayega" → `Box<Integer>`
  * "Is dusre mein sirf books (String)" → `Box<String>`

> Ab safai hai, management hai, aur **galti hone ka chance zero hai**.

---

## 🤖 Compiler kya kar raha hai peeche:

Jab tu likhta hai:

```java
Box<Integer> intBox = new Box<>();
```

Compiler uss `Box<T>` ko convert kar raha hai:

```java
class Box_Integer {
   Integer value;
   void set(Integer value) { this.value = value; }
   Integer get() { return value; }
}
```

Toh us `Box<T>` class se **multiple versions** ban ja rahe hain — alag-alag types ke liye.

---

## 🔥 Verdict:

| Without Generics   | With Generics            |
| ------------------ | ------------------------ |
| 1 object for all   | Alag object per datatype |
| Runtime errors     | ✅ Compile-time safety    |
| Manual casting     | ✅ No casting needed      |
| Flexible but risky | ✅ Safe & predictable     |

---

## 🧪 Toh fayda kya mila?

Tu ab professional level ka code likh raha hai — company-level.
Small price (extra object) ke liye tu le raha hai:

* Strong safety
* Better debugging
* Better design
* Reusability

---

Bol bhai — ab aur gehra chahiye kya example ke saath? Ya main ek chhota Java demo likh ke dono version (with aur without generics) dikhaun side-by-side?


Bhai tu **bilkul sahi jagah pe doubt leke aaya hai**. Ab main tujhe `get()` aur `set()` ka poora **"lafda" clear karta hoon**, step-by-step, in your language and with complete clarity.

---

## 🧠 Pehle Simple Sawal:

> Ye `get()` aur `set()` ka logic kahan se aaya?
> Kya har class me ye dalna zaroori hai?
> Aur random class me bhi `get`/`set` daalte hain kya?

---

### ✅ Simple Answer:

`get()` aur `set()` methods banaye jaate hain so that:

* **Object ke andar ke data ko access (get)** kar sakein
* **Object ke andar ke data ko change (set)** kar sakein
* But... in a **controlled and secure** way

---

## 🎁 Real-Life Example:

Tu ek class banata hai `Box`:

```java
class Box {
    Object value;

    void set(Object value) {
        this.value = value;
    }

    Object get() {
        return value;
    }
}
```

Yeh class **ek variable "value"** rakhta hai — jisme kuch bhi daal sakte hain.
Par variable `value` ko **direct access** nahi diya, instead tu bana raha hai:

* `set()` → daalne ke liye
* `get()` → nikaalne ke liye

---

## 🔐 But Why Not Direct Access?

Tu ye bhi kar sakta hai theoretically:

```java
box.value = 100;               // Direct access
System.out.println(box.value); // Direct print
```

**Phir `get()` / `set()` ka kya zarurat?**

### ❌ Lekin dikkat hoti hai:

* Tumhara `value` field **public** hona padega → security khatam 😬
* Koi bhi kahin se bhi usko **change kar sakta hai**
* Kabhi validation nahi kar paoge (e.g. value negative na ho)

---

## ✅ Isliye Standard Practice:

### Always keep your fields **private**, and access them with:

* `getFieldName()` — to **read** value
* `setFieldName()` — to **write/update** value

---

### 🔄 Full Formally:

```java
class Student {
    private int marks;

    public void setMarks(int m) {
        if (m >= 0) {
            marks = m;
        }
    }

    public int getMarks() {
        return marks;
    }
}
```

---

## 🧪 Jab tu Generic Class banata hai (like `Box<T>`):

Tu `T value` ko **private** rakhta hai, aur access karta hai safely:

```java
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```

### Toh jab tu likhega:

```java
Box<Integer> b = new Box<>();
b.set(10);
System.out.println(b.get()); // ✅ Safe & clean
```

---

## 🔄 Random Class banayi toh bhi `get`/`set` daalte hain kya?

### ✅ Mostly YES, if:

* Class ke andar data hai
* Aur tu usko access/control karna chahta hai

### ❌ Nahi daalte if:

* Class ke andar kuch logic ya behavior hai, but no data to store
* Ya tu chhoti script bana raha hai, jisme encapsulation important nahi

---

## 🧠 Ek Thumb Rule:

| Situation                             | Use Getter/Setter? | Why                                   |
| ------------------------------------- | ------------------ | ------------------------------------- |
| Data classes (like `Box`, `Student`)  | ✅ Yes              | To **encapsulate and protect** fields |
| Logic-only classes                    | ❌ Maybe not needed | No fields to access                   |
| Internal fields but no need to expose | ❌ No               | Hide completely                       |

---

## 🎯 Final Verdict:

| Concept          | Summary                                                                 |
| ---------------- | ----------------------------------------------------------------------- |
| `set()` method   | Value ko safely daalne ke liye                                          |
| `get()` method   | Value ko safely nikaalne ke liye                                        |
| Encapsulation    | Data ko private rakhkar access control karna                            |
| Random class use | Depends on need: if data hai aur expose karna hai → use getters/setters |

---

## 🔧 Want a Challenge?

Batao bhai — tu chahe to main tujhe ek mini assignment bana ke doon:

* Ek generic class with `get`/`set`
* Ek non-generic version
* Aur tu difference feel karega live code me

Bole toh start karaun?

 */