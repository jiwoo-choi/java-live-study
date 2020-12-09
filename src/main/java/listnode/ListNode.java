package listnode;

import java.util.Objects;

public class ListNode {

    /// Stack을 위해 추가된 기능입니다.
    private ListNode prev = null;

    private ListNode next = null;
    private Integer value = null;

    public ListNode getPrev() { return prev; }
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
     * @param head begining position.
     * @param nodeToAdd a node object to insert.
     * @param position the position to insert node.
     * @return null if it is invalid position, or return the new node.
     */
    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if ( position < 0 ) {
            return null;
        } else if (position == 0) {
            nodeToAdd.next = head;
            head.prev = nodeToAdd;
            return nodeToAdd;
        } else {
            ListNode curr = head;
            int cursor = 0;
            do {
                if (cursor == position - 1) {
                    // [0] <-> [1]
                    // [0] <-> [new] <-> [1]
                    if (curr.next != null) {
                        curr.next.prev = nodeToAdd;
                    }
                    nodeToAdd.next = curr.next;
                    nodeToAdd.prev = curr;
                    curr.next = nodeToAdd;
                    return nodeToAdd;
                }
                cursor++;
            } while ((curr = curr.next) != null);
        }
        return null;
    }

    /**
     * remove a node at given position. (at position - 1)
     * @param head begining node.
     * @param positionToRemove position to revmoe a node.
     * @return null if it is invalid position, or return the removed node.
     */
    public ListNode remove(ListNode head, int positionToRemove) {
        if (positionToRemove < 0) {
            return null;
        } else if (positionToRemove == 0){
            ListNode ret = head;
            head = head.next;
            return ret;
        } else {
            ListNode curr = head;
            int cursor = 0;
            do {
                if (cursor == positionToRemove - 1) {
                    ListNode ret = curr.next;
                    if (ret == null) return ret;
                    curr.next.prev = curr;
                    curr.next = curr.next.next;
                    return ret;
                }
                cursor++;
            } while ((curr = curr.next) != null);
        }
        return null;
    }

    public boolean contains(ListNode head, ListNode nodeTocheck) {
        ListNode curr = head;
        while ((curr = curr.next) != null) {
            if (Objects.equals(curr, nodeTocheck)) return true;
        }
        return false;
    }
}
