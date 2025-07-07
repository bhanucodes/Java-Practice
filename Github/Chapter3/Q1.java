import java.util.Comparator;
import java.util.TreeSet;

class Person {
    private String name;
    private int height;
    private double weight;

    Person(String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }

    public double getWeight() { // ✅ Fixed return type
        return this.weight;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(double weight) { // ✅ Fixed parameter type
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + "', height=" + height + ", weight=" + weight + "}";
    }
}

// ✅ Top-level Comparator class
class PersonListForSorting implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getWeight() < p2.getWeight()) {
            return -1;
        } else if (p1.getWeight() > p2.getWeight()) {
            return 1;
        } else {
            if (p1.getHeight() < p2.getHeight()) {
                return -1;
            } else if (p1.getHeight() > p2.getHeight()) {
                return 1;
            } else {
                return p1.getName().compareTo(p2.getName());
            }
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        TreeSet<Person> personTreeSet = new TreeSet<>(new PersonListForSorting());
        personTreeSet.add(new Person("A", 1, 1.0));
        personTreeSet.add(new Person("B", 2, 2.0));
        personTreeSet.add(new Person("C", 1, 0.5));

        System.out.println("Sorted Persons based on weight, then height:");
        for (Person person : personTreeSet) {
            System.out.println(person);
        }
    }
}
