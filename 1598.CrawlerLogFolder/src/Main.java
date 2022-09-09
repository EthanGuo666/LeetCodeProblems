import java.util.Stack;

public class Main {
    public static int minOperations(String[] logs) {
        Stack<String> path = new Stack<>();
        for (String log : logs) {
            if (path.isEmpty()) {
                if (!log.equals("./") && !log.equals("../")) {
                    path.push(log);
                }
            } else {
                if (log.equals("../")) {
                    path.pop();
                } else if (!log.equals("./")) {
                    path.push(log);
                }
            }
        }
        int result = path.size();
        return result;
    }

    public static void main(String[] args) {
        String[] logs = {"d1/","d2/","../","d21/","./"};
        System.out.println(minOperations(logs));
    }
}
