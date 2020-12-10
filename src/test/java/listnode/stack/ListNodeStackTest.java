package listnode.stack;

import listnode.stack.ListNodeStack;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeStackTest {

    @Test
    void stack_init_test() {
        ListNodeStack st = new ListNodeStack();
        assertEquals(st.getSize(), 0);
    }

    @Test
    void stack_push_test() {
        ListNodeStack st = new ListNodeStack();
        st.push(1);
        st.push(2);
        assertEquals(st.getSize(), 2);
    }

    @Test
    void stack_pop_test() {
        ListNodeStack st = new ListNodeStack();
        st.push(1);
        st.push(2);
        int val = st.pop();
        assertEquals(val, 2);
        assertEquals(st.getSize(), 1);
    }


    @Test
    void stack_pop_all_test() {
        ListNodeStack st = new ListNodeStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        assertEquals(st.getSize(), 5);

        ArrayList<Integer> temp = new ArrayList<Integer>();

        while(st.getSize() != 0) {
            temp.add(st.pop());
        }

        assertEquals(temp.get(0), 5);
        assertEquals(temp.get(1), 4);
        assertEquals(temp.get(2), 3);
        assertEquals(temp.get(3), 2);
        assertEquals(temp.get(4), 1);

        assertEquals(st.getSize(), 0);
    }

    @Test
    void stack_pop_error() {
        ListNodeStack st = new ListNodeStack();
        assertThrows(EmptyStackException.class, ()->{ st.pop(); });

    }
}