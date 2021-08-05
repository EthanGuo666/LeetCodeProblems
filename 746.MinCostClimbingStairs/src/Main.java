public class Main {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] newCost = new int[len + 1];
        newCost[0] = newCost[1] = 0;
        for (int i = 2; i <= len; i++) {
            newCost[i] = Math.min(cost[i - 1] + newCost[i - 1], cost[i - 2] + newCost[i - 2]);
        }
        return newCost[len];
    }
}
