public class Main {
    public static int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        }
        if (presses == 1) {
            if (n == 1) {
                return 2;
            }
            if (n == 2) {
                return 3;
            }
            if (n > 2) {
                return 4;
            }
        }
        if (presses >= 2) {
            if (n == 1) {
                return 2;
            }
            if (n == 2) {
                return 4;
            }
            if (n > 2) {
                if (presses==2) return 7;
                else return 8;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(flipLights(3, 1));
    }
}
