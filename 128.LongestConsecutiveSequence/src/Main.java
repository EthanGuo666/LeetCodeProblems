import java.util.HashSet;

public class Main {
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int result = 0;
        for (int cur : set) {
            if (!set.contains(cur - 1)) {
                int next = cur;
                while (set.contains(next + 1)) next++;
                result = Math.max(result, next - cur + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }
}
