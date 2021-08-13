public class Main {
    public static int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        // 这里非常巧妙地用数组下标i来记录所有数字i相加的和
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] ans = new int[len];
        ans[0] = 0;
        ans[1] = nums[1];
        int max = nums[1];
        for (int i = 2; i < len; i++) {
            ans[i] = Math.max(ans[i - 2] + nums[i], ans[i - 1]);
            max = Math.max(max, ans[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 5, 4};
        //deleteAndEarn(nums);
        System.out.println(deleteAndEarn(nums));
    }
}
