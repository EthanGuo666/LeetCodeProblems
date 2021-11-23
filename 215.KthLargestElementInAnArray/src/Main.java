import java.util.Arrays;

public class Main {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k];
    }

    public static void main(String[] args) {

    }
}
