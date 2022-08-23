import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    // 定义一个私有类
    static class Tuple {
        TreeNode node;
        int r;
        int c;

        public Tuple(TreeNode node, int r, int c) {
            this.node = node;
            this.r = r;
            this.c = c;
        }
    }

    public static int getDepth(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        } else {
            result = 1 + Math.max(getDepth(root.left), getDepth(root.right));
        }
        return result;
    }

    public static List<List<String>> printTree(TreeNode root) {
        int height = getDepth(root) - 1;
        int width = (int) (Math.pow(2, height + 1) - 1);
        List<List<String>> result = new ArrayList<>();
        // 初始化result，
        for (int i = 0; i < height + 1; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add("");
            }
            result.add(row);
        }
        Queue<Tuple> queue = new ArrayDeque<>();
        // 第0行，第3个数
        queue.offer(new Tuple(root, 0, (width - 1) / 2));
        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int r = t.r, c = t.c;
            result.get(r).set(c, Integer.toString(node.val));
            if (node.left != null) {
                queue.offer(new Tuple(node.left, r + 1, c - (int)Math.pow(2, height - r -1)));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, r + 1, c + (int)Math.pow(2, height - r -1)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(2, null, new TreeNode(5));
        TreeNode root = new TreeNode(0, left, right);
        System.out.println(printTree(root));
    }
}
