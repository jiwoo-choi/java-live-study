package listnode;

public interface ListADT<T> {
    T add(T head, T nodeToAdd, int position);
    T remove(T head, int positionToRemove);
    boolean contains(T head, T nodeTocheck);
}
