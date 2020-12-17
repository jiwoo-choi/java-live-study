package tree;

public class RecursiveTraversal extends TraversalEngine {

    @Override
    void doByInorder(Node root) {
        if (root == null) return;
        doByInorder(root.left);
        doByInorder(root.right);

    }

    @Override
    void doByPostOrder(Node root) {
        if (root == null) return;
        doByPostOrder(root.left);
        doByPostOrder(root.right);
        System.out.println(root.getValue());
    }

    @Override
    void doByPreorder(Node root) {
        if (root == null) return;
        doByPreorder(root.left);
        doByPreorder(root.right);
        System.out.println(root.getValue());

    }
}
