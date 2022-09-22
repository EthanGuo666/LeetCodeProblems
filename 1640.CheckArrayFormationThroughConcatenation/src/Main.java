import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static boolean match(String target, LinkedList<String> ps) {
        if (target.equals("") && ps.size() == 0) {
            return true;
        }
        for (int i = 0; i < ps.size(); i++) {
            if (target.startsWith(ps.get(i))) {
                int restStart = ps.get(i).length();
                ps.remove(ps.get(i));
                return match(target.substring(restStart, target.length()), ps);
            }
        }
        return false;
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        StringBuilder sbArr = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sbArr.append(String.valueOf(arr[i]) + "-");
        }
        String target = sbArr.toString();
        LinkedList<String> ps = new LinkedList<>();
        for (int i = 0; i < pieces.length; i++) {
            StringBuilder sbPs = new StringBuilder();
            for (int j = 0; j < pieces[i].length; j++) {
                sbPs.append(String.valueOf(pieces[i][j]) + "-");
            }
            ps.add(sbPs.toString());
        }
//        System.out.println("target:" + target);
//        for (int i = 0; i < ps.size(); i++) {
//            System.out.println("ps" + i + ":" + ps.get(i));
//        }
        return match(target, ps);
    }

    public static void main(String[] args) {
//        int[] arr = {15, 88};
//        int[][] pieces = {{88}, {15}};

        int[] arr = {49, 18, 16};
        int[][] pieces = {{16, 18, 49}};
        System.out.println(canFormArray(arr, pieces));
    }
}
