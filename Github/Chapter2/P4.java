import java.util.ArrayList;

// This code contains compliletime/static allocation
// P42 contains the method of Runtime/dynamic allocation

abstract class Persistence{
    abstract String persist();
}

class FilePersistence extends Persistence{
    @Override
    String persist() {
        return "File is Persistance";
    }
}

class DatabasePersistence extends Persistence{
    @Override
    String persist() {
        return "Database is Persistence";
    }
}

public class P4{
    public static void main(String[] args) {

        
        ArrayList<Persistence> obj = new ArrayList<>();
        obj.add(new FilePersistence());
        obj.add(new DatabasePersistence());
        
        for (Persistence e : obj) {
            System.out.println(e.persist());
        }
    }
}