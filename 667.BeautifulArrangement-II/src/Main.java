import java.util.Arrays;

public class Main {
    public static int[] constructArray(int n, int k) {
        int[] result = new int[n];
        // 排列问题
        // 前一半有n-k项，从1排到n-k,
        // 然后是n, n-1, ...      和n-k+1, n-k+2, ...交替排列
        // 1, 2, ..., n-k,      n, n-k+1, n-1, n-k+2, ...
        for (int i = 0; i < n - k; i++) {
            result[i] = i + 1;
        }
        for (int i = n - k, j = 0; i + 2 * j < n; j++) {
            result[i + 2 * j] = n - j;
        }
        for (int i = n - k + 1, j = 0; i + 2 * j < n; j++) {
            result[i + 2 * j] = n - k + 1 + j;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(2, 1)));
    }
}
