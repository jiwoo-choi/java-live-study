package listnode;
/** TODO : toString, iteratable 구현할것 subscriptor 구현할것, null 대응할것. */

import java.util.*;
import java.util.function.Consumer;
/** TODO :
 * nullable checd?
 * logn시간으로 줄여버리는 interpolate 방식의 문제 찾기 (sorted되어있다는 가정하에)
 * 인덱스는 그렇게 할 수 있음. 인덱스는 중
 *
 *
 * 네임스페이스가 바뀌었음. 이거메이븐처리
 */

public class LinkedList implements LinkedListADT {

    /**
     * 이터레이터 사용을 위해 만든 이터레이터 클래스.
     */

    private class Itr implements Iterator<Integer> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != getSize();
        }

        @Override
        public Integer next() {
            try {
                int i = cursor;
                Integer next = get(i);
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Itr();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
//        Objects.requireNonNull(action);
        for (Integer val : this) {
            action.accept(val);
        }
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return null;
    }

    private class Node {
        private Integer value;
        private Node next;
        private Node prev;

        public Node(Integer value) {
            this.value = value;
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
            node.prev = tail;
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
        } else {
            tempNode.prev = node;
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
        if (size == 0) throw new NoSuchElementException();
        return this.head.value;
    }

    public Integer getLast() {
        if (size == 0) throw new NoSuchElementException();
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
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Integer value) {
        if (size == 0) {
            return -1;
        } else {
            int cursor = 0;
            Node curr = head;
            do {
                boolean ret = Objects.equals(value, curr.value);
                if (ret) return cursor;
                cursor++;
            } while((curr = curr.next) != null);
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer value) {
        if (size == 0) {
            return -1;
        } else {
            int cursor = size - 1;
            Node curr = tail;
            do {
                boolean ret = Objects.equals(value, curr.value);
                if (ret) return cursor;
                cursor++;
            } while((curr = curr.next) != null);
        }
        return -1;
    }

    @Override
    public Integer remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else if ( size == 1) {
            Integer ret = tail.value;
            tail = null;
            head = null;
            this.size = 0;
            return ret;
        } else {
            Integer ret = tail.value;
            tail = tail.prev;
            tail.next = null;
            this.size--;
            return ret;
        }
    }

    // 노드정보얻는 로직 추가.
    private Node getNodeAt(int index) {
        if (size == 0) {
            throw new NoSuchElementException();
        } else if ( index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException();
        } else {
            int cursor = 0;
            Node curr = head;
            for (int i = 0 ; i < index; i++) {
                curr = curr.next;
            }
            return curr;
        }
    }
    // s노드정보얻기.
    @Override
    public Integer remove(int index) {
        Node node = getNodeAt(index);
        // 앞쪽 노드 제거.
        if (size == 1) {
            clear();
        } else {
            if (node.prev == null) {
                node.next.prev = null;
                head = node.next;
            } else {
                node.prev.next = node;
                node.prev.next = node.next;
            }
        }
        return node.value;
    }

    @Override
    public boolean remove(Integer value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }
    }

    @Override
    public Integer removeFirst() {
        return remove(0);
    }


    //https://opentutorials.org/module/1335/8857


}
