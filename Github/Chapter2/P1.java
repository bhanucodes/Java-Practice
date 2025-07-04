class Employee {
    int salary = 100000;
    int totalSalary() {
        return salary;
    };
}

class Manager extends Employee {

    int incentive=20000;

    @Override
    int  totalSalary() {
        return salary+incentive;
    }

}

class Labour extends Employee {
    int overtime = 15000;

    @Override
    int totalSalary() {
        return  (salary+overtime);
    }
}

public class P1 {
    public static void main(String[] args) {

        Employee employees [] = new Employee[4];
        
        employees[0] = new Manager();
        employees[1]= new Labour();
        employees[2]= new Manager();
        employees[3] = new Labour();

        double totalSalary =0;

        for (Employee employee : employees) {
            totalSalary += employee.totalSalary();
        }
        System.out.println(totalSalary);
    }
}

/*
 * Great! Let's break it down **step by step** so you fully understand **how this line works**, what’s getting created, and how it behaves in memory.

---

## 🧠 LINE IN FOCUS:

```java
Employee[] employees = new Employee[4];
```

### ✅ What happens here?

1. You are creating an **array of size 4**.
2. This array is of type `Employee`, which means:

   * It can hold objects of **Employee** class
   * It can also hold **any subclass** of Employee (like `Manager` or `Labour`)
   * Because of **polymorphism** ✅

🧠 At this point, memory is allocated for 4 `Employee` references:

```java
[ null, null, null, null ]
```

---

## 🛠️ NEXT STEP:

```java
employees[0] = new Manager();
employees[1] = new Labour();
employees[2] = new Manager();
employees[3] = new Labour();
```

Let’s understand this line-by-line:

---

### 🔹 `employees[0] = new Manager();`

1. `new Manager()` creates an object of `Manager` class in heap.
2. Since `Manager` **extends** `Employee`, it **is-a** Employee.
3. Java allows:
   `Employee e = new Manager();`  ✅
4. So, the reference `employees[0]` (which expects `Employee`) can safely hold a `Manager` object.

➡️ Now array looks like:

```java
[ Manager object, null, null, null ]
```

---

### 🔹 `employees[1] = new Labour();`

Same logic:

* `Labour` is also a subclass of `Employee`.
* So `employees[1]` stores reference to a `Labour` object.

➡️ Updated array:

```java
[ Manager, Labour, null, null ]
```

And so on...

---

## 🧠 Final Structure in Memory:

```java
Employee[] employees = {
    Manager@1234,
    Labour@5678,
    Manager@9101,
    Labour@1121
};
```

Each element is a **reference** to a subclass object stored in heap.

---

## 🔁 What happens in this loop?

```java
for (Employee e : employees) {
    totalSalary += e.getSalary();
}
```

At runtime:

* Java checks actual object type (`Manager` or `Labour`)
* Calls the correct overridden method:

  * If `Manager`, calls `Manager.getSalary()`
  * If `Labour`, calls `Labour.getSalary()`

This is **runtime polymorphism (dynamic dispatch)**.

---

## 📌 Summary:

| Step | Action                                                                      |
| ---- | --------------------------------------------------------------------------- |
| 1    | `new Employee[4]` creates array for 4 Employee references                   |
| 2    | `new Manager()` creates an object of Manager in heap                        |
| 3    | `Employee` array can store references of any subclass                       |
| 4    | At runtime, correct version of `getSalary()` is called based on object type |

---

## 💡 Real-Life Example:

Let’s say:

* `Employee` is a **box**
* `Manager` and `Labour` are **different types of chocolates**
* You are storing them in an array of `Employee` boxes

Java doesn’t care what exact chocolate it is — as long as it fits inside a box 🍫

---

Let me know if you want a diagram or want to write code with custom inputs!

 */