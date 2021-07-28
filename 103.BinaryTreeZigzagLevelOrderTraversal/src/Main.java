import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public List<Integer> reOrder(Queue<TreeNode> t, boolean inOrder) {
        int len = t.size();
        List<TreeNode> copy = new ArrayList<>(t);
        List<Integer> list = new ArrayList<>();
        if (inOrder) {
            for (int i = 0; i < len; i++) {
                list.add(copy.get(i).val);
            }
        } else {
            for (int i = len - 1; i >= 0; i--) {
                list.add(copy.get(i).val);
            }
        }
        return list;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> arr = new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        Queue<TreeNode> childrenQueue = new LinkedList<>();
        childrenQueue.offer(root);
        boolean inOrder = true;
        do {
            levelQueue = new LinkedList<>(childrenQueue);
            arr.add(reOrder(levelQueue, inOrder));
            inOrder = !inOrder;
            childrenQueue.clear();
            do {
                TreeNode t = levelQueue.poll();
                if (t.left != null) {
                    childrenQueue.offer(t.left);
                }
                if (t.right != null) {
                    childrenQueue.offer(t.right);
                }
            } while (!levelQueue.isEmpty());
        } while (!childrenQueue.isEmpty());
        return arr;
    }

    public static void main(String[] args) {

    }
}
