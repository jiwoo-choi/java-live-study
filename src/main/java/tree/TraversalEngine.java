package tree;

import java.util.LinkedList;
import java.util.Queue;

public abstract class TraversalEngine {

    abstract void doByInorder(Node root);
    abstract void doByPostOrder(Node root);
    abstract void doByPreorder(Node root);

    void doByLevel(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()) {
            Node cq = q.poll();
            System.out.println(cq.getValue());
            if (cq.left != null) q.add(cq.left);
            if (cq.right != null) q.add(cq.right);
        }
    }
}
