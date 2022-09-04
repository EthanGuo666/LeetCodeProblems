import java.util.ArrayList;

public class Main {
    public static int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] horiCast = new int[m];
        int[] vertiCast = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    horiCast[i] += 1;
                    vertiCast[j] += 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (horiCast[i] == 1 && vertiCast[j] == 1 && mat[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(numSpecial(mat));
    }
}
