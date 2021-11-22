import java.util.Arrays;

public class Main {
    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i]) continue;
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};  //3
//        int amount = 11;

//        int[] coins = {3};
//        int amount = 5;  //-1

//        int[] coins = {186, 419, 83, 408};
//        int amount = 6249;  //20

        int[] coins = {1, 2};
        int amount = 0;   //0

        System.out.println(coinChange(coins, amount));
    }
}
