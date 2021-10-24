public class Main {
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        for (int i = 0; i < n + 1; i++) {
            System.out.println("dp[" + i + "]:" + dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(numTrees(n));
    }
}
