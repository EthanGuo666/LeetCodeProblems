import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            map.putIfAbsent(s.charAt(i), i);
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.offer(s.charAt(i));
                continue;
            }
            if (stack.contains((Character) s.charAt(i))) {
                continue;
            }
            // 当前字符和栈顶元素比较,如果栈顶元素大于当前字符且后续还有其他字符可以作为替代时,栈顶元素出栈
            while (!stack.isEmpty() && stack.peekLast() > s.charAt(i) && i < map.get(stack.peekLast())) {
                stack.removeLast();
            }
            stack.offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "ecbacba";
        System.out.println(removeDuplicateLetters(s));
    }
}
