public class Main {
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // 做两次，一次没有nums[0], 一次没有nums[len-1]
        int[] arr = new int[len + 1];
        int[] res = new int[len + 1];
        for (int i = 2; i < len + 1; i++) {
            arr[i] = nums[i - 2];
        }
        res[2] = arr[2];
        int max = arr[2];
        for (int i = 3; i < len + 1; i++) {
            res[i] = Math.max(res[i - 3] + arr[i], res[i - 2] + arr[i]);
            if (max < res[i]) {
                max = res[i];
            }
        }

        for (int i = 2; i < len + 1; i++) {
            arr[i] = nums[i - 1];
        }

        res[2] = arr[2];
        if (max < arr[2]) {
            max = arr[2];
        }
        for (int i = 3; i < len + 1; i++) {
            res[i] = Math.max(res[i - 3] + arr[i], res[i - 2] + arr[i]);
            if (max < res[i]) {
                max = res[i];
            }
        }

//        for (int i = 0; i < len + 1; i++) {
//            System.out.println(arr[i]);
//        }
        return max;
    }

    public static void main(String[] args) {
        // {2,3,2}       3
        // {1,2,3,1}     4
        // {1,2,3}       3
        int[] nums = {1,2,3};
        System.out.println(rob(nums));
    }
}
