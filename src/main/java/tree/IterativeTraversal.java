package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IterativeTraversal extends TraversalEngine {

    @Override
    String doByInorder(Node root) {
        String ret = "";
        Stack<Node> st = new Stack<Node>();
        Node currentNode = root;
        while(!st.empty() || currentNode != null) {
            while(currentNode != null) {
                st.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = st.peek();
            st.pop();
            ret += currentNode.getValue() + " ";
            currentNode = currentNode.right;
        }
        return ret;
    }

    @Override
    String doByPreorder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        Stack<Node> st = new Stack<Node>();
        String ret = "";
        Node currentNode = root;

        while(currentNode != null) {

            while (currentNode != null) {
                q.add(currentNode);
                currentNode = currentNode.left;
            }

            while (!q.isEmpty()) {
                Node temp = q.poll();
                if (temp == null) continue;
                ret += temp.getValue() + " ";
                if (temp.right == null) continue;
                st.push(temp.right);
            }

            if (st.empty()) {
                currentNode = null;
            } else {
                currentNode = st.pop();
            }
        }
        return ret;
    }

    @Override
    String doByPostOrder(Node root) {
        String ret = "";
        Stack<Node> st = new Stack<Node>();
        Node currentNode = root;
        while(!st.empty() || currentNode != null) {

            while(currentNode != null) {
                st.push(currentNode);
                currentNode = currentNode.left;
            }

            Node temp = st.peek(); // 마지막으로 제거된 노드를 기억하는 변수.
            while(!st.empty() && ((currentNode = st.peek()).right == null || temp == st.peek().right)) {
                ret += currentNode.getValue() + " ";
                temp = currentNode;
                st.pop();
            }

            // 만약 여기서 모두 제거되었으면, 끝났다는 의미이므로 탈출.
            if (st.empty()) {
                break;
            } else {
                currentNode = currentNode.right;
            }
        }
        return ret;
    }
}
