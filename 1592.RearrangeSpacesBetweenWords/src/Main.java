import java.util.ArrayList;

public class Main {
    public static String reorderSpaces(String text) {
        String[] arr = text.split(" ");
        ArrayList<String> words = new ArrayList<>();
        int lenSum = 0;
        for (String st : arr) {
            if (!st.equals("")) {
                lenSum += st.length();
                words.add(st);
            }
        }

        if (words.size()==1) {
            String result = words.get(0);
            String filler = " ".repeat(Math.max(0, text.length()-result.length()));
            return result+filler;
        }

        int spaceSum = text.length() - lenSum;
        int space = spaceSum / (words.size() - 1);
        int leftover = spaceSum % (words.size() - 1);
//        System.out.println("space:" + space);
//        System.out.println("leftover:" + leftover);

        String spaceFiller = " ".repeat(Math.max(0, space));
        String spaceLeftover = " ".repeat(Math.max(0, leftover));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.size() - 1; i++) {
            result.append(words.get(i));
            result.append(spaceFiller);
        }
        result.append(words.get(words.size() - 1));
        return result.toString() + spaceLeftover;
    }

    public static void main(String[] args) {
        // String text = "  this   is  a sentence ";
        String text = " as";
        String ans = reorderSpaces(text);
        System.out.println("*" + ans + "*");
        System.out.println(ans.length() == text.length());
    }
}
