public class Main {
    public static int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        int d = nums[1] - nums[0];
        int temp = 0;
        int result = 0;
        for (int i = 2; i < len; ++i) {
            if (nums[i] - nums[i - 1] == d) {
                temp++;
            } else {
                d = nums[i] - nums[i - 1];
                temp = 0;
            }
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        // {1,2,3,4}   3
        int[] nums = {1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(nums));
    }
}
