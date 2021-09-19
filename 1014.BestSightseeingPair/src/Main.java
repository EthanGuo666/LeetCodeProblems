public class Main {
    public static int maxScoreSightseeingPair(int[] values) {
        int result = 0, preVal = values[0];
        for (int j = 1; j < values.length; j++) {
            result = Math.max(result, preVal + values[j] - j);
            preVal = Math.max(preVal, values[j] + j);
        }
        return result;
    }

    public static void main(String[] args) {
        // {8,1,5,2,6}    11
        // {1,2}           2
        int[] nums = {1,3,2};
        System.out.println(maxScoreSightseeingPair(nums));
    }
}
