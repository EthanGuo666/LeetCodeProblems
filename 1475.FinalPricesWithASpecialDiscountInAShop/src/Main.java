import java.util.Arrays;

public class Main {
    // 再做一次，用单调栈的解法
    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] discount = new int[n];
        for (int i = 0; i < n; i++) {
            discount[i] = 0;
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    discount[i] = prices[j];
                    break;
                }
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = prices[i] - discount[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        System.out.println(Arrays.toString(finalPrices(prices)));
    }
}
