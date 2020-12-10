package listnode.stack;

import listnode.ListNode;

import java.util.EmptyStackException;

/**
 * int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
 * void push(int data)를 구현하세요.
 * int pop()을 구현하세요.
 */
public class ListNodeStack implements StackADT {

    private int size = 0;
    private ListNode top = null;

    public ListNodeStack(){
    }

    @Override
    public void push(int data) {
        if (top == null) {
            top = new ListNode(data);
        } else {
            top = top.add(top, new ListNode(data), 1);
        }
        size++;
    }

    @Override
    public int pop() {
        if (size == 0 || top == null) {
            throw new EmptyStackException();
        } else {
            ListNode prevTop = top.remove(top, 0);
            top = prevTop.getPrev();
            size--;
            return prevTop.getValue();
        }
    }

    public int getSize() {
        return size;
    }
}
