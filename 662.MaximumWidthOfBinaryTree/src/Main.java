import java.util.ArrayDeque;
import java.util.HashMap;

public class Main {
    static int result = 0;
    static HashMap<Integer, Integer> firstElementPos = new HashMap<>();

    public static void dfs(TreeNode root, int indexNum, int levelNum) {
        if (root == null) return;
        firstElementPos.putIfAbsent(levelNum, indexNum);
        result = Math.max(result, indexNum - firstElementPos.get(levelNum) + 1);
        dfs(root.left, indexNum * 2, levelNum + 1);
        dfs(root.right, indexNum * 2 + 1, levelNum + 1);
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        dfs(root, 1, 0);
        return result;
    }

    public static void main(String[] args) {
//        TreeNode left = new TreeNode(3,
//                new TreeNode(5, null, null),
//                new TreeNode(3, null, null)
//        );
//        TreeNode right = new TreeNode(2,
//                null,
//                new TreeNode(9, null, null)
//        );
        TreeNode left = new TreeNode(3,
                new TreeNode(5, null, null),
                null
        );
        TreeNode right = new TreeNode(2,
                null,
                null
        );
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(widthOfBinaryTree(root));
    }
}
