import java.util.Arrays;

public class Main {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        char[] ch1 = text1.toCharArray(), ch2 = text2.toCharArray();
        int[][] dp = new int[m][n];
        // initialization
        dp[0][0] = ch1[0] == ch2[0] ? 1 : 0;
        for (int i = 1; i < n; i++) {
            int cur = ch1[0] == ch2[i] ? 1 : 0;
            dp[0][i] = Math.max(dp[0][i - 1], cur);
        }
        for (int i = 1; i < m; i++) {
            int cur = ch1[i] == ch2[0] ? 1 : 0;
            dp[i][0] = Math.max(dp[i - 1][0], cur);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (ch1[i] == ch2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        String str1 = "bsbininm";
        String str2 = "jmjkbkjkv";
        System.out.println(longestCommonSubsequence(str1, str2));
    }
}
