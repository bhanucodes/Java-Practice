Program 5 ===============================================================================================================================================================

The red underline (error) is happening \*\*because you're defining a method (`bubbleSort`) **inside the `main` method**, which is **not allowed** in Java.

---

### ❌ Invalid:

```java
public static void main(String[] args) {
    // This is NOT allowed
    void bubbleSort(int arr[]) { 
        ...
    }
}
```

Java does **not allow nested method definitions** like this.

---

### ✅ Fix: Define `bubbleSort` outside `main`, like this:

```java
public class P5_2 {

    public static void main(String[] args) {
        int arr[] = {5, 8, 9, 7, 5, 6};
        bubbleSort(arr);

        // Print sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Method defined outside main
    static void bubbleSort(int arr[]) {
        for (int turn = 0; turn < arr.length - 1; turn++) {
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
```

---

### ✅ Output:

```
5 5 6 7 8 9
```

Great questions! Let's go through them one by one with clear examples and reasons.

---

### ❓ **1. Why are we using `static` for the `bubbleSort()` method?**

In Java:

* The `main()` method is **`static`**, which means it **belongs to the class**, not to any object.
* Inside a `static` method (like `main`), you **can only call other static methods directly** (without creating an object).

---

### ✅ So we use:

```java
static void bubbleSort(int arr[]) { ... }
```

This allows `main()` to call `bubbleSort()` directly like:

```java
bubbleSort(arr);
```

---

### ❓ **What if you remove `static` from `bubbleSort()`?**

Then your code must be changed to **use an object** to call the method:

#### ❌ Won’t Work:

```java
void bubbleSort(int arr[]) { ... }

public static void main(String[] args) {
    int arr[] = {5, 8, 9, 7, 5, 6};
    bubbleSort(arr); // ❌ ERROR: Cannot make a static reference to the non-static method
}
```

#### ✅ Correct Way:

```java
void bubbleSort(int arr[]) { ... }

public static void main(String[] args) {
    int arr[] = {5, 8, 9, 7, 5, 6};
    
    P5_2 obj = new P5_2();        // Create object
    obj.bubbleSort(arr);         // Call using object
}
```

---

### 💡 So in summary:

| `bubbleSort()` method | How to call in `main()`       |
| --------------------- | ----------------------------- |
| `static`              | `bubbleSort(arr);`            |
| `non-static`          | `new P5_2().bubbleSort(arr);` |

---

### ❓ **Can we define a method inside another method in Java?**

> ❌ **No, you cannot define a method inside another method in Java.**

Java **does not support method-local function declarations** like Python or JavaScript.

---

### ❓ **Can we define a class inside a class?**

> ✅ **Yes, Java allows classes inside classes.**

There are 4 types of **nested classes** in Java:

| Type                   | Description                         |
| ---------------------- | ----------------------------------- |
| Static nested class    | Like a static member of outer class |
| Non-static inner class | Requires object of outer class      |
| Local inner class      | Defined inside a method             |
| Anonymous inner class  | For one-time use (e.g., listeners)  |

---

### ✅ Example: Inner Class

```java
class Outer {
    class Inner {
        void show() {
            System.out.println("Inner class method");
        }
    }

    public static void main(String[] args) {
        Outer.Inner obj = new Outer().new Inner();
        obj.show();
    }
}
```

---

### ✅ Final Summary:

* `static` is used so that the method can be called from `main()` without creating an object.
* You **cannot define methods inside methods** in Java.
* You **can define classes inside classes**, but with special rules (inner classes, static nested classes).

Let me know if you want examples for any of the 4 types of inner classes or full memory flow explanation.
#### -----------------------------------------------------

✅ **Yes**, in Java, you can create **other classes inside a `public class`** — these are called **nested classes** or **inner classes**.

---

### 🔴 BUT — there's an important rule:

> **In a single `.java` file, only one public class is allowed**, and the name of the file **must match that public class name**.

So:

### ✅ This is allowed:

```java
public class Outer {
    class Inner {
        void display() {
            System.out.println("Hello from Inner class!");
        }
    }

    public static void main(String[] args) {
        Outer.Inner obj = new Outer().new Inner();
        obj.display();
    }
}
```

### ❌ But this is **not** allowed in the same file:

```java
public class A { }  
public class B { }  // ❌ ERROR: Only one public class allowed per file
```

---

### ✅ So what kinds of classes can you define inside a `public class`?

There are 4 types of **nested classes**:

| Type                          | Can access outer class? | Static? | Use case                                 |
| ----------------------------- | ----------------------- | ------- | ---------------------------------------- |
| 1. **Static Nested Class**    | ❌ (no outer instance)   | ✅ Yes   | Used when inner class doesn't need outer |
| 2. **Non-static Inner Class** | ✅ Yes                   | ❌ No    | Needs outer class object                 |
| 3. **Local Inner Class**      | ✅ (if in same method)   | ❌ No    | Declared inside a method                 |
| 4. **Anonymous Class**        | ✅ (short-lived)         | ❌ No    | For one-time use like event handling     |

---

### ✅ Example of each:

#### 1. **Static Nested Class**

```java
public class Outer {
    static class Inner {
        void show() {
            System.out.println("Static nested class");
        }
    }

    public static void main(String[] args) {
        Outer.Inner obj = new Outer.Inner();
        obj.show();
    }
}
```

#### 2. **Non-static Inner Class**

```java
public class Outer {
    class Inner {
        void show() {
            System.out.println("Inner class");
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.show();
    }
}
```

#### 3. **Local Inner Class**

```java
public class Outer {
    void outerMethod() {
        class Local {
            void show() {
                System.out.println("Local inner class");
            }
        }
        Local local = new Local();
        local.show();
    }

    public static void main(String[] args) {
        new Outer().outerMethod();
    }
}
```

#### 4. **Anonymous Class**

```java
public class Outer {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Anonymous inner class");
            }
        };
        r.run();
    }
}
```

---

### ⚠️ Final Notes:

* Only **one public class per `.java` file**, and the file name **must match** that class.
* You **can** define any number of other classes (non-public or nested) inside a public class.

