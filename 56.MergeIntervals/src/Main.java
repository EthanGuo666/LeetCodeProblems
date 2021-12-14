import java.util.*;

public class Main {
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0 || len == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });

        List<int[]> output = new ArrayList<int[]>();
        output.add(intervals[0]);
        for (int i = 0; i < len - 1; i++) {
            int size = output.size();
            int left0 = output.get(size - 1)[0];
            int left1 = output.get(size - 1)[1];
            int right0 = intervals[i + 1][0];
            int right1 = intervals[i + 1][1];
            if (left1 < right0) {
                output.add(intervals[i + 1]);
            } else {
                output.set(size - 1, new int[]{left0, Math.max(left1, right1)});
            }
        }
        return output.toArray(new int[output.size()][]);
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}}; // {{1,6},{8,10},{15,18}}
//        int[][] intervals = {{1, 4}, {4, 5}}; // {{1,5}}
//        int[][] intervals = {{1, 3}, {4, 5}}; // {{1, 3}, {4, 5}}
//        int[][] intervals = {{1, 6}}; // {{1, 6}}
        int[][] intervals = {{1, 1}}; // {{1, 1}}
        int[][] result = merge(intervals);
        for (int[] ints : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(" " + ints[j]);
            }
            System.out.println("");
        }
    }
}
