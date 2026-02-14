import java.util.Arrays;
import java.util.function.Function;

public class Main {
    static int[] vis;

    public static

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        vis = new int[n];
        Arrays.fill(vis, 0);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int quo = sum / k;
        int res = sum % k;
        if (res != 0) {
            return false;
        }
        Arrays.sort(nums);

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 2};
        int k = 2;
        System.out.println(canPartitionKSubsets(nums, k));
    }
}
