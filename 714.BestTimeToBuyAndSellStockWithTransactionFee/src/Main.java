public class Main {
    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int[][] profit = new int[len][2];
        profit[0][0] = 0;
        profit[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i] - fee);
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
        }
        return profit[len - 1][0];
    }

    public static void main(String[] args) {
        // prices = [1,3,2,8,4,9], fee = 2    ans:8
        // prices = [1,3,7,5,10,3], fee = 3   ans:6
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }
}
