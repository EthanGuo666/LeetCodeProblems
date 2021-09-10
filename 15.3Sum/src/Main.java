import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 默认要让 first < second < third
        // 枚举第1个元素
        for (int first = 0; first < len - 2; first++) {
            // 如果 nums[first]>0 ，则 nums[second] 和 nums[third] 就更大了
            if (nums[first] > 0) {
                continue;
            }
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 预先设定 third ，指向最右端
            int third = len - 1;
            // 枚举第2个元素
            for (int second = first + 1; second < len - 1; second++) {
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 second 的指针始终在 third 的指针的左侧
                while (third > second && nums[third] >= 0 && (nums[first] + nums[second] + nums[third] > 0)) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> success = new ArrayList<>();
                    success.add(nums[first]);
                    success.add(nums[second]);
                    success.add(nums[third]);
                    result.add(success);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // {-1,0,1,2,-1,-4}   [[-1, -1, 2], [-1, 0, 1]]
        // {-1,-1,-1,-1}      []
        // {0,0,0}            [[0,0,0]]
        int[] nums = {0, 0, 0};
        System.out.println(threeSum(nums));
    }
}
