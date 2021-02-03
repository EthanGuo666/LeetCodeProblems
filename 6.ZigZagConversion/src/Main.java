public class Main {
    //public String convert(String s, int numRows) {
    public static String convert(String s, int numRows) {
        int strLen = s.length();
        if(strLen==1||numRows==1){
            return s;
        }
        int cycleLen = 2 * numRows - 2;
        // no matter if the last cycle finishes, always added one cycle for safety
        int cycleNum = strLen / cycleLen + 1;
        int matrixLen = cycleNum * (numRows - 1);
        char[][] wordMatrix = new char[numRows][matrixLen];

        int i = 0, j = 0, n = 0;
        while (n < strLen) {
            if (j % (numRows - 1) == 0) {
                while (i < numRows && n < strLen) {
                    wordMatrix[i][j] = s.charAt(n);
                    i++;
                    n++;
                }
            }
            i--;
            if (n >= strLen) {
                break;
            }
            while (i > 0 && n < strLen) {
                i--;
                j++;
                wordMatrix[i][j] = s.charAt(n);
                n++;
            }
            i++;
        }

//        n = 0;
//        for (i = 0; i < wordMatrix.length; i++) {
//            for (j = 0; j < wordMatrix[i].length; j++) {
//                if (wordMatrix[i][j] != '\0' && n < strLen) {
//                    //wordMatrix[i][j] =
//                    System.out.print(wordMatrix[i][j]);
//                    //buffer[n] = wordMatrix[i][j];
//                    n++;
//                } else {
//                    System.out.print("*");
//                }
//            }
//            System.out.print("\n");
//        }

        char[] buffer = new char[strLen];
        n = 0;
        for (i = 0; i < wordMatrix.length; i++) {
            for (j = 0; j < wordMatrix[i].length; j++) {
                if (wordMatrix[i][j] != '\0' && n < strLen) {
                    buffer[n] = wordMatrix[i][j];
                    n++;
                }
            }
        }
        return new String(buffer);
    }

    public static void main(String[] args) {
        String s1 = "ABCDEFG";
        int num = 2;
        System.out.println(convert(s1, num));
    }
}
