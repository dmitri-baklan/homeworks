package MyArray;

public interface IMyArray<E> extends Iterable<E> {
    boolean add(E e);

    E get(int index);

    int size();

    void remove(int index);

    void update(int index, E e);
}
