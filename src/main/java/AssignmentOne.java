public class AssignmentOne {
    public static void main(String[] args){

        Lion lion = new Lion("Diego", 40);
        lion.getInfo();
        System.out.println();

        Elephant elephant = new Elephant("Manny", 90);
        elephant.getInfo();
        System.out.println();

        lion.roar();
        elephant.trumpet();
    }
}

interface animalBehavior{
    void eat();
    void sleep();
}

abstract class Animal implements animalBehavior{
    String name;
    int age;
    public void getInfo(){
        this.eat();
        this.sleep();
    }

    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    void setAge(int age){
        this.age = age;
    }
    int getAge(){
        return age;
    }
}

class Lion extends Animal{
    Lion(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("Im a lion, I eat meat");
    }
    public void sleep(){
        System.out.println("Im a lion, I sleep few hours");
    }

    public void roar(){
        System.out.println("Roar of lion");
    }
}

class Elephant extends Animal{

    Elephant(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("Im an Elephant, I eat grass and plants");
    }
    public void sleep(){
        System.out.println("Im an Elephant, I sleep too much");
    }
    public void trumpet(){
        System.out.println("Trumpet of an Elephant");
    }
}
