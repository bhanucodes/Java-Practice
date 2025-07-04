import java.util.ArrayList;

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

public class P1Better {
    public static void main(String[] args) {

        ArrayList <Employee> employees = new ArrayList<>();

        employees.add(new Manager());
        employees.add(new Labour());
        employees.add(new Manager());
        employees.add(new Labour());

        double totalSalary =0;

        for (Employee employee : employees) {
            totalSalary += employee.totalSalary();
        }
        System.out.println(totalSalary);
    }
}