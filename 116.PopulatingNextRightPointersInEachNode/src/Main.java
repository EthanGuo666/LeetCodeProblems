import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> level = new LinkedList<>();
        level.offer(root);
        while (!level.isEmpty()) {
            int len = level.size();
            for (int i = 0; i < len; i++) {
                Node node = level.poll();
                if (i < len - 1) {
                    node.next = level.peek();
                }
                if (node.left != null) {
                    level.offer(node.left);
                }
                if (node.right != null) {
                    level.offer(node.right);
                }
            }
        }
        return root;
    }
}
