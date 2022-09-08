import java.util.*;

public class Main {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] doubleNum = new int[2 * n];
        for (int i = 0; i < n; i++) {
            doubleNum[i] = nums[i];
        }
        for (int i = n; i < 2 * n; i++) {
            doubleNum[i] = nums[i - n];
        }

        // 注意重复元素，所以这个ans不能用HashMap
        Stack<Integer> ans = new Stack<>();
        Stack<Integer> monoStack = new Stack<>();
        for (int i = doubleNum.length - 1; i >= 0; i--) {
            while (!monoStack.isEmpty() && monoStack.peek() <= doubleNum[i]) {
                monoStack.pop();
            }
            int val = monoStack.isEmpty() ? -1 : monoStack.peek();
            ans.push(val);
            monoStack.push(doubleNum[i]);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = ans.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {100, 1, 11, 1, 120, 111, 123, 1, -1, -100};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
