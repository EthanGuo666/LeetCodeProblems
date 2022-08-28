public class Main {
    // 计算n!后面有几个0
    public static long getZeroNum(long n) {
        long result = 0;
        while (n > 0) {
            n = n / 5;
            result += n;
        }
        return result;
    }

    // 找到k!后有n个零的第一个数字k
    public static long findFirstK(int n) {
        long r = 5L * n;
        long l = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (getZeroNum(mid) < n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }

    // 找到n+1个零的第一个数字k+1，和n个零的第一个数字k，做差得到结果
    public static int preimageSizeFZF(int k) {
        long k1 = findFirstK(k + 1);
        long k2 = findFirstK(k);
        System.out.println("k1:" + k1 + "    k2:" + k2);
        return (int) (findFirstK(k + 1) - findFirstK(k));
    }

    public static void main(String[] args) {
        System.out.println(preimageSizeFZF(5));
    }
}
