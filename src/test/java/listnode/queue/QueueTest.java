package listnode.queue;

import listnode.stack.ListNodeStack;
import listnode.stack.Stack;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void queue_init_test() {
        Queue q = new Queue();
        assertEquals(q.getSize(), 0);
    }

    @Test
    void queue_init_capacity_test() {
        Stack q = new Stack(20);
        assertEquals(q.getSize(), 0);
    }

    @Test
    void queue_add_test() {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        assertEquals(q.getSize(), 2);
    }

    @Test
    void queue_peek_test() {
        Queue st = new Queue();
        st.add(1);
        st.add(2);
        int val = st.peek();
        assertEquals(val, 1);
        assertEquals(st.getSize(), 2);
    }


    @Test
    void queue_poll_test() {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        int val = q.poll();
        assertEquals(val, 1);
        assertEquals(q.getSize(), 1);
    }

    @Test
    void queue_push_extend_test() {
        Queue q = new Queue(2);
        q.add(1);
        q.add(2);
        assertEquals(q.getCurrentCapacity(), 2);
        q.add(3);
        q.add(4);
        assertEquals(q.getSize(), 4);
        assertEquals(q.getCurrentCapacity(), 4);
    }

    @Test
    void queue_pop_extend_test() {
        Queue q = new Queue(2);
        q.add(1);
        q.add(2);
        assertEquals(q.getCurrentCapacity(), 2);
        q.poll();
        q.poll();
        assertEquals(q.getSize(), 0);
        assertEquals(q.getCurrentCapacity(), 2);
    }

    @Test
    void queue_pop_error() {
        Queue st = new Queue(2);
        assertNull(st.poll());
    }

    @Test
    void queue_pop_all_test() {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        ArrayList<Integer> temp = new ArrayList<Integer>();

        while(!q.empty()) {
            temp.add(q.poll());
        }

        assertEquals(temp.get(0), 1);
        assertEquals(temp.get(1), 2);
        assertEquals(temp.get(2), 3);
        assertEquals(temp.get(3), 4);
        assertEquals(q.getSize(), 0);
    }
}