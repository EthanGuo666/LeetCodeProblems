public class Main {
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] copyNums = new int[len + 3];
        for (int i = 3; i < len + 3; i++) {
            copyNums[i] = nums[i - 3];
        }
        int[] ans = new int[len + 3];
        int max = 0;
        for (int i = 3; i < len + 3; i++) {
            ans[i] = Math.max(copyNums[i] + ans[i - 2], copyNums[i] + ans[i - 3]);
            max = Math.max(ans[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        // {1,2,3,1}   4
        // {1,3,1}     3
        // {1,2}       2
        // {1,7,9,2}  10
        // {0}         0
        int[] nums = {0};
        System.out.println(rob(nums));
    }
}
