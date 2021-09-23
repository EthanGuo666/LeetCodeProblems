public class Main {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int[][] profit = new int[len][3];
        profit[0][0] = -prices[0];
        profit[0][1] = 0;
        profit[0][2] = 0;
        for (int i = 1; i < len; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][2] - prices[i]);
            profit[i][1] = profit[i - 1][0] + prices[i];
            profit[i][2] = Math.max(profit[i - 1][1], profit[i - 1][2]);
        }
        return Math.max(profit[len - 1][1], profit[len - 1][2]);
    }

    public static void main(String[] args) {
        // {1,2,3,0,2}   3
        // {1}           0
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
}
