package tree;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Node {

    protected Node left = null;
    protected Node right = null;
    private Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}


