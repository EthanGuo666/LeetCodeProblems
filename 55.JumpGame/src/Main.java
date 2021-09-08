public class Main {
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        int step = nums[0];
        int p = 0;
        while (step >= 0) {
            if (p == len - 1) {
                return true;
            }
            if (step < nums[p]) {
                step = nums[p];
            }
            step--;
            p++;
        }
        return false;
    }

    public static void main(String[] args) {
        // {0}          true
        // {0,1}        false
        // {3,2,1,0,4}  false
        // {2,3,1,1,4}  true
        // {1,2}        true
        // {1,0,2}      false
        // {1,2,3}      true
        int[] nums = {1,2,3};
        System.out.println(canJump(nums));
    }
}
