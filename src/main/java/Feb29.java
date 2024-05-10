public class Feb29 {
    public static void main(String[] args){
        //System.out.println("hello bro");
        pitBull leo = new pitBull();

    }
}

class animal{
    animal(){
        System.out.println("This is animal class");
    }
    animal(String part){
        System.out.println("extra animal constructor " + part);
    }
}

class Dog extends animal{
    Dog(){
        System.out.println("This is dog class");
    }
    Dog(String part){
        super("called by Dog class");
        System.out.println("extra dog constructor " + part);
    }
}

class pitBull extends Dog{
    pitBull(){
        System.out.println("This is pitBull class");
    }
    pitBull(String type){
        super("called by pitbull");
        System.out.println("extra pitbull constructor " + type);
    }
}