public class P9 {
    public static void main(String[] args) {

        Student s1 = new Student(12, 14, 18);
        Student s2 = new Student(48, 68, 98);
        System.out.println(s1.totalMarks());
        System.out.println(s2.avgMarks());
        Student.totalAvgOfAll();

    }
}

class Student {
    int subjectA;
    int subjectB;
    int subjectC;

    static int totalsubA = 0;
    static int totalsubB = 0;
    static int totalsubC = 0;
    static int studentCount = 0;

    Student(int subjectA, int subjectB, int subjectC) {
        this.subjectA = subjectA;
        this.subjectB = subjectB;
        this.subjectC = subjectC;

        totalsubA += subjectA;
        totalsubB += subjectB;
        totalsubC += subjectC;
        studentCount++;
    }

    int totalMarks() {
        return subjectA + subjectB + subjectC;
    }

    double avgMarks() {
        return this.totalMarks() / studentCount;
    }

    static void totalAvgOfAll() {
        int total = totalsubA + totalsubB + totalsubC;
        double avg = (double) total / (studentCount * 3);

        System.out.println("Total Sum: " + total);
        System.out.println("Total Avg: " + avg);
    }

}