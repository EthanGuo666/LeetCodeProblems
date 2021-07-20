import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> arr = new LinkedList<>();
        if (end < start) {
            arr.add(null);
            return arr;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = buildTree(start, i - 1);
            List<TreeNode> rightTrees = buildTree(i + 1, end);
            for (TreeNode lt : leftTrees) {
                for (TreeNode rt : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    arr.add(root);
                }
            }
        }
        return arr;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return buildTree(1, n);
    }

    public static void main(String[] args) {
//        generateTrees(1);
    }
}
