interface Dadaji {
    public static final int dheight = 190;
    public abstract void Nasha ();
}

interface Maa{
    public final static double height = 170;
    
}

interface Papa {
    public static final int height = 180;
}


class Bachha implements Maa, Papa, Dadaji{
   public void Nasha (){
    System.out.println("Khaini");
   }
}



public class Interfaces {
    public static void main(String[] args) {
        
        Bachha babu = new Bachha();
        System.out.println(babu.dheight);
        babu.Nasha();
    }
}
