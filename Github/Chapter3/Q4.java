
import com.sun.org.apache.regexp.internal.RE;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Write a program using Hashtable or HashMap where Date of birth is a key & Employee name as value.
 * Design the class Date is such a way where the get method fails if two employees have same
 * day & month of birth but birth year is different.
 */


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

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

public class Q4 {

    public String getEmployee(HashMap<DateClass, String> dob, String employeeName){
        Set set = dob.entrySet();
        Iterator itr = set.iterator();
        Iterator itr2 = set.iterator();
        int day=0;
        int month=0;
        int year=0;
        while (itr.hasNext()){
            Map.Entry m1 = (Map.Entry)itr.next();
            DateClass dateClass = (DateClass)m1.getKey();
            if(m1.getValue().equals(employeeName)){

                day= dateClass.getDate();
                month=dateClass.getMonth();
                year = dateClass.getYear();
            }

        }

        while (itr2.hasNext()){
            Map.Entry m1 = (Map.Entry)itr2.next();
            DateClass dateClass = (DateClass)m1.getKey();
            if( (day==dateClass.getDate() && month==dateClass.getMonth() && year!=dateClass.getYear()) && (!m1.getValue().equals(employeeName)) ){
                return "get method fails";
            }

        }
        return employeeName;
    }

    public static void main(String[] args) {
        HashMap<DateClass,String> employee = new HashMap<>();

        DateClass dateClass1 = new DateClass(04,07,1995);
        DateClass dateClass2 = new DateClass(04,03,1997);
        DateClass dateClass3 = new DateClass(04,07,1995);

        DateClass dateClass4 = new DateClass(04,03,1995);

        employee.put(dateClass1,"Ajay1");
        employee.put(dateClass2,"Ajay2");
        employee.put(dateClass3,"Ajay");
        employee.put(dateClass4,"Ajay3");

        Q4 assignment3Q4 = new Q4();
        assignment3Q4.getEmployee(employee,"Ajay2");



    }
}

/*
 * This program uses a number of **Core Java concepts**, including:

---

## ✅ **Objective of the Program**

* **Use a HashMap/Hashtable where Date of Birth is the key and Employee name is the value.**
* Design the **DateClass** in such a way that the **get() method fails** if **two employees share the same date and month**, but **different years.**

---

## ✅ **Core Java Concepts Used**

---

### 1. **HashMap**

* `HashMap<DateClass, String>` is used to store Date of Birth as the key and employee name as the value.
* It's **key-based data structure** that allows **O(1)** lookup time.

### 2. **Custom Class as Key in HashMap**

* `DateClass` is a **user-defined class** being used as the key in `HashMap`.
* **Important Note:** For a class to work correctly as a key, it **must override `equals()` and `hashCode()`**. In this code, it does **not**, which can cause unexpected behavior like:

  ```java
  DateClass d1 = new DateClass(4, 7, 1995);
  DateClass d2 = new DateClass(4, 7, 1995);
  map.put(d1, "Ajay1");
  map.put(d2, "Ajay2");  // This will not replace d1 entry!
  ```

---

### 3. **Iteration over EntrySet of Map**

```java
Set set = dob.entrySet();
Iterator itr = set.iterator();
```

* You use **Map.Entry** to iterate through key-value pairs of HashMap using:

  ```java
  Map.Entry m1 = (Map.Entry)itr.next();
  ```

---

### 4. **Two-Pass Iteration Logic**

* **First Loop**: Extracts the DateClass object (DOB) of the employee whose name matches the given name.
* **Second Loop**: Scans the rest of the map to check if **any other employee has same day and month but different year.**

  * If found → `"get method fails"`

---

### 5. **Encapsulation**

* `DateClass` uses **private fields** with **getter and setter methods**, a common OOP practice.

---

### 6. **Overriding `toString()`**

```java
@Override
public String toString() {
    return ...
}
```

* Provides a human-readable output when printing the object.

---

### 7. **No Use of `equals()` and `hashCode()` (But Should Be There)**

* **Problem:** Since the `DateClass` does not override `equals()` and `hashCode()`, even identical date objects will not be treated as equal:

  ```java
  DateClass d1 = new DateClass(4, 7, 1995);
  DateClass d2 = new DateClass(4, 7, 1995);
  System.out.println(d1.equals(d2)); // false
  ```

---

## 🔍 **Key Logic Explanation: `getEmployee()` Method**

```java
public String getEmployee(HashMap<DateClass, String> dob, String employeeName) {
    ...
    // Step 1: Find DOB of given employee
    // Step 2: Check if any other employee has same day & month but different year
    //         If yes → Return "get method fails"
    // Else → Return employeeName
}
```

### 🧠 **Why two iterations?**

Because you first need to find the DOB of the given employee, then compare with others. If done in single loop, logic becomes messy.

---

## ✅ OUTPUT EXAMPLE

Let’s say:

```java
DateClass d1 = new DateClass(4, 3, 1997); // Ajay2
DateClass d2 = new DateClass(4, 3, 1995); // Ajay3
```

Then:
`getEmployee(map, "Ajay2")` → will return **"get method fails"**, because **Ajay2 and Ajay3** have same **date (4)** and **month (3)**, but **different years**.

---

## ⚠️ Issues in Your Code

| Issue                                                         | Solution                                                                                                               |
| ------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------- |
| `DateClass` does **not override** `equals()` and `hashCode()` | Override them using `date` and `month` only if you want custom key logic, or include `year` if you want full DOB match |
| `getEmployee()` prints nothing                                | Add a `System.out.println(...)` in `main()` to print result                                                            |

---

## ✅ Suggestion: Better `DateClass` with equals/hashCode

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    DateClass that = (DateClass) obj;
    return date == that.date && month == that.month && year == that.year;
}

@Override
public int hashCode() {
    return Objects.hash(date, month, year);
}
```

---

## ✅ Final Thoughts

You’ve used:

* HashMap
* Custom key class
* Encapsulation
* EntrySet iteration
* Conditional logic

To solve a real-world **data collision** problem — **"what if multiple employees are born on same day & month?"**

---

Would you like me to:

* ✅ Refactor your code to make it clean and correct?
* ✅ Add `equals()` and `hashCode()`?
* ✅ Add output print and test?

Let me know and I’ll do it.

 */