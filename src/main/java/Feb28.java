import java.util.Scanner;

public class Feb28 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter dimensions of the Box: ");
        double length = input.nextDouble();
        double width = input.nextDouble();
        double height = input.nextDouble();
        Box firstBox = new Box(length, width, height);

        Box.displayBox(firstBox);
    }
}

class Box{
    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    private double getLength() {
        return length;
    }

    private void setLength(double length) {
        this.length = length;
    }

    private double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    private double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private double surfaceArea(){
        return (2*length*width) + (2*length*height) + (2*width*height);
    }
    private double lateralSurface(){
        return (2*length*height) + (2*width*height);
    }
    private double volume(){
        return length*width*height;
    }

    public static void displayBox(Box obj){
        System.out.printf("Surface Area: %.2f%n", obj.surfaceArea());
        System.out.printf("Lateral Surface Area: %.2f%n", obj.lateralSurface());
        System.out.printf("Volume: %.2f%n", obj.volume());
    }

}