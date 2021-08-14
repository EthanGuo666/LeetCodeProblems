public class Main {
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        int max = nums[0];
        for (int i = 0; i < len - 1; i = max) {
            if (nums[i] == 0) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
            for (int j = i; j < max; j++) {
                if (j < len) {
                    max = Math.max(max, nums[j] + j);
                } else {
                    return true;
                }
            }
        }
        return max >= len - 1;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(canJump(nums));
    }
}
