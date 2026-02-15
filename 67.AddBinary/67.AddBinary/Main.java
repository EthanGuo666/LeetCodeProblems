public class Main {
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder("");
        int cur = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            cur += i < a.length() ? a.charAt(a.length() - i - 1) - '0' : 0;
            cur += i < b.length() ? b.charAt(b.length() - i - 1) - '0' : 0;
            result.append(cur % 2);
            cur = cur / 2;
        }
        if (cur != 0) {
            result.append(cur);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
