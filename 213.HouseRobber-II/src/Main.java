public class Main {
    public static int find(int[] copy, int len) {
        int[] ans = new int[len + 2];
        int max = 0;
        for (int i = 2; i < len + 1; i++) {
            ans[i] = Math.max(ans[i - 1], copy[i] + ans[i - 2]);
            max = Math.max(max, ans[i]);
        }
        return max;
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 因为第一个和最后一个元素不可能同时出现，那就分别跑两次最后取最大值
        int[] copy = new int[len + 1];
        // 从nums数组第一个元素开始复制，到nums倒数第二个 （相当于跳过最后一个）
        for (int i = 2; i < len + 1; i++) {
            copy[i] = nums[i - 2];
        }
        int max = find(copy, len);

        // 从nums数组第二个元素开始复制，到最后一个 （相当于跳过第一个）
        for (int i = 2; i < len + 1; i++) {
            copy[i] = nums[i - 1];
        }
        max = Math.max(max, find(copy, len));
        return max;
    }

    public static void main(String[] args) {

    }
}
