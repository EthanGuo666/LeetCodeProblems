public class Main {
    public static int transform(char C) {
        int value = switch (C) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> -5000;
        };
        return value;
    }

    public static boolean largerThan(char preChar, char curChar) {
        int preVal = transform(preChar);
        int curVal = transform(curChar);
        if (preVal >= curVal)
            return true;
        else
            return false;
    }

    public static int romanToInt(String s) {
        // p从字符串最右端往左移动
        int p = s.length();
        int result = 0;
        while (p > 0) {
            p--;
            // p移到第一个字符了
            if (p - 1 < 0) {
                result += transform(s.charAt(p));
                break;
            }
            // 如果p-1，p对应的是 XI, VI这样的，那就直接加上
            if (largerThan(s.charAt(p - 1), s.charAt(p))) {
                result += transform(s.charAt(p));
            }
            else { // 如果遇到了IV，IX这样的，就加上V，X减去一，然后这时候应该往前跳两格，跳过前面那个I
                result = result + transform(s.charAt(p)) - transform(s.charAt(p-1));
                p--;
            }
            continue;
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "IXVI";
        int result = romanToInt(str);
        System.out.println(result);
    }
}