import java.util.Arrays;

public class Main {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mi = 0, ni = 0;
        int[] result = new int[m + n];
        while (mi < m || ni < n) {
            int cur;
            if (mi == m) {
                cur = nums2[ni++];
            } else if (ni == n) {
                cur = nums1[mi++];
            } else if (nums1[mi] <= nums2[ni]) {
                cur = nums1[mi++];
            } else {
                cur = nums2[ni++];
            }
            result[mi + ni - 1] = cur;
        }
        // 最后要把合并完的结果写入nums1数组
        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }
}
