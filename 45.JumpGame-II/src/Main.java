public class Main {
    public static int jump(int[] nums) {
        int len = nums.length;
        int steps = 0;
        int maxPos = 0;
        // 用一个end指向跳变末尾
        int end = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        // {1}               0
        // {1,2}             1
        // {2,1}             1
        // {1,2,3}           2
        // {2,2,3,1,2}       2
        // {1,1,1,1,1}       4
        // {2,3,0,1,4}       2
        // {1,2,0,1}         2
        // {1,1,2,1,1}       3
        int[] nums = {1, 1, 2, 1, 1};
        System.out.println(jump(nums));
    }
}
