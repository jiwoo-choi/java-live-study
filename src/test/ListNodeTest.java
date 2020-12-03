package test;
import listnode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    void getValue() {
    }

    @Test
    void add_functional_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode returned = head.add(head, node2, 0);
        assertEquals(2, returned.getValue());
        assertEquals(1, returned.getNext().getValue());
    }

    @Test
    void add_outof_index_error_throw_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        try {
            head.add(head, node2, 2);
            fail("expected : IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        } catch (Exception e) {
            fail("expected : IndexOutOfBoundsException");
        }
    }
    @Test
    void add_negative_value_error_throw_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        try {
            head.add(head, node2, -1);
            fail("expected : IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        } catch (Exception e) {
            fail("expected : IndexOutOfBoundsException");
        }
    }

    @Test
    void add_multiple_nodes_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head = head.add(head, node2, 0);
        head = head.add(head, node3, 0);
        head = head.add(head, node4, 0);
        head = head.add(head, node5, 0);

        assertEquals(5,head.getValue());
        assertEquals(4,head.getNext().getValue());
        assertEquals(3,head.getNext().getNext().getValue());
        assertEquals(2,head.getNext().getNext().getNext().getValue());
        assertEquals(1,head.getNext().getNext().getNext().getNext().getValue());
        assertNull(head.getNext().getNext().getNext().getNext().getNext());
    }

    @Test
    void add_multiple_nodes_with_different_position_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        // [1]
        // [2] -> [1]
        // [2] -> [3] -> [1]

        // [2] -> [3] -> [4] -> [5] -> [1]
        head = head.add(head, node2, 0);
        head = head.add(head, node3, 1);
        head = head.add(head, node4, 2);
        head = head.add(head, node5, 3);

        assertEquals(2,head.getValue());
        assertEquals(3,head.getNext().getValue());
        assertEquals(4,head.getNext().getNext().getValue());
        assertEquals(5,head.getNext().getNext().getNext().getValue());
        assertEquals(1,head.getNext().getNext().getNext().getNext().getValue());
    }




    @Test
    void remove_single_element_functional_test() {
        ListNode head = new ListNode(1);
        head = head.remove(head, 0);
        assertNull(head);
    }

    @Test
    void remove_multiple_element_functional_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head = head.add(head, node2, 1);
        head = head.add(head, node3, 2);
        head = head.add(head, node4, 3);
        head = head.remove(head, 0);
        assertEquals(2, head.getValue());
    }

    @Test
    void remove_multiple_element_different_position_functional_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head = head.add(head, node2, 1);
        head = head.add(head, node3, 2);
        head = head.add(head, node4, 3); // [1] -> [2] -> [3] -> [4]
        head = head.remove(head, 0);  // [2] -> [3] -> [4]
        head = head.remove(head, 1);  // [2] -> [4]
        assertEquals(2, head.getValue());
        assertEquals(4, head.getNext().getValue());
        head = head.remove(head, 1);
        assertEquals(2, head.getValue()); // [2] -> null
        assertNull(head.getNext());
    }


    @Test
    void remove_negative_index_test() {
        ListNode head = new ListNode(1);
        try {
            head = head.remove(head, -1);
            fail("Expected : NoSuchElementException");
        } catch ( NoSuchElementException e ) {
        } catch (Exception e) {
            fail("Expected : NoSuchElementException");
        }
    }


    @Test
    void remove_out_of_bound_index_test() {
        ListNode head = new ListNode(1);
        try {
            head = head.remove(head, 2);
            fail("Expected : NoSuchElementException");
        } catch ( NoSuchElementException e ) {
        } catch (Exception e) {
            fail("Expected : NoSuchElementException");
        }
    }


    @Test
    void contains_true_functional_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);

        head = head.add(head, node2, 1);
        head = head.add(head, node3, 2);
        assertTrue(head.contains(head, node2));
        head.remove(head,1);
        assertFalse(head.contains(head,node2));
    }

    @Test
    void contains_false_functional_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        assertFalse(head.contains(head, node2));
        assertFalse(head.contains(head,node3));
    }

}