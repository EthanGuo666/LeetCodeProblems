import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        double h = 0.05 * n;
        double t = 0.95 * n;
        double sum = 0.0;
        for (int i = (int) h; i < t; i++) {
            sum += arr[i];
        }
        return sum / (0.9 * n);
    }

    public static void main(String[] args) {
//        int[] arr = {6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0};
        int[] arr = {6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4};
        System.out.println(trimMean(arr));
    }
}
