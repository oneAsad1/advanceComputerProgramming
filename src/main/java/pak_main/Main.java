package pak_main;
import pak_BasicAction.BasicAction;
public class Main {
    public static void main(String[] args){
        BasicAction math = new BasicAction();
        math.adder(2, 2);
        math.adder(3, 3, 3);
        math.adder(4, 4, 4, 4);
    }
}

//protected and default functions are only accessible within the same package
//private are only inside the class