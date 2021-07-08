import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public static TreeNode buildTree(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }
        int midTerm = (end + start) / 2;
        TreeNode root = new TreeNode(nums[midTerm]);
        root.left = buildTree(nums, start, midTerm - 1);
        root.right = buildTree(nums, midTerm + 1, end);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public static void traverse(TreeNode r) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<String> printQueue = new LinkedList<>();
        treeNodeQueue.offer(r);
        printQueue.offer(String.valueOf(r.val));

        while (!treeNodeQueue.isEmpty()) {
            TreeNode t = treeNodeQueue.poll();
            if (t.left != null) {
                treeNodeQueue.offer(t.left);
                printQueue.offer(String.valueOf(t.left.val));
            } else {
                printQueue.offer("null");
            }
            if (t.right != null) {
                treeNodeQueue.offer(t.right);
                printQueue.offer(String.valueOf(t.right.val));
            } else {
                printQueue.offer("null");
            }
        }

        while (!printQueue.isEmpty()) {
            String str = printQueue.poll();
            System.out.printf(str+", ");
        }
    }

    public static void main(String[] args) {
        int[] numbers = {-10, -3, 0, 5, 9};

        traverse(sortedArrayToBST(numbers));

    }
}
