public class Main {
    public static int Max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static int Min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static int maxProduct(int[] nums) {
        int preMax = 1, preMin = 1, ans = nums[0];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int mx = preMax, mn = preMin;
            preMax = Max(nums[i], mx * nums[i], mn * nums[i]);
            preMin = Min(nums[i], mx * nums[i], mn * nums[i]);
            ans = Math.max(preMax, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        // {2,3,-2,4}    6
        // {-2,0,-1}     0
        // {0,0,0}       0
        // {1}           1
        // {-2,3,2,-4}  48
        // {-1,-2,-4}    8
        int[] nums = {-1, -2, -4};
        System.out.println(maxProduct(nums));
    }
}
