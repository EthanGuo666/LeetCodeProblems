import java.util.Arrays;

public class Main {
    public static int sum(int[] circle, int start, int end) {
        int result = 0;
        for (int i = start; i < end; i++) {
            result += circle[i];
        }
        return result;
    }

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] circle = new int[2 * n];
        for (int i = 0; i < n; i++) {
            circle[i] = code[i];
            circle[i + n] = code[i];
        }

        int[] result = new int[n];
        if (k == 0) {
            Arrays.fill(result, 0);
            return result;
        }

        if (k > 0) {
            int i = 0, start = 1;
            int end = start + k;
            for (; i < n; i++, start++, end++) {
                result[i] = sum(circle, start, end);
            }
        }
        if (k < 0) {
            int i = n, start = i + k, end = n;
            for (; i < 2 * n; i++, start++, end++) {
                result[i - n] = sum(circle, start, end);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] code = {5, 7, 1, 4};
//        int k = 3;

//        int[] code = {1, 2, 3, 4};
//        int k = 0;

//        int[] code = {2, 4, 9, 3};
//        int k = -2;
        System.out.println(Arrays.toString(decrypt(code, k)));
    }
}
