public class Main {
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return new int[]{-1, -1};
        int left = 0, right = len - 1;
        while (left <= right) {
            if (nums[left] == target && nums[right] == target) {
                break;
            }
            if (nums[left] != target) {
                left++;
            }
            if (nums[right] != target) {
                right--;
            }
        }

        if (right < left) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;   // 3,4

//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 6; // -1, -1

//        int[] nums = {};
//        int target = 6; // -1, -1

//        int[] nums = {1};
//        int target = 1; // 0

//        int[] nums = {1};
//        int target = 0; // -1, -1

        int[] result = searchRange(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.printf(" " + result[i]);
        }
    }
}
