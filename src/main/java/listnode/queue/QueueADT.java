package listnode.queue;

public interface QueueADT {
    void add(int data);
    Integer peek();
    Integer poll();
    boolean empty();
    int getSize();
}

