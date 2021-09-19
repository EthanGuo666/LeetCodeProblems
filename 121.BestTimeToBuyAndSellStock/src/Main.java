public class Main {
    public static int maxProfit(int[] prices) {
        int result = 0, preMin = prices[0], preMax = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (preMin > prices[i]) {
                preMax = prices[i];
                preMin = prices[i];
            }
            if (preMax < prices[i]) {
                preMax = prices[i];
                result = Math.max(result, preMax - preMin);
            }
        }
        System.out.println("preMin = " + preMin);
        System.out.println("preMax = " + preMax);
        return result;
    }

    public static void main(String[] args) {

        // {7,1,5,3,6,4}   5
        // {7,6,4,3,1}     0
        // {1}             0
        // {1,1}           0
        // {1,2}           1
        //
        int[] prices = {1,2};
        System.out.println(maxProfit(prices));
    }
}
