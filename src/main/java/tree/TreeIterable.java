package tree;

public interface TreeIterable extends Iterable<Integer> {
    void dfs();
    void dfs(Node node);
    void bfs();
    void bfs(Node node);
}
