import task1.counting.ArrayCounter;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String... args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(4);
        arr.add(5);
        arr.add(-6);
        arr.add(4);
        arr.add(5);
        arr.add(3);
        arr.add(4);
        arr.add(2);
        arr.add(4);
        arr.add(5);
        arr.add(7);
        // 4,5,-6,4,5,3,4,2,4,5,7
        ArrayCounter counter = new ArrayCounter();
        Map<Integer, Integer> number_of_values = counter.countValues(arr);
        // System.out.println(number_of_values.);
        System.out.println(number_of_values);
    }
}
