public class Main {
    static int result;

    public static void dfs(TreeNode root, int curSum, int targetSum) {
        if (root == null) {
            return;
        }
        if (curSum + root.val == targetSum) {
            result ++;
        }
        dfs(root.left, curSum+root.val, targetSum);
        dfs(root.right, curSum+root.val, targetSum);
        dfs(root.left, 0, targetSum);
        dfs(root.right, 0, targetSum);
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        result = 0;
        dfs(root, 0, targetSum);
        return result;
    }

    public static void main(String[] args) {
        TreeNode right = new TreeNode(2, null, new TreeNode(3));
        TreeNode root = new TreeNode(1, null, right);
        System.out.println(pathSum(root, 3));
    }
}
