class Solution {
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] st = {1, 2, 3};
        int[] et = {3, 2, 7};
        int qt = 3;
        System.out.println(busyStudent(st, et, qt));
    }
}