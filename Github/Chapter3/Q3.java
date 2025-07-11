import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Q3 {

    public static <T> List<T> traverseReverse (ArrayList aList){
        List <T> sortedList = new ArrayList<>();

        // Start iterator from the end 
        ListIterator<T> itr = aList.listIterator(aList.size());

        while (itr.hasPrevious()) {
            sortedList.add(itr.previous());
        }
        return sortedList;
    }

    public static void main(String[] args) {
        ArrayList <Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);

        // Reverse and Print
        System.out.println(traverseReverse(arrayList));
    }
}
/*
 * Yes, you're absolutely right — what you've shared is the **default syntax for writing a generic method** in Java.

Let’s explain it clearly and link it with your `traverseReverse()` method too.

---

## ✅ Step-by-Step Breakdown: **Generic Method Syntax**

```java
<T> ReturnType methodName(ParameterType param) {
    // method body
}
```

This breaks into 3 parts:

| Part         | Example in code            | Meaning                                      |
| ------------ | -------------------------- | -------------------------------------------- |
| `<T>`        | `<T>`                      | **Generic declaration** (before return type) |
| `ReturnType` | `void`, `List<T>`, etc.    | The return type of the method                |
| `methodName` | `print`, `traverseReverse` | Method name                                  |

---

## 🧱 Example 1: Simple Generic Method

```java
<T> void print(T[] arr) {
    for (T val : arr) {
        System.out.println(val);
    }
}
```

* `<T>`: Declares that this method uses a generic type `T`
* `T[] arr`: The method parameter is an array of type `T`
* `val : arr`: Loop over elements of type `T`

---

## ✅ Example 2: Your `traverseReverse()` Method

You wrote:

```java
public static <T> List<T> traverseReverse(ArrayList<T> aList)
```

### 🔍 Breakdown:

| Part                 | Meaning                                                   |
| -------------------- | --------------------------------------------------------- |
| `<T>`                | Generic declaration: `T` can be `Integer`, `String`, etc. |
| `List<T>`            | Return type is a `List` of type `T`                       |
| `ArrayList<T> aList` | Input is an ArrayList of same type `T`                    |
| Works with any `T`   | Reusable for `Integer`, `String`, `Double`, etc. ✅        |

---

## ✅ Why use `<T>` before the return type?

Because that tells the compiler:

> “This method is generic, and I will use `T` as a placeholder type.”

If you **don’t declare `<T>`**, the compiler will say:

> “What is `T`? I’ve never seen this before!”

---

## ❌ Common Mistake:

```java
public static List<T> traverseReverse(ArrayList<T> aList)  // ❌
```

This will give a **compile-time error**, because you forgot to declare `<T>` before return type.

✅ Correct:

```java
public static <T> List<T> traverseReverse(ArrayList<T> aList)
```

---

## ✅ Summary

| Syntax               | Meaning                                |
| -------------------- | -------------------------------------- |
| `<T>`                | Declare generic type `T`               |
| `List<T>`            | Return type is a list of `T`           |
| `ArrayList<T> aList` | Input parameter is a list of `T`       |
| Works with any type  | `Integer`, `String`, `Student`, etc. ✅ |

---

Let me know if you want a version that works with a custom class like `Student` or `Book`, or a full generic class too!

 */