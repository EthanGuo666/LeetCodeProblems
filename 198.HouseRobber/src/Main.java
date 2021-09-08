public class Main {
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] arr = new int[len + 2];
        int[] result = new int[len + 2];
        for (int i = 2; i < len + 2; i++) {
            arr[i] = nums[i - 2];
        }
        result[1] = 0;
        result[2] = arr[2];
        int max = arr[2];
        for (int i = 3; i < len + 2; i++) {
            result[i] = Math.max(result[i - 3] + arr[i], result[i - 2] + arr[i]);
            if (max < result[i]) {
                max = result[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // {1,2,3,1}   4
        // {1,3,1}     3
        // {1,2}       2
        // {2,1}       2
        // {1,7,9,2}  10
        // {0}         0
        int[] nums = {1};
        System.out.println(rob(nums));
    }
}
