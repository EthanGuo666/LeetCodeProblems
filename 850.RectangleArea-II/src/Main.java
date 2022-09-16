import java.util.*;

public class Main {
    public static long calculateArea(int[] curRect) {
        return (long) (curRect[2] - curRect[0]) * (curRect[3] - curRect[1]);
    }

    public static boolean check(int[] c, int[][] r) {
        for (int i = 0; i < r.length; i++) {
            if (c[0] >= r[i][0] && c[1] >= r[i][1] && c[2] <= r[i][2] && c[3] <= r[i][3]) {
                return true;
            }
        }
        return false;
    }

    public static int rectangleArea(int[][] rectangles) {
        HashSet<Integer> xs = new HashSet<>();
        HashSet<Integer> ys = new HashSet<>();
        for (int i = 0; i < rectangles.length; i++) {
            xs.add(rectangles[i][0]);
            xs.add(rectangles[i][2]);
            ys.add(rectangles[i][1]);
            ys.add(rectangles[i][3]);
        }
        Iterator<Integer> itx = xs.iterator();
        Iterator<Integer> ity = ys.iterator();
        ArrayList<Integer> xArr = new ArrayList<>();
        ArrayList<Integer> yArr = new ArrayList<>();
        while (itx.hasNext()) {
            xArr.add(itx.next());
        }
        while (ity.hasNext()) {
            yArr.add(ity.next());
        }
        xArr.sort((a, b) -> a - b);
        yArr.sort((a, b) -> a - b);
//        System.out.println(xArr.toString());
//        System.out.println(yArr.toString());

        long result = 0;
        for (int i = 0; i < xArr.size() - 1; i++) {
            for (int j = 0; j < yArr.size() - 1; j++) {
                int[] curRect = {xArr.get(i), yArr.get(j), xArr.get(i + 1), yArr.get(j + 1)};
                // check if the current rectangle is covered
                if (check(curRect, rectangles))
                    result += calculateArea(curRect);
            }
        }
        return (int) (result % 1000000007);
    }

    public static void main(String[] args) {
        int[][] rec = {{0, 0, 2, 3}, {1, 0, 2, 3}, {1, 0, 3, 1}};
        System.out.println(rectangleArea(rec));
    }
}
