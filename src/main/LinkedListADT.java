package main;

/// spec reference : https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
interface LinkedListADT {

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
    boolean contains(Integer value);
}
