import java.io.IOException;

public class Mar13 {
    public static void main(String[] args){
        //Exception Handling
        //Try, catch, finally, throw, throws
        //one try can have multiple catch blocks
        //finally is a block that will run for sure, no matter what is happening in other blocks
        //final, finally, and finalize
        Voter obj = new Voter("Khizer", 17);
        try{
            obj.castVote();
        }
        catch (AgeException ag){
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(ag);
        }
        obj = new Voter("Asad", 18);
        try{
            obj.castVote();
        }
        catch (AgeException ag){
            System.out.println(ag.getMessage());
        }
    }
}

class AgeException extends Exception{
    AgeException(String str){
        super(str);
    }
}

class Voter{
    String name;
    int age;
    Voter(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void castVote() throws AgeException{
        if(age < 18)
            throw new AgeException("constructor message");
        else
            System.out.println("Welcome to vote casting");
    }
}

