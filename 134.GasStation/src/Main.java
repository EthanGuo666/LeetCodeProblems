public class Main {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int curRest = 0;
        int sum = 0;
        int result = 0;
        // 贪心，保证当前的剩余量大于0，否则把当前剩余量清零重新开始累计
        for (int i = 0; i < n; i++) {
            int curDiff = gas[i] - cost[i];
            curRest += curDiff;
            sum += curDiff;
            if (curRest < 0) {
                curRest = 0;
                result = i + 1;
            }
        }
        return sum < 0 ? -1 : result;
    }

    public static void main(String[] args) {
//        int[] g = {1, 2, 3, 4, 5};
//        int[] c = {3, 4, 5, 1, 2};

        int[] g = {3, 1, 1};
        int[] c = {1, 2, 2};
        System.out.println(canCompleteCircuit(g, c));
    }
}
