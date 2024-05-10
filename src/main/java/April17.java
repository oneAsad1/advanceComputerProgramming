// Lab Task - Collection Framework - Array List
// Muhammad Asad Bashir
// 4296-BSSE-F21-A

import java.util.ArrayList;
import java.util.Collections;

class Student{
    String rollNumber, Name, degree;
    Student(String rollNumber, String Name, String degree){
        this.rollNumber = rollNumber;
        this.Name = Name;
        this.degree = degree;
    }
    String getName(){
        return Name;
    }
    String getRollNumber(){
        return rollNumber;
    }

}
public class April17 {
    public static void main(String[] args) {

        // 1. Creating ArrayLists
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> fruitNames = new ArrayList<>();
        ArrayList<Student> studentList = new ArrayList<>();

        Student firstStudent = new Student("4296", "Asad", "BSSE");

        // 2. Basic Operations
        numbers.add(20); numbers.add(30); numbers.add(10);
        fruitNames.add("Apple"); fruitNames.add("Banana"); fruitNames.add("Orange");
        studentList.add(firstStudent);
        System.out.println(numbers.getFirst());
        System.out.println(fruitNames.getFirst());
        fruitNames.remove("Banana");

        // 3. Accessing Elements
        for (Integer obj: numbers)
            System.out.print(obj + " ");
        System.out.println();
        for (String obj: fruitNames)
            System.out.print(obj + " ");
        System.out.println();
        for(Student obj:studentList){
            System.out.print(obj.getRollNumber() + " ");
            System.out.println(obj.getName());
        }

        // 4. Searching and Sorting
        System.out.println("Index of Apple is: " + fruitNames.indexOf("Apple"));
        System.out.print("Before sorting: ");
        for (Integer obj: numbers)
            System.out.print(obj + " ");
        System.out.println();
        System.out.print("After sorting: ");
        Collections.sort(numbers);
        for (Integer obj: numbers)
            System.out.print(obj + " ");
        System.out.println();

        // 5. ArrayList Utilities
        System.out.println("size of arrayList: " + numbers.size());
        System.out.println("checking if empty: " + numbers.isEmpty());
        numbers.clear();
        System.out.println("After clear function: " + true);

        // 6. Exception Handling
        try{
            System.out.println(numbers.get(3));
        }catch (IndexOutOfBoundsException exp){
            System.out.println("There is no such index");
        }
        try {
            fruitNames.add(null);
            throw new NullPointerException();
        }catch (NullPointerException exp){
            System.out.println("Met with a null string");
        }

        System.out.println("in the show");
        // 7. Using Iterator
//        Iterator<String> itr = fruitNames.iterator();
//        while (itr.hasNext()) {
//            System.out.print(itr.next() + " ");
//        }
    }
}

