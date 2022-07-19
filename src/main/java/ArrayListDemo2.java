import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static java.util.Collections.sort;

public class ArrayListDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> number1= new ArrayList<>();
        number1.add(10);
        number1.add(20);
        number1.add(3);
        number1.add(40);
        number1.add(5);

        ArrayList<Integer> number2= new ArrayList<>();
        number2.add(100);
        number2.add(200);
        number2.add(300);
        number2.add(400);
        number2.add(500);

        System.out.println(number1);
        System.out.println(number2);
        System.out.println("-----------------");
        number1.addAll(number2);
        System.out.println(number1);

        Collections.sort(number1);
        System.out.println(number1);
    }
}
