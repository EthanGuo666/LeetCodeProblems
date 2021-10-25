public class Main {
    public static int Min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        int len = matrix.length;
        int[][] dp = new int[len][len];
        System.arraycopy(matrix[0], 0, dp[0], 0, len);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                    continue;
                }
                if (j + 1 == len) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + matrix[i][j];
                    continue;
                }
                dp[i][j] = Min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
            }
        }
        for (int i = 0; i < len; i++) {
            result = Math.min(result, dp[len - 1][i]);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        // {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};     13
        // {{-19, 57}, {-40, -5}};       -59
        // {{-48}};     -48
        int[][] matrix = {{-48}};
        minFallingPathSum(matrix);
    }
}
