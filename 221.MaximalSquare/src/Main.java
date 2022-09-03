public class Main {
    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 < 0 || j - 1 < 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        return (int) Math.pow(result, 2);
    }

    public static void main(String[] args) {
        // {{'1', '0', '1', '0', '0' }, {'1', '0', '1', '1', '1' }, {'1', '1', '1', '1', '1' }, {'1', '0', '0', '1', '0' }};    4
        // {{'0', '1'}, {'1', '0'}};  1
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix));
    }
}
