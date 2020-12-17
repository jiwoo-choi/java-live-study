package tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class BinaryTree implements TreeIterable {

    /// Root
    public Node root;
    private TraversalEngine engine;
    private TraversalMode mode = TraversalMode.IN_ORDER;

    public BinaryTree() {
        this.engine = new RecursiveTraversal();
    }

    public BinaryTree(TraversalEngine engine) {
        this.engine = engine;
    }

    public void setMode(TraversalMode mode) {
        this.mode = mode;
    }

    public void setEngine(TraversalEngine engine) {
        this.engine = engine;
    }

    @Override
    public void dfs() {
        this.dfs(root);
    }

    @Override
    public void dfs(Node node) {
        if (node == null) {
            throw new NoSuchElementException("Node is null.");
        } else {
            switch (this.mode) {
                case IN_ORDER   -> this.engine.doByInorder(node);
                case PRE_ORDER  -> this.engine.doByPreorder(node);
                case POST_ORDER -> this.engine.doByPostOrder(node);
            };
        }
    }

    @Override
    public void bfs() {
        this.bfs(root);
    }

    @Override
    public void bfs(Node node) {
        if (node == null) {
            throw new NoSuchElementException("Node is null.");
        } else {
            this.engine.doByLevel(node);
        }
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
    }
}
