public class Mar7 {
    public static void main(String[] args){
        Shapes obj;
        obj = new Circle(5); obj.area();
        obj = new Triangle(2.4, 5.4); obj.area();
        obj = new rectangle(2.4, 2.4); obj.area();
    }
}

class Shapes{
    public void area(){
        System.out.println("Area of shapes");
    }
}

class Triangle extends Shapes{
    double breath;
    double height;
    Triangle(double breath, double height){
        this.breath = breath;
        this.height = height;
    }
    public void area(){
        System.out.printf("Area of Triangle: %.2f%n", (0.5 * breath * height));
    }
}

class Circle extends Shapes{
    double radius;
    Circle(double radius){
        this.radius = radius;
    }
    public void area(){
        System.out.printf("Area of Circle: %.2f%n", (Math.PI * radius * radius));
    }
}

class rectangle extends Shapes{
    double length;
    double width;
    rectangle(double length, double width){
        this.width = width;
        this.length = length;
    }
    public void area(){
        System.out.printf("Area of rectangle: %.2f%n", (length * width));
    }
}