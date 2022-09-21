import java.util.Arrays;

public class Main {
    public static int longestPalindrome(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        int[] count = new int[123];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[(int) str[i]]++;
        }
        int result = 0;
        int flag = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) flag = 1;
            result += count[i] / 2;
        }
        return result * 2 + flag;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aA"));
    }
}
