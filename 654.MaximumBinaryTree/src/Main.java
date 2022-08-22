import java.util.Arrays;

public class Main {
    public static int findMaxIndex(int[] nums) {
        int max = -1;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int maxIndex = findMaxIndex(nums);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex+1, nums.length));
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        int[] ss = Arrays.copyOfRange(nums, 0, 3);
        System.out.println(Arrays.toString(ss));
    }
}
