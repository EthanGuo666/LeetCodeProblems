public class Main {
    public static int minPathSum(int[][] grid) {
        int len_i = grid.length;
        int len_j = grid[0].length;
        int[][] dp = new int[len_i][len_j];
        dp[0][0] = grid[0][0];
        for(int i=0;i<len_i;i++){
            for(int j=0;j<len_j;j++){
                if(i==0&&j==0){
                    continue;
                }
                // only compare horizontally
                if(i==0){
                    dp[i][j] = dp[i][j-1]+grid[i][j];
                    continue;
                }
                // only compare vertically
                if(j==0){
                    dp[i][j] = dp[i-1][j]+grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        return dp[len_i-1][len_j-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
