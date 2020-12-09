package linkedlist;
import listnode.LinkedList;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {


    @Test
    void add_FunctionalTest() {
        new listnode.LinkedList();
        LinkedList linkedList = new LinkedList();
        assertTrue(linkedList.add(123412));
        assertEquals(1, linkedList.getSize());
    }

    @Test
    void add_Multiple_FunctionalTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(-1000);
        linkedList.add(2000);
        linkedList.add(3777);
        assertEquals(4, linkedList.getSize());
    }

    @Test
    void add2_FunctionalTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(0, 1);
        assertEquals(1, linkedList.getSize());
    }

    @Test
    void add2_Multiple_FunctionalTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(0, 1);
        linkedList.add(0, 1);
        linkedList.add(0, 1);
        assertEquals(3, linkedList.getSize());
    }

    @Test
    void add2_invalidInput_outofSize_Test() {
        LinkedList linkedList = new LinkedList();
        try {
            linkedList.add(5, 1);
            fail("Expected : throw IndexOutOfBoundsException");
        } catch(IndexOutOfBoundsException e) {
            // Success!
        } catch(Exception e){
            fail("Expected : throw IndexOutOfBoundsException");
        }
    }

    @Test
    void add2_invalidInput_negativeValue_Test() {
        LinkedList linkedList = new LinkedList();
        try {
            linkedList.add(-1, 1);
            fail("Expected : throw IndexOutOfBoundsException");
        } catch(IndexOutOfBoundsException e) {
            // Success!
        } catch(Exception e){
            fail("Expected : throw IndexOutOfBoundsException");
        }
    }

    @Test
    void add_NullInput_Test() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(null);
        assertEquals(1, linkedList.getSize());
    }

    @Test
    void add_get_FunctionalTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        assertEquals(1,  linkedList.get(0));
    }

    @Test
    void add_nothing_get_FunctionalTest() {
        LinkedList linkedList = new LinkedList();
        try {
            linkedList.get(0);
            fail("Expected : throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Success!
        }
    }


    @Test
    void add2_get_FunctionalTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(0, 5);
        assertEquals(5,  linkedList.get(0));
    }

    @Test
    void get_InvalidInput_Test() {
        LinkedList linkedList = new LinkedList();
        try {
            linkedList.get(-1);
            fail("Expected : throw IndexOutOfBoundsException");
        } catch(IndexOutOfBoundsException e) {
            // Success!
        } catch(Exception e){
            fail("Expected : throw IndexOutOfBoundsException");
        }
    }

    @Test
    void getFirst_FunctionalTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.add(-15);
        assertEquals(15,linkedList.getFirst());
    }

    @Test
    void getLast_FunctionTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.add(-15);
        assertEquals(-15,linkedList.getLast());
    }

    @Test
    void getLast_functionalTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        assertEquals(linkedList.getLast(), 1);
    }

    @Test
    void getLast_from_multiple_functionalTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(-15);
        linkedList.add(25);
        assertEquals(linkedList.getLast(), 25);
    }

    @Test
    void getLast_from_empty_functionalTest() {
        LinkedList linkedList = new LinkedList();
        try {
            linkedList.getLast();
        } catch (NoSuchElementException e) {
            // success
        } catch (Exception e) {
            fail("Expected : NoSuchElementException!");
        }
    }

    @Test
    void clear_FunctionTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.add(-15);
        linkedList.clear();
        assertEquals(0,linkedList.getSize());
        try {
            linkedList.get(0);
            fail("Expected: IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Success!
        }
    }

    @Test
    void clear_add_FunctionalTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.add(-15);
        linkedList.clear();
        linkedList.add(2);
        assertEquals(2, linkedList.get(0));
    }

    @Test
    void contains_FunctionalTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        assertTrue(linkedList.contains(15));
        assertFalse(linkedList.contains(-15));
    }

    @Test
    void contains_empty_FunctionalTest() {
        LinkedList linkedList = new LinkedList();
        assertFalse(linkedList.contains(15));
    }

    @Test
    void remove_from_empty_FunctionalTest() {
        LinkedList linkedList = new LinkedList();
        try {
            linkedList.remove();
            fail("Expected : NoSuchElementException");
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            fail("Expected : NoSuchElementException");
        }
    }

    @Test
    void remove_FunctionalTest(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.remove();
        assertEquals(0, linkedList.getSize());
        try {
            linkedList.getFirst();
            fail("Expected : NoSuchElementException");
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            fail("Expected : NoSuchElementException");
        }
    }


    @Test
    void remove_from_multiple_FunctionalTest(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.add(20);
        linkedList.add(25);
        linkedList.add(30);
        linkedList.remove();
        assertEquals(3, linkedList.getSize());
        assertEquals(25,linkedList.getLast());
        assertEquals(15, linkedList.getFirst());
    }

    @Test
    void remove_idx_FunctionalTest(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.remove(0);
        assertEquals(0, linkedList.getSize());
        try {
            linkedList.getFirst();
            fail("Expected : NoSuchElementException");
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            fail("Expected : NoSuchElementException");
        }
    }

    @Test
    void remove_idx_multiple_FunctionalTest(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.add(20);
        linkedList.add(25);
        linkedList.add(30);
        linkedList.remove(2);
        assertEquals(30, linkedList.get(2));
        assertEquals(15, linkedList.getFirst());
    }


    @Test
    void remove_value_FunctionalTest(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        boolean ok = linkedList.remove(Integer.valueOf(15));
        assertTrue(ok);
        try {
            linkedList.getFirst();
            fail("Expected : NoSuchElementException");
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            fail("Expected : NoSuchElementException");
        }
    }

    @Test
    void remove_value_failure_FunctionalTest(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        boolean ok = linkedList.remove(Integer.valueOf(20));
        assertFalse(ok);
    }

    @Test
    void remove_value_multiple_FunctionalTest(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.add(20);
        linkedList.add(25);
        linkedList.add(30);
        boolean ok = linkedList.remove(Integer.valueOf(20));
        assertTrue(ok);
        assertEquals(15, linkedList.getFirst());
        assertEquals(30, linkedList.getLast());
    }


    @Test
    void remove_first_FunctionalTest(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        Integer val = linkedList.removeFirst();
        assertEquals(val, 15);
        try {
            linkedList.getFirst();
            fail("Expected : NoSuchElementException");
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            fail("Expected : NoSuchElementException");
        }
    }

    @Test
    void remove_first_multiple_FunctionalTest(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.add(20);
        linkedList.add(25);
        linkedList.add(30);
        assertEquals(15, linkedList.removeFirst());
        assertEquals(20, linkedList.getFirst());
    }

    @Test
    void iterator_functional_test(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(15);
        linkedList.add(20);
        linkedList.add(25);
        linkedList.add(30);
    }

}