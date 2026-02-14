public class Main {
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] flowed = new double[query_row + 2][query_row + 2];
        flowed[1][1] = poured;

        for (int i = 2; i < query_row + 2; i++) {
            for (int j = 1; j < i + 1; j++) {
                double left, right;
                left = flowed[i - 1][j - 1] < 1.0 ? 0.0 : (flowed[i - 1][j - 1] - 1) / 2;
                right = flowed[i - 1][j] < 1.0 ? 0.0 : (flowed[i - 1][j] - 1) / 2;


                flowed[i][j] = left + right;
            }
        }
        return Math.min(flowed[query_row + 1][query_glass + 1], 1.0);
    }

    public static void main(String[] args) {

        double output = champagneTower(1, 1, 1);
        System.out.println(output);
    }
}