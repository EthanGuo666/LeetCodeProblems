public class Main {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int mLen = obstacleGrid.length, nLen = obstacleGrid[0].length;
        int[][] dp = new int[mLen + 1][nLen + 1];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            dp[1][1] = 1;
        }

        for (int i = 1; i <= mLen; i++) {
            for (int j = 1; j <= nLen; j++) {
                if (i == 1 && j == 1) continue;
                if (obstacleGrid[i - 1][j - 1] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[mLen][nLen];
    }

    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};  //2
//        int[][] obstacleGrid = {{0, 1}, {0, 0}};  //1
//        int[][] obstacleGrid = {{1}};  //1
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
