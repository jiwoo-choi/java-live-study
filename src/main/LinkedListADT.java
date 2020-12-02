package main;

/// spec reference : https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
interface LinkedListADT extends Cloneable, Iterable<Integer> {

    /// Appends the specified element to the end of this list.
    boolean add(Integer value);
    /// Inserts the specified element at the specified position in this list.
    void add(int index, Integer value);
    Integer get(int index);
    /// Returns the first element in this list.
    Integer getFirst();
    /// Returns the last element in this list.
    Integer getLast();
    /// Removes all of the elements from this list.
    void clear();
    /// Returns true if this list contains the specified element.
    boolean contains(Integer value);
    /// Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    int indexOf(Integer o);
    /// Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
    int lastIndexOf(Integer o);
    /// Retrieves and removes the head (first element) of this list.
    Integer remove();
    /// Removes the element at the specified position in this list.
    Integer remove(int index);
    /// Removes the first occurrence of the specified element from this list, if it is present.
    boolean	remove(Integer o);
    /// Removes and returns the first element from this list.
    Integer removeFirst();
}
