import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static HashMap<String, Integer> count;
    private static List<TreeNode> result;

    // return the value series of this node
    public static String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }
        String curStr = String.valueOf(root.val);
        String l = dfs(root.left), r = dfs(root.right);
        curStr += "-" + l + "-" + r;
        count.put(curStr, count.getOrDefault(curStr, 0) + 1);
        if (count.get(curStr) == 2) {
            result.add(root);
        }
        return curStr;
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        result = new ArrayList<>();
        dfs(root);
        System.out.println(count.toString());
        return result;
    }

    public static void main(String[] args) {
        TreeNode l = new TreeNode(2, new TreeNode(3), null);
        TreeNode r = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(2, l, r);
        findDuplicateSubtrees(root);
    }
}
