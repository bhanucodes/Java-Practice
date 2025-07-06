import java.util.Scanner;

abstract class Persistence {
    abstract String persist();
}

class FilePersistence extends Persistence {
    @Override
    String persist() {
        return "File is Persistance";
    }
}

class DatabasePersistence extends Persistence {
    @Override
    String persist() {
        return "Database is Persistence";
    }
}

public class P42 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the type of persistence (file/database): ");
        String str = sc.nextLine().toLowerCase();

        Persistence p ;
        if (str.equals("file")) {
            p = new FilePersistence();            
        }
        else if (str.equals("database")) {
            p = new DatabasePersistence();
        }
        else{
            System.out.println("Invalid Input. Defaulting to FilePersistence");
            p = new FilePersistence();
        }
        System.out.println(p.persist());

        sc.close();
    }
}





/*
 * Great question!

The yellow underline warning below sc:

```
Resource leak: 'sc' is never closed
```

comes from your IDE (like Eclipse or IntelliJ), and it’s telling you this:

---

### 🔍 **What the Warning Means:**

You're using this line:

```java
Scanner sc = new Scanner(System.in);
```

That creates a **resource** (a connection to the input stream `System.in`). The IDE is warning you that this resource **should ideally be closed** after you're done using it.

Why?

Because **not closing resources** (like file readers, input streams, scanners) can sometimes lead to:

* **Memory leaks** (in long-running programs),
* **Locking issues** on the input stream,
* **Bad programming practices** in general.

---

### ✅ **How to Fix the Warning**

You can fix it simply by **closing the scanner** at the end of your code:

```java
sc.close();
```

So your `main()` becomes:

```java
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the type of persistence (file/database): ");
    String str = sc.nextLine().toLowerCase();

    Persistence p;
    if (str.equals("file")) {
        p = new FilePersistence();            
    } else if (str.equals("database")) {
        p = new DatabasePersistence();
    } else {
        System.out.println("Invalid Input. Defaulting to FilePersistence");
        p = new FilePersistence();
    }

    System.out.println(p.persist());
    sc.close(); // ✅ Fixes the warning
}
```

---

### ⚠️ **Important Note:**

However, **closing `System.in`** using `sc.close()` **can cause issues** if you plan to read input again later in the program, or if you're using a shared input stream in some environments (like some IDEs or online judges).

So in **small programs** like yours, it’s okay to ignore this warning — it won’t cause any real problem. Just be aware of it when you build larger applications.

---

### ✅ Summary:

* ✔️ **The warning is safe to ignore in small programs**.
* 🛠️ **Fix it by calling `sc.close()`**, ideally at the end.
* ❗ **Avoid closing `System.in` in complex applications** where more input might be needed later.

Let me know if you want to learn about **try-with-resources**, which is another cleaner way to handle it!

 */