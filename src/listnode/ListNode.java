package listnode;

import java.util.NoSuchElementException;
import java.util.Objects;

public class ListNode implements ListADT<ListNode>{

    private ListNode next = null;

    public ListNode getHead() {
        return head;
    }

    private ListNode head = null;
    private Integer value = null;

    public ListNode getNext() {
        return next;
    }

    public Integer getValue() {
        return value;
    }

    public ListNode(Integer value) {
        this.value = value;
    }

    /**
     * insert a node at given position. (at position - 1)
     * @param head begining node.
     * @param nodeToAdd node object to insert.
     * @param position position to insert node.
     * @return return head (the first) node.
     * @throws IndexOutOfBoundsException if position is not valid (negative values).
     */
    @Override
    public ListNode add(ListNode head, ListNode nodeToAdd, int position) throws IndexOutOfBoundsException {
        if ( position < 0 ) {
            throw new IndexOutOfBoundsException();
        } else if (position == 0) {
            nodeToAdd.next = head;
            return nodeToAdd;
        } else {
            ListNode curr = head;
//            nodeToAdd.head = head.getHead();
            int cursor = 0;
            do {
                if (cursor == position - 1) {
                    nodeToAdd.next = curr.next;
                    curr.next = nodeToAdd;
                    return head;
                }
                cursor++;
            } while ((curr = curr.next) != null);
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * remove a node at given position. (at position - 1)
     * @param head begining node.
     * @param positionToRemove position to revmoe a node.
     * @return return head (the first) node.
     * @throws IndexOutOfBoundsException if position is not valid (negative values).
     */
    @Override
    public ListNode remove(ListNode head, int positionToRemove) throws NoSuchElementException {
        if (positionToRemove < 0) {
            throw new NoSuchElementException();
        } else if (positionToRemove == 0){
            head = head.next;
            return head;
        } else {
            ListNode curr = head;
            int cursor = 0;
            do {
                if (cursor == positionToRemove - 1) {
                    curr.next = curr.next.next;  // 어떻게처리할것인가
                    return head;
                }
                cursor++;
            } while ((curr = curr.next) != null);
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean contains(ListNode head, ListNode nodeTocheck) {
        ListNode curr = head;
        do {
            if (Objects.equals(curr,nodeTocheck)) {
                return true;
            }
        } while ((curr = curr.next) != null);
        return false;
    }
}
