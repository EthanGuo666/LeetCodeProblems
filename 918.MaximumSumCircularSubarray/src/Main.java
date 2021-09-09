import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    // 见题解：https://leetcode-cn.com/problems/maximum-sum-circular-subarray/solution/xi-xiang-tong-53ti-yi-yang-by-dc3a2nletu-qvk6/
    public static int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int maxSum = nums[0], minSum = nums[0];
        int totalSum = 0;
        int maxPre = 0, minPre = 0;
        for (int i = 0; i < len; i++) {
            totalSum += nums[i];
            maxPre = Math.max(nums[i], maxPre + nums[i]);
            maxSum = Math.max(maxSum, maxPre);
            minPre = Math.min(nums[i], minPre + nums[i]);
            minSum = Math.min(minSum, minPre);
        }
        // 考虑全是负数的情况
        if (maxSum<0){
            return maxSum;
        }
        return Math.max(totalSum - minSum, maxSum);
    }

    public static void main(String[] args) {
        // {1,-2,3,-2}     3
        // {5,-3,5}       10
        // {3,-1,2,-1}     4
        // {-1,-1,-1,-1}  -1
        int[] nums = {-1,-1,-1,-1};
        //maxSubarraySumCircular(nums);
        System.out.println(maxSubarraySumCircular(nums));
    }
}
