import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len * 2 + 1];
        for (int i = 0; i < len * 2; i++) {
            dp[i + 1] = dp[i] + nums[i % len];
        }
        for (int i = 0; i < len * 2; i++) {
            System.out.println(dp[i]);
        }

        int ans = nums[0];
        Deque<Integer> deque = new ArrayDeque();
        deque.offer(0);
        for (int j = 1; j < 2 * len + 1; j++) {
            if (deque.peekFirst() < j - len)
                deque.pollFirst();
            ans = Math.max(ans, dp[j] - dp[deque.peekFirst()]);
            while (!deque.isEmpty() && dp[j] <= dp[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(j);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};
        maxSubarraySumCircular(nums);
    }
}
