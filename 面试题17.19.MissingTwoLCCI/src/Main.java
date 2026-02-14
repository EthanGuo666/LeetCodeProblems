import java.util.Arrays;

public class Main {
    public static int[] missingTwo(int[] nums) {
        int n = nums.length + 2, cur = n * (1 + n) / 2;
        for (int x : nums) cur -= x;
        int sum = cur, t = cur / 2;
        cur = t * (1 + t) / 2;
        for (int x : nums) {
            if (x <= t) cur -= x;
        }
        return new int[]{cur, sum - cur};
    }

    public static void main(String[] args) {
        int[] ns = {};
        System.out.println(Arrays.toString(missingTwo(ns)));
    }
}
