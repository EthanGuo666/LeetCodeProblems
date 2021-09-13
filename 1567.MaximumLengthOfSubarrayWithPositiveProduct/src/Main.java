public class Main {
    public static int getMaxLen(int[] nums) {
        int posLen = 0;
        int negLen = 0;
        int maxLen = posLen;
        for (int num : nums) {
            if (num > 0) {
                posLen++;
                negLen = negLen > 0 ? negLen + 1 : 0;
            }
            if (num < 0) {
                int newPosLen = negLen > 0 ? negLen + 1 : 0;
                int newNegLen = posLen + 1;
                posLen = newPosLen;
                negLen = newNegLen;
            }
            if (num == 0) {
                posLen = 0;
                negLen = 0;
            }
            maxLen = Math.max(maxLen, posLen);
        }
        return maxLen;
    }
}
