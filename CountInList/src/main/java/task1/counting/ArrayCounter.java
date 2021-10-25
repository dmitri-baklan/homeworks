package task1.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayCounter {
    public Map<Integer, Integer> countValues(ArrayList<Integer> arr) {
        Map<Integer, Integer> values_num = new HashMap<Integer, Integer>();
        int counter;
        for (int i = 0; i < arr.size(); ) {
            counter = 1;
            Integer out = arr.get(i);
            for (int j = i + 1; j < arr.size(); j++) {

                Integer in = arr.get(j);
                if (arr.get(i) == arr.get(j)) {
                    counter++;
                }
            }
            values_num.put(out, counter);
            arr.removeAll(Arrays.asList(out));
        }

        return values_num;
    }
}
