enum Status {
    Running, Failed, Pending, Sucess;
}

public class Enum1 {
    public static void main(String[] args) {
        
        Status [] ss = Status.values();

        for (Status s : ss) {
            System.out.println(s+" : "+s.ordinal());
        }
    }
}
