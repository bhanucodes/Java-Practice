abstract class Persistence{
    abstract void persist();
}

class FilePersistence extends Persistence{
    @Override
    void persist() {
        System.out.println("Saving to a file");
    }
}

class DatabasePersistence extends Persistence{
    @Override
    void persist() {
        System.out.println("Saving to Database");
    }
}
public class P4 {
    public static void main(String[] args) {
        
        System.out.println(10/0);
       
        
       
    }
}
