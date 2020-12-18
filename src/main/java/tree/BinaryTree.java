package tree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class BinaryTree implements TreeIterable {

    public Node root;
    /// 순회 엔진을 선택합니다. `IterativeTraversal` 과 `RecursiveTraversal` 이 있습니다.
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

    /**
     * 바이너리 트리의 루트를 기준으로 깊이 탐색 방식으로 순회합니다.
     * @return 순회 결과를 String으로 출력합니다.
     */
    @Override
    public String dfs() {
        return this.dfs(root);
    }

    /**
     * 특정 노드를 기준으로 그 노드 아래에 있는 깊이 탐색 방식으로 노드들을 순회합니다.
     * @param node 지정한 특정 노드.
     * @return 순회 결과를 String으로 출력합니다.
     */
    @Override
    public String dfs(Node node) {
        if (node == null) {
            throw new NoSuchElementException("A given node should not be null.");
        } else {
            return switch (this.mode) {
                case IN_ORDER   -> this.engine.doByInorder(node);
                case PRE_ORDER  -> this.engine.doByPreorder(node);
                case POST_ORDER -> this.engine.doByPostOrder(node);
            };
        }
    }

    /**
     * 루트를 기준으로 각 레벨별로 너비 탐색 방식으로 순회합니다.
     * @return 결과를 String으로 만들어 보냅니다.
     */
    @Override
    public String bfs() {
        return this.bfs(root);
    }

    /**
     * 특정 노드를 기준으로 그 노드 아래에 있는 너비 탐색 방식으로 노드들을 순회합니다.
     * @param node 지정한 특정 노드.
     * @return 순회 결과를 String으로 출력합니다.
     */
    @Override
    public String bfs(Node node) {
        if (node == null) {
            throw new NoSuchElementException("A given node should not be null.");
        } else {
            return this.engine.doByLevel(node);
        }
    }


    /**
     * @return dfs 방식으로 순회한 결과에 해당하는 iterator
     */
    @Override
    public Iterator<Integer> iterator() {
        if (root == null) {
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
        } else {
            String result = switch (this.mode) {
                case IN_ORDER   -> this.engine.doByInorder(this.root);
                case PRE_ORDER  -> this.engine.doByPreorder(this.root);
                case POST_ORDER -> this.engine.doByPostOrder(this.root);
            };

            return Arrays.stream(result.split("\\s")).filter( p -> { return !p.equals("");}).map(Integer::parseInt).iterator();
        }

    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Objects.requireNonNull(action);
        for (Integer t : this) {
            action.accept(t);
        }
    }
}
