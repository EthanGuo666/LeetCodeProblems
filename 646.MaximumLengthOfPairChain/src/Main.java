import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static int findLongestChain(int[][] pairs) {
        // 先按每个chain的第二位大小排序
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int result = 0;
        int tailPos = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
            if (pair[0] > tailPos) {
                tailPos = pair[1];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] p = {{1, 2}, {2, 5}, {3, 4}};
        System.out.println(findLongestChain(p));
    }
}
