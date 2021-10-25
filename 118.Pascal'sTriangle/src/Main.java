import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows + 1][numRows + 1];
        for (int i = 1; i <= numRows; i++) {
            dp[i][1] = 1;
            dp[i][i] = 1;
        }
        for (int i = 3; i <= numRows; i++) {
            for (int j = 2; j < i; j++) {
                dp[i][j] += dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                System.out.print(" " + dp[i][j]);
            }
            System.out.println("");
        }
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j <= i; j++) {
                current.add(dp[i][j]);
            }
            result.add(current);
            current = new ArrayList<>();
        }
        //
        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;
        generate(numRows);
        //System.out.println(generate(numRows));
    }
}
