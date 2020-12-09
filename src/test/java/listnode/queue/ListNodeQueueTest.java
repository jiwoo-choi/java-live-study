package listnode.queue;

import listnode.stack.ListNodeStack;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeQueueTest {

    @Test
    void queue_init_test() {
        ListNodeQueue q = new ListNodeQueue();
        assertEquals(q.getSize(), 0);
    }

    @Test
    void queue_add_test() {
        ListNodeQueue q = new ListNodeQueue();
        q.add(1);
        q.add(2);
        assertEquals(q.getSize(), 2);
    }

    @Test
    void queue_poll_test() {
        ListNodeQueue q = new ListNodeQueue();
        q.add(1);
        q.add(2);
        int val = q.poll();
        assertEquals(val, 1);
        assertEquals(q.getSize(), 1);
    }

    @Test
    void queue_peek_test() {
        ListNodeQueue q = new ListNodeQueue();
        q.add(1);
        q.add(2);
        int val = q.peek();
        assertEquals(val, 1);
        assertEquals(q.getSize(), 2);
    }


    @Test
    void queue_pop_all_test() {
        ListNodeQueue q = new ListNodeQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        assertEquals(q.getSize(), 5);
        ArrayList<Integer> temp = new ArrayList<Integer>();

        while(!q.empty()) {
            temp.add(q.poll());
        }

        assertEquals(temp.get(0), 1);
        assertEquals(temp.get(1), 2);
        assertEquals(temp.get(2), 3);
        assertEquals(temp.get(3), 4);
        assertEquals(temp.get(4), 5);
        assertEquals(q.getSize(), 0);
    }

    @Test
    void queue_pop_error() {
        ListNodeQueue q = new ListNodeQueue();
        assertNull(q.poll());
    }
}