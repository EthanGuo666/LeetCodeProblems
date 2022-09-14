import java.util.LinkedList;

public class Main {
    public static String makeGood(String s) {
        char[] arrCh = s.toCharArray();
        int n = s.length();
        LinkedList<Character> linkCh = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkCh.add(arrCh[i]);
        }

        int curLen = linkCh.size();
        do {
            for (int i = 0; i < linkCh.size() - 1;) {
                if (Math.abs(linkCh.get(i) - linkCh.get(i + 1)) == 'a' - 'A') {
                    linkCh.remove(i);
                    linkCh.remove(i);
                } else {
                    i++;
                }
            }
            if (linkCh.size() == curLen) {
                break;
            } else {
                curLen = linkCh.size();
            }
        } while (true);

        StringBuilder result = new StringBuilder();
        for(int i=0;i<linkCh.size();i++) {
            result.append(linkCh.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
    }
}
