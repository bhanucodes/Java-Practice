class Student{
    String name;
    int roll;
    static String schoolName = "JSSP";

    static void percentange(int sub1, int sub2, int sub3){
        System.out.println((sub1+sub2+sub3)/3);
    }
}

public class Static {
    public static void main(String[] args) {


        System.out.println(Student.schoolName);

        Student.percentange(12, 14, 56);

        
    }
}
