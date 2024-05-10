public class Mar6 {
    public static void main(String[] args){
        supra obj = new supra();
        obj.firstFunction();
        obj.secondFunction();
    }
}

interface A{
    void firstFunction();
}

interface B{
    void secondFunction();
}

class supra implements A, B{
    public void firstFunction(){
        System.out.println("First definition in supra");
    }
    public void secondFunction(){
        System.out.println("Second definition in supra");
    }
}