import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static String makeGood(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        Deque<Character> deq = new ArrayDeque<>();
        deq.offer(arr[0]);
        for (int i = 1; i < n; i++) {
            if (deq.isEmpty()) {
                deq.offer(arr[i]);
                continue;
            }
            if (Math.abs(deq.getLast() - arr[i]) == 'a' - 'A') {
                deq.removeLast();
            } else {
                deq.offer(arr[i]);
            }
        }
        StringBuilder st = new StringBuilder();
        while (!deq.isEmpty()) {
            st.append(deq.poll());
        }
        return st.toString();
    }

    public static void main(String[] args) {
        // "leEeetcode"
        // "abBAcC"
        System.out.println(makeGood("leEeetcode"));
    }
}
