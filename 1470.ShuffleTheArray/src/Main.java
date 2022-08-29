import java.util.Arrays;

public class Main {
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int j = 0;
        for (int i = 0; i < n; i++) {
            res[j] = nums[i];
            res[j + 1] = nums[n + i];
            j += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 4, 6};
        int n = 3;
        System.out.println(Arrays.toString(shuffle(nums, n)));
    }
}
