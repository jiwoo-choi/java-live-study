package tree;

import java.util.ArrayList;

public class RecursiveTraversal extends TraversalEngine {

    @Override
    String doByInorder(Node root) {
        //String
        if (root == null) return "";
        String ret = "";
        ret += doByInorder(root.left);
        ret += root.getValue() + " ";
        ret += doByInorder(root.right);
        return ret;
    }

    @Override
    String doByPostOrder(Node root) {
        if (root == null) return "";
        String ret = "";
        ret += doByPostOrder(root.left);
        ret += doByPostOrder(root.right);
        ret += root.getValue() + " ";
        return ret;
    }

    @Override
    String doByPreorder(Node root) {
        if (root == null) return "";
        String ret = "";
        ret += root.getValue() + " ";
        ret += doByPreorder(root.left);
        ret += doByPreorder(root.right);
        return ret;
    }
}
