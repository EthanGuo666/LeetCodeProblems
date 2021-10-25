import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex + 2][rowIndex + 2];
        for (int i = 1; i <= rowIndex + 1; i++) {
            dp[i][1] = 1;
            dp[i][i] = 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 3; i <= rowIndex + 1; i++) {
            for (int j = 2; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        for (int i = 1; i <= rowIndex + 1; i++) {
            result.add(dp[rowIndex + 1][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums = 3;
        System.out.println(getRow(nums));
    }
}
