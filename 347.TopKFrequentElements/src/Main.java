import java.util.*;

public class Main {
    public static class num implements Comparable<num> {
        int val;
        int fre;

        public void setVal(int x) {
            val = x;
        }

        public void setFre(int x) {
            fre = x;
        }

        @Override
        public int compareTo(num o) {
            return o.fre - fre;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int mapLen = map.size();
        num[] n = new num[mapLen];
        for (int i = 0; i < mapLen; i++) {
            n[i] = new num();
        }
        int x = 0;

        Iterator<Integer> itVal = map.keySet().iterator();
        Iterator<Integer> itFre = map.values().iterator();
        while (itVal.hasNext() && itFre.hasNext()) {
            int nextVal = itVal.next();
            int nextFre = itFre.next();
            n[x].setVal(nextVal);
            n[x].setFre(nextFre);
            x++;
        }

        Arrays.sort(n);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = n[i].val;
        }


        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
//        int k = 2;

        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;

        int[] result = topKFrequent(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(" " + result[i]);
        }
    }
}
