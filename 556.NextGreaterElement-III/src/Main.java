import java.util.Arrays;

public class Main {
    public static int nextGreaterElement(int n) {
        String nStr = String.valueOf(n);
        int len = nStr.length();
        char[] num = new char[len];
        for (int i = len - 1; i >= 0; i--) {
            num[i] = nStr.charAt(i);
        }

        // tmp记录第一个降序对（num[i-1]<nums[i]）中较小元素的位置
        int tmp = -1;
        for (int i = len - 1; i > 0; i--) {
            if (num[i - 1] < num[i]) {
                tmp = i - 1;
                break;
            }
        }
        if (tmp == -1) {
            return -1;
        }
        // 将下标从[tmp, len-1]的所有元素排序
        Arrays.sort(num, tmp + 1, len);

        // change position of num[tmp] with the minimum larger element within range [tmp, len-1]
        for (int i = tmp + 1; i < len; i++) {
            // swap them
            if (num[i] > num[tmp]) {
                char mid = num[tmp];
                num[tmp] = num[i];
                num[i] = mid;
                break;
            }
        }

        String target = String.valueOf(num);
        if (target.length()>=10 && target.compareTo("2147483647") > 0) {
            return -1;
        }
        return Integer.parseInt(target);
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(2147483486));
    }
}
