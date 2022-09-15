import java.util.Arrays;

public class Main {
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numStr = new String[n];
        for (int i = 0; i < n; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStr, (a, b) -> (b + a).compareTo(a + b));
//        System.out.println(Arrays.toString(numStr));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(numStr[i]);
        }
        if (result.toString().charAt(0) == '0') {
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] nums = {30, 34, 3};
        largestNumber(nums);
    }
}
