package main;

/** TODO : toString, iteratable 구현할것 subscriptor 구현할것, null 대응할것. */

import java.util.Objects;

/** TODO :
 * nullable checd?
 * logn시간으로 줄여버리는 interpolate 방식의 문제 찾기 (sorted되어있다는 가정하에)
 * 인덱스는 그렇게 할 수 있음. 인덱스는 중
 */
public class LinkedList implements LinkedListADT {

    private class Node {
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean add(Integer value) {
        // TODO : null point exception warning.
        // 만약 첫번째일 경우.
        Node node = new Node(value);
        if (this.size == 0) {
            head = node;
            tail = node;
        } else {
            // add last의 동작을 기본으로 합니다.
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, Integer value) {
        if (index < 0 || this.size < index) {
            throw new IndexOutOfBoundsException();
        }
        Node tempNode = head;
        Node node = new Node(value);
        for (int i = 0 ; i < index ; i++) {
            tempNode = tempNode.next;
        }
        node.next = tempNode;
        if (index == 0) {
            head = node;
        }
        if (size == 0) {
            tail = node;
        }
        size++;
    }

    public int getSize() {
        return this.size;
    }

    public Integer get(int index) {
        if (index < 0 || this.size <= index) {
            throw new IndexOutOfBoundsException();
        }

        Node tempNode = head;
        for (int i = 0 ; i < index ; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.value;
    }

    public Integer getFirst() {
        return this.head.value;
    }

    public Integer getLast() {
        return this.tail.value;
    }

    @Override
    public void clear() {
        // simply dereferening all.
        head = null;
        tail = null;
        this.size = 0;
    }

    @Override
    public boolean contains(Integer value) {
        if (size == 0) {
            return false;
        } else {
            Node curr = head;
            do {
                boolean ret = Objects.equals(value, curr.value);
                if (ret) return true;
            } while((curr = curr.next) != null);
        }
        return false;
    }

    
    //https://opentutorials.org/module/1335/8857


}
