public class Main {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] arr = new int[len + 2];
        int[] res = new int[len + 2];
        for (int i = 1; i <= len; i++) {
            arr[i] = cost[i - 1];
        }
        res[1] = arr[1];
        for (int i = 2; i <= len + 1; i++) {
            res[i] = Math.min(res[i - 2] + arr[i], res[i - 1] + arr[i]);
        }
        return res[len + 1];
    }
}
