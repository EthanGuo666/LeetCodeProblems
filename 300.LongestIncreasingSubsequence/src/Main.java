public class Main {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18}; //4
//        int[] nums = {0,1,0,3,2,3}; //4
//        int[] nums = {7,7,7,7,7,7,7}; //0
//        int[] nums = {3}; //1
        int[] nums = {4,3,2,1}; //1

        System.out.println(lengthOfLIS(nums));
    }
}
