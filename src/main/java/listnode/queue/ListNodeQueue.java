package listnode.queue;

import listnode.ListNode;

public class ListNodeQueue implements QueueADT {

    private int size = 0;
    private ListNode head = null;
    private ListNode tail = null;

    public ListNodeQueue(){
    }

    @Override
    public void add(int data) {
        if (head == null) {
            head = new ListNode(data);
            tail = head;
        } else {
            tail = tail.add(tail, new ListNode(data), 1);
        }
        size++;
    }

    @Override
    public Integer peek() {
        if (head == null) return null;
        return head.getValue();
    }

    @Override
    public Integer poll() {
        if (head == null) return null;
        ListNode prevHead = head.remove(head,0);
        head = prevHead.getNext();
        size--;
        return prevHead.getValue();
    }

    @Override
    public boolean empty() {
        return this.size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
