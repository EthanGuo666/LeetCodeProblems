import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Iterator<Integer> itKey = map.keySet().iterator();
        Iterator<Integer> itValue = map.values().iterator();
        int[][] temp = new int[map.size()][2];
        for (int i = 0; i < map.size(); i++) {
            temp[i][0] = itKey.next();
            temp[i][1] = itValue.next();
//            System.out.println("key:" + temp[i][0] + "  value:" + temp[i][1]);
        }

        Arrays.sort(temp, (a, b) -> {
            return a[1] - b[1] == 0 ? (b[0] - a[0]) : (a[1] - b[1]);
        });
        int[] ans = new int[nums.length];
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            while (temp[i][1] > 0) {
                ans[j] = temp[i][0];
                j++;
                temp[i][1]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 4};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }
}
