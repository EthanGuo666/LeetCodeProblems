import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    List<TreeNode> list = new ArrayList<>();

    public void preOrder(TreeNode root, List<TreeNode> List) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public void flatten(TreeNode root) {
        preOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode t = list.get(i - 1);
            TreeNode next = list.get(i);
            t.left = null;
            t.right = next;
        }
    }

    public static void main(String[] args) {

    }
}
