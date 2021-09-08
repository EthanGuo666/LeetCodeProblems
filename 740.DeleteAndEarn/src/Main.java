public class Main {
    public static int deleteAndEarn(int[] nums) {
        int numsMax = -1;
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        for (int i = 0; i < len; i++) {
            if (numsMax < nums[i]) {
                numsMax = nums[i];
            }
        }
        int[] arr = new int[numsMax + 2];
        int[] res = new int[numsMax + 2];
        // 把相同数的求和，存在对应下标+1的位置
        for (int i = 0; i < len; i++) {
            arr[nums[i] + 1] += nums[i];
        }
        res[2] = arr[2];
        int max = res[2];
        for (int i = 3; i < numsMax + 2; i++) {
            res[i] = Math.max(res[i - 2] + arr[i], res[i - 3] + arr[i]);
            if (max < res[i]) {
                max = res[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // {1,1,1,1,2}     4
        // {1,2}           2
        // {1,3}           4
        // {1,4}           5
        // {2,2,3,3,3,4}   9
        int[] nums = {2,2,3,3,3,4};
        //deleteAndEarn(nums);
        System.out.println(deleteAndEarn(nums));
    }
}
