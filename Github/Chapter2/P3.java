abstract class Shape{
    abstract void draw();
}

class Line extends Shape{
    @Override
    void draw() {
        System.out.println("Line Created");
    }
}

class Rectangle extends Shape{
    @Override
    void draw() {
        System.out.println("Rectange Created");
    }
}

class Cube extends Shape{
    @Override
    void draw() {
        System.out.println("Cube Created");
    }
}

public class P3 {
    public static void main(String[] args) {
        
    }
}
