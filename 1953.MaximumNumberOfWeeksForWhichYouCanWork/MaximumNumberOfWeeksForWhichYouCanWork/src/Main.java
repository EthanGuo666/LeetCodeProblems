import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import static java.util.Arrays.sort;

public class Main {
    public static long numberOfWeeks(int[] milestones) {
        long sum = 0;
        int max = -1;
        for (int i = 0; i < milestones.length; i++) {
            sum += milestones[i];
            max = Math.max(max, milestones[i]);
        }
        long res = sum - max;
        if (max > res + 1) {
            return res * 2 + 1;
        } else {
            return sum;
        }
    }

    public static void main(String[] args) {
        /**
         * 思路：
         * 1. 首先考虑一种最普通的情况：
         *      - milestone数组中所有的值都差不多大，这样挨个消耗，就可以消磨干净
         * 2. 再考虑：
         *      - 假如milestone中有两个元素特别大，其他的都差不多，那么这两个大值相互消耗之后，问题回到第一种情况
         * 3. 经过以上两种情况，可以发现问题关键在于：
         *      - 整个milestone数组中，是否存在一个有“能力”消磨掉最大值的元素；
         *      - 也就是数组中的最大值，要小于其余所有元素之和
         */
        int[] milestones = {9, 3, 6, 8, 2, 1};  // 29
        System.out.println(numberOfWeeks(milestones));
    }
}