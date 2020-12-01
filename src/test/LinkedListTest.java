package test;

import main.LinkedList;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {


    @Test
    void add_FunctionalTest() {
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




    /// input이 어떻게 들어올지 예상.
    /// value값 범위 테스트?
    /// Integer범위 테스트는 어떻게?
    /// Integer범위 테스트??
    /// 범위테스트
    /// 값 정확도 테스트.



}