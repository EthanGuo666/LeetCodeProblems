import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>(triangle.get(0)));

        for (int i = 1; i < n; i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int curNum = triangle.get(i).get(j);
                if (j == 0) {
                    dp.get(i).add(curNum + dp.get(i - 1).get(0));
                }
                if (0 < j && j < i) {
                    int left = curNum + dp.get(i - 1).get(j - 1);
                    int bottom = curNum + dp.get(i - 1).get(j);
                    dp.get(i).add(Math.min(left, bottom));
                }
                if (j == i) {
                    dp.get(i).add(curNum + dp.get(i - 1).get(j - 1));
                }
            }
        }
        int ans = dp.get(n - 1).get(0);
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp.get(n - 1).get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();

        // [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
        inner.add(2);
        nums.add(new ArrayList<>(inner));
        inner.clear();

        inner.add(3);
        inner.add(4);
        nums.add(new ArrayList<>(inner));
        inner.clear();

        inner.add(6);
        inner.add(5);
        inner.add(7);
        nums.add(new ArrayList<>(inner));
        inner.clear();

        inner.add(4);
        inner.add(1);
        inner.add(8);
        inner.add(3);
        nums.add(new ArrayList<>(inner));

        //System.out.println(Arrays.toString(nums.toArray()));
        System.out.println(minimumTotal(nums));
    }
}
