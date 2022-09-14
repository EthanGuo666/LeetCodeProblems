public class Main {
    public static int maximumSwap(int num) {
        char[] chNum = String.valueOf(num).toCharArray();
        int n = chNum.length;
        int[][] max = new int[n][2];
        max[n - 1][0] = chNum[n - 1] - '0';
        max[n - 1][1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (max[i + 1][0] < chNum[i] - '0') {
                max[i][0] = chNum[i] - '0';
                max[i][1] = i;
            } else {
                max[i][0] = max[i + 1][0];
                max[i][1] = max[i + 1][1];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            // swap here
            if (max[i][0] != chNum[i] - '0') {
                char mid = chNum[max[i][1]];
                chNum[max[i][1]] = chNum[i];
                chNum[i] = mid;
                break;
            }
        }
        int result = Integer.parseInt(String.valueOf(chNum));
        return result;
    }

    public static void main(String[] args) {
//        int num = 2736;
        int num = 9973;
        System.out.println(maximumSwap(num));
    }
}
