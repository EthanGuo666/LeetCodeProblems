public class Main {
    public static int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        // s = "12"    2
        // s = "226"   3
        // s = "0"     0
        // s = "06"    0
        // s = "10"    1
        // s = "60"    0
        // s = "342"   1
        // s = "2013"  2
        String str = "2013";
        System.out.println(numDecodings(str));
    }
}
