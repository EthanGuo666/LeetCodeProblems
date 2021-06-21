public class Main {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static boolean checkVal(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return checkVal(p.left, q.right) && checkVal(p.right, q.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkVal(root.left, root.right);
    }

    public static void main(String[] args) {
        // Input: root = [1,2,2,3,4,4,3]
        // Output: true

        // Input: root = [1,2,2,null,3,null,3]
        // Output: false
    }
}
