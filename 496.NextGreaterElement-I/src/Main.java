import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> monoStack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!monoStack.isEmpty() && monoStack.peek() <= nums2[i]) {
                monoStack.pop();
            }
            int val = monoStack.isEmpty() ? -1 : monoStack.peek();
            map.put(nums2[i], val);
            monoStack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(num1, num2)));
    }
}
