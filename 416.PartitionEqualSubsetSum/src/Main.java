import java.util.Arrays;

public class Main {
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len < 2) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        boolean[][] dp = new boolean[len + 1][target + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][target];
    }

    public static void main(String[] args) {
        // int[] nums = {1, 2, 3, 5};
        // int[] nums = {1, 5, 11, 5};
//        int[] nums = {9, 5};   false
        int[] nums = {3, 4, 7};  // true
        System.out.println(canPartition(nums));
    }
}
