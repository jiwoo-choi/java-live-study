package tree;

public interface TreeIterable extends Iterable<Integer> {
    String dfs();
    String dfs(Node node);
    String bfs();
    String bfs(Node node);
}
