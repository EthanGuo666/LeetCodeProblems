import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public List<Integer> nodeToInteger(Queue<TreeNode> arr) {
        Queue<TreeNode> copy = new LinkedList<>(arr);
        List<Integer> integers = new LinkedList<>();
        while (!copy.isEmpty()) {
            integers.add(copy.poll().val);
        }
        return integers;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> arr = new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        Queue<TreeNode> childQueue = new LinkedList<>();
        childQueue.offer(root);

        do {
            levelQueue = new LinkedList<>(childQueue);
            arr.add(nodeToInteger(levelQueue));
            childQueue.clear();
            do {
                TreeNode treeInQueue = levelQueue.poll();
                if (treeInQueue.left != null) {
                    childQueue.offer(treeInQueue.left);
                }
                if (treeInQueue.right != null) {
                    childQueue.offer(treeInQueue.right);
                }
            } while (!levelQueue.isEmpty());
        } while (!childQueue.isEmpty());
        return arr;
    }

    public static void main(String[] args) {

    }
}
