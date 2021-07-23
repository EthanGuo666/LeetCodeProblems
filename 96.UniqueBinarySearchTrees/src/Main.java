public class Main {
    public int buildTrees(int start, int end) {
        if (end < start) {
            return 0;
        }
        if (end == start) {
            return 1;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            int left = buildTrees(start, i - 1);
            int right = buildTrees(i + 1, end);
            if (left * right == 0) {
                sum += Math.max(left, right);
            } else {
                sum += left * right;
            }
        }
        return sum;
    }

    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }
        return buildTrees(1, n);
    }

    public static void main(String[] args) {

    }
}
