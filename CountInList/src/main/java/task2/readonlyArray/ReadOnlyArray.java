package task2.readonlyArray;

import java.util.ArrayList;

public class ReadOnlyArray {

    private ArrayList<Integer> arr;

    public void add(int value){
        arr.add(value);
    }
    public int get(int index){
        return arr.get(index);
    }



}
