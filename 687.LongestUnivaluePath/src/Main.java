public class Main {
    static int result = 0;

    public static int longestUnivaluePath(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int left1 = 0, right1 = 0;
        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        result = Math.max(result, left1 + right1);
        return Math.max(left1, right1);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(4, new TreeNode(4), new TreeNode(4));
        TreeNode right = new TreeNode(5, null, new TreeNode(5));
        TreeNode r = new TreeNode(1, left, right);
        System.out.println(longestUnivaluePath(r));
    }
}
