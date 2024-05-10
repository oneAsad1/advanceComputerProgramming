package pak_BasicAction;

public class BasicAction{
    public void add(int num1, int num2){
        System.out.println("The sum is: " + (num1 + num2));
    }
    public void add(int num1, int num2, int num3){
        System.out.println("The sum is: " + (num1 + num2 + num3));
    }
    public void add(int num1, int num2, int num3, int num4){
        System.out.println("The sum is: " + (num1 + num2 + num3 + num4));
    }
    public void adder(int... numbers){
        int sum = 0;
        for(int num:numbers)
            sum += num;
        System.out.println("The sum is: " + sum);
    }
}