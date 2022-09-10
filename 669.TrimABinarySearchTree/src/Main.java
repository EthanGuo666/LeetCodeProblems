public class Main {
    public static TreeNode printTree(TreeNode root) {
        if (root == null) {
            System.out.printf("null ");
            return null;
        }
        System.out.printf(root.val + " ");
        printTree(root.left);
        printTree(root.right);
        return root;
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // now root.val is between [low, high]
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        TreeNode l = new TreeNode(0, null, null);
        TreeNode r = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1, l, r);
        trimBST(root, 1, 2);
        printTree(root);
    }
}
