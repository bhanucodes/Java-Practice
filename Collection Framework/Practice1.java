import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Practice1 {
    public static void main(String[] args) {
        
        List <Integer> l = new ArrayList<>();

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

        // System.out.println(l);
        // l.add(3, 4);
        // System.out.println(l);

        // System.out.println(l.get(3));

        List <Integer> m = new ArrayList<>();
        m.add(5);
        m.add(6);
        m.add(7);
        m.add(8);

        // l.addAll(m);
        l.addAll(m);
        // System.out.println(m);
        // System.out.println(m.reversed());

        // using Itertor interface and it's specified class to iterate over Arraylist
        Iterator <Integer> i = m.iterator();
        while (i.hasNext()) {
            System.out.print(i.next()+" ");
        }
    }
    
    


}
/*
 * Great observation! But let’s clear up that confusion right away 👇

---

### ❓ Your Doubt:

> If `ArrayList` starts from index `0`, and `Iterator` prints the *next* element using `i.next()`, then is the 0th element skipped?

**Answer: NO**, the `0th` element is **not skipped**.

---

### ✅ Why?

The `Iterator` starts **before** the first element — it's like a pointer **in between** elements.

So when you call `i.next()`, it moves to index `0` and returns that element.

---

### 🔁 Internally (Imagine it like this):

Before any iteration:

```
Iterator pointer:   |
List:             [5, 6, 7, 8]
Index:             0  1  2  3
```

---

1st call to `i.next()`:

* Moves to index 0 → returns `5`

```
Iterator pointer:      |
List:                [5, 6, 7, 8]
Index:                0  1  2  3
```

2nd call:

* Moves to index 1 → returns `6`

```
Iterator pointer:         |
List:                   [5, 6, 7, 8]
Index:                   0  1  2  3
```

... and so on.

---

### ✅ So `i.next()` gives:

| Call       | Cursor moves to index | Element returned |
| ---------- | --------------------- | ---------------- |
| `i.next()` | 0                     | 5                |
| `i.next()` | 1                     | 6                |
| `i.next()` | 2                     | 7                |
| `i.next()` | 3                     | 8                |

---

### 🧠 Summary:

* `ArrayList` index starts at 0.
* `Iterator` starts **before index 0**, not *on* index 0.
* `i.next()` moves to **index 0** and returns its value. So nothing is skipped.

Let me know if you want a visual explanation with arrows or want to explore how `ListIterator` works differently.

 */