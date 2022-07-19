import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
    public static void main(String[] args) {
        int[] numbers1 =new int[5];
        numbers1 [0]=10;
        numbers1 [1]=20;
        numbers1 [2]=30;
        numbers1 [3]=40;
        numbers1 [4]=45;
        ArrayList<Integer> numbers2= new ArrayList<>();
        numbers2.add(10);
        numbers2.add(15);
        numbers2.add(20);
        numbers2.add(25);
        numbers2.add(30);

        for (int i=0;i<numbers1.length;i++){
            System.out.print(numbers1[i]+" ");
        }
        System.out.println();
        for (int i: numbers1){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        for (int i=0;i<numbers2.size();i++){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();

        for (Integer i: numbers2){
            System.out.println(i);
        }

        System.out.println(Arrays.toString(numbers1));

        System.out.println(numbers2);
        numbers2.set(1,16); //change number
        System.out.println(numbers2);

        numbers2.add(5); //add number
        System.out.println(numbers2);

        numbers2.add(2, 25);//add number given index
        System.out.println(numbers2);

        numbers2.add(0, 5);
        System.out.println(numbers2);

        numbers2.remove(5); //remove number given index
        System.out.println(numbers2);

        numbers2.remove(new Integer(5)); // remove number given value
        System.out.println(numbers2);

        //numbers2.forEach(System.out::println); print number by number

        System.out.println(numbers2.contains(5));

        numbers2.clear();
        System.out.println(numbers2);
    }



}
