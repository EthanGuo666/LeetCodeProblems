import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Main {
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        // 将数组下标index 按照r = wage[i]/quality[i]升序排列，前面是高质量worker
        Arrays.sort(index, (a, b) -> (quality[b] * wage[a] - quality[a] * wage[b]));

        // 优先队列保存r值最小的前k个人
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int totalQ = 0;
        // 先让前k个元素进入优先队列
        for (int i = 0; i < k; i++) {
            queue.add(quality[index[i]]);
            totalQ += quality[index[i]];
        }

        double result = totalQ * ((double) wage[index[k - 1]] / quality[index[k - 1]]);
        // 然后再遍历k+1到n个元素，维护队列
        for (int i = k; i < n; i++) {
            int cur = quality[index[i]];
            if (cur < queue.peek()) {
                totalQ -= queue.poll();
                totalQ += cur;
                queue.offer(cur);
                result = Math.min(result, totalQ * ((double) wage[index[i]] / cur));
            }
        }
        return result;
    }

//    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
//        int n = quality.length, sumQ = 0;
//        var id = IntStream.range(0, n).boxed().toArray(Integer[]::new);
//        Arrays.sort(id, (i, j) -> wage[i] * quality[j] - wage[j] * quality[i]); // 按照 r 值排序
////        System.out.println(Arrays.toString(id));
//
//        var pq = new PriorityQueue<Integer>((a, b) -> b - a); // 最大堆
//        for (var i = 0; i < k; ++i) {
//            pq.offer(quality[id[i]]);
//            sumQ += quality[id[i]];
//        }
////        System.out.println(sumQ);
////        while(!pq.isEmpty()) {
////            System.out.println(pq.poll());
////        }
//
//        var ans = sumQ * ((double) wage[id[k - 1]] / quality[id[k - 1]]); // 选 r 值最小的 k 名工人组成当前的最优解
////        System.out.println(ans);
//        for (var i = k; i < n; ++i) {
//            var q = quality[id[i]];
//            if (q < pq.peek()) { // sumQ 可以变小，从而可能得到更优的答案
//                int top = pq.poll();
//                System.out.println(top);
//                sumQ -= top - q;
//                pq.offer(q);
//                ans = Math.min(ans, sumQ * ((double) wage[id[i]] / q));
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        int[] qs = {3, 1, 10, 10, 1};
        int[] ws = {4, 8, 2, 2, 7};
        int k = 3;
        System.out.println(mincostToHireWorkers(qs, ws, k));
    }
}
