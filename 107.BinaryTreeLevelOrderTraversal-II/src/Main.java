import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public List<Integer> transNode(Queue<TreeNode> queue) {
        Queue<TreeNode> copy = new LinkedList<>(queue);
        List<Integer> result = new LinkedList<>();
        while (!copy.isEmpty()) {
            result.add(copy.poll().val);
        }
        return result;
    }

    public List<List<Integer>> turnOver(List<List<Integer>> arr) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            result.add(arr.get(i));
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> levelList;
        Queue<TreeNode> childList = new LinkedList<>();
        List<List<Integer>> arr = new ArrayList<>();
        childList.offer(root);
        do {
            levelList = new LinkedList<>(childList);
            arr.add(transNode(levelList));
            childList.clear();
            do {
                TreeNode t = levelList.poll();
                if (t.left != null) {
                    childList.offer(t.left);
                }
                if (t.right != null) {
                    childList.offer(t.right);
                }
            } while (!levelList.isEmpty());
        } while (!childList.isEmpty());
        List<List<Integer>> result = turnOver(arr);
        return result;
    }
}
