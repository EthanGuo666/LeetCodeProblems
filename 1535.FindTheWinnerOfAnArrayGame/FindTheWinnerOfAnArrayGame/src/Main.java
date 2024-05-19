public class Main {
    public static int getWinner(int[] arr, int k) {
        int roundCount = 1;
        int max = 0;
        int[] winner = new int[arr.length];
        winner[0] = arr[0];
        for (int i = 1; i < winner.length; i++) {
            winner[i] = Math.max(winner[i - 1], arr[i]);
            max = Math.max(winner[i], max);
        }
        winner[0] = 0;
        if (k == 1) {
            return winner[1];
        }
        if (k >= arr.length) {
            return max;
        }
        int cur = 0;
        int result = 0;
        int i = 1;
        for (; i < winner.length; i++) {
            if (cur == winner[i]) {
                roundCount++;
                if (roundCount == k) {
                    result = winner[i];
                    break;
                }
            } else {
                cur = winner[i];
                roundCount = 1;
            }
        }
        if (i==winner.length) {
            return max;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 1, 3, 5, 4, 6, 7};    // win[] = {0, 2, 3, 5, 5}
//        int k = 2;

//        int[] arr = {3, 2, 1};                // win[] = {3, 3, 3, 3, 3...}
//        int k = 10;

        int[] arr = {1, 25, 35, 42, 68, 70};
        int k = 2;

        System.out.println(getWinner(arr, k));
    }
}