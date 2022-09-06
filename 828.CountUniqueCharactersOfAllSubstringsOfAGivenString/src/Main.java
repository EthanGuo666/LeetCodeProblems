import java.util.Arrays;

public class Main {
    public static int uniqueLetterString(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] l = new int[n], r = new int[n];
        int[] tmp = new int[26];
        Arrays.fill(tmp, -1);

        // 先算l数组，l[i]记录i位往左数第一个相同元素出现的位置
        // AXAXXA, 对于中间那个A来说，l[2]=0, r[2]=5
        for (int i = 0; i < n; i++) {
            int pos = ch[i] - 'A';
            l[i] = tmp[pos];
            tmp[pos] = i;
        }

        Arrays.fill(tmp, n);
        // r[i]记录第i位元素往右数第一个相同元素出现的位置
        for (int i = n - 1; i >= 0; i--) {
            int pos = ch[i] - 'A';
            r[i] = tmp[pos];
            tmp[pos] = i;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (i - l[i]) * (r[i] - i);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "ABC";
        System.out.println(uniqueLetterString(str));
    }
}
