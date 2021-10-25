package MyArray;

import java.util.Iterator;

public class MyArrayList<E> implements IMyArray<E> {

    private E[] values;

    public MyArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[values.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public E get(int index) {
        try {
            return values[index];
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void remove(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[values.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp,
                    index + 1,
                    values, index,
                    (temp.length - 1 - index));
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }
}
