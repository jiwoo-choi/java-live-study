package tree;

import java.util.LinkedList;
import java.util.Queue;

public abstract class TraversalEngine {

    abstract String doByInorder(Node root);
    abstract String doByPostOrder(Node root);
    abstract String doByPreorder(Node root);

    String doByLevel(Node root) {
        String ret = "";
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()) {
            Node cq = q.poll();
            ret += cq.getValue() + " ";
            if (cq.left != null) q.add(cq.left);
            if (cq.right != null) q.add(cq.right);
        }
        return ret;
    }
}
