package listnode.stack;

import listnode.stack.ListNodeStack;
import listnode.stack.Stack;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class StackTest {

    @Test
    void stack_init_test() {
        Stack st = new Stack();
        assertEquals(st.getSize(), 0);
    }

    @Test
    void stack_init_capacity_test() {
        Stack st = new Stack(20);
        assertEquals(st.getSize(), 0);
    }

    @Test
    void stack_push_test() {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        assertEquals(st.getSize(), 2);
    }

    @Test
    void stack_pop_test() {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        int val = st.pop();
        assertEquals(val, 2);
        assertEquals(st.getSize(), 1);
    }

    @Test
    void stack_push_extend_test() {
        Stack st = new Stack(2);
        st.push(1);
        st.push(2);
        assertEquals(st.getCurrentCapacity(), 2);
        st.push(3);
        st.push(4);
        assertEquals(st.getSize(), 4);
        assertEquals(st.getCurrentCapacity(), 4);
    }

    @Test
    void stack_pop_extend_test() {
        Stack st = new Stack(2);
        st.push(1);
        st.push(2);
        assertEquals(st.getCurrentCapacity(), 2);
        st.push(3);
        st.push(4);
        assertEquals(st.getCurrentCapacity(), 4);
        int val = st.pop();
        assertEquals(st.getCurrentCapacity(), 4);
        assertEquals(val, 4);
        assertEquals(st.getSize(), 3);
    }

    @Test
    void stack_pop_error() {
        Stack st = new Stack(2);
        try {
            st.pop();
            fail("Expected : EmptyStackException should be thrown.");
        } catch (EmptyStackException e) {
        } catch (Exception e) {
            fail("Expected : EmptyStackException should be thrown.");
        }
    }

    @Test
    void stack_pop_all_test() {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        ArrayList<Integer> temp = new ArrayList<Integer>();

        while(st.getSize() != 0) {
            temp.add(st.pop());
        }

        assertEquals(temp.get(0), 4);
        assertEquals(temp.get(1), 3);
        assertEquals(temp.get(2), 2);
        assertEquals(temp.get(3), 1);
        assertEquals(st.getSize(), 0);
    }
}