public class Main {
    public static int maxSubArray(int[] nums) {
        int preSum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            maxSum = Math.max(preSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(numbers));
    }
}
