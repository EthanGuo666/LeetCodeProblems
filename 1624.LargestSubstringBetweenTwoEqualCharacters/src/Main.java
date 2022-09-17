import java.util.HashMap;

public class Main {
    public static int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), i);
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = Math.max(result, i - map.get(s.charAt(i)));
        }
        return result - 1;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }
}
