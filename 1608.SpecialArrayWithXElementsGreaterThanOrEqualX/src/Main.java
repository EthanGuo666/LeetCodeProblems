import java.util.Arrays;

public class Main {
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int mid = nums[j];
            nums[j] = nums[i];
            nums[i] = mid;
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {5, 3};
//        int[] nums = {0, 4, 3, 0, 4};
        int[] nums = {3, 6, 7, 7, 0};
        System.out.println(specialArray(nums));
    }
}
