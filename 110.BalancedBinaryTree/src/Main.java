public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(getDepth(root.left), getDepth(root.right));
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {

    }
}
