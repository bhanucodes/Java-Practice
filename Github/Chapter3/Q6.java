import java.util.HashSet;
import java.util.Hashtable;

class Employee {

    private String name;
    private int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 10;
    }

    @Override
    public String toString() {
        return "Employee{ name =" + name + ", id =" + id + "}";
    }
}

public class Q6 {
    public static void main(String[] args) {
        Employee a = new Employee("Aman", 1);
        Employee b = new Employee("Raman", 2);
        Employee c = new Employee("Saman", 3);

        Hashtable<Employee, String> ht = new Hashtable<>();
        ht.put(a, "V1");
        ht.put(b, "V2");
        ht.put(c, "V3");
        System.out.println(ht);
    }
}
