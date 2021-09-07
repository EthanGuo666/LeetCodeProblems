public class Main {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[n];
    }

    public static void main(String[] args) {

    }
}
