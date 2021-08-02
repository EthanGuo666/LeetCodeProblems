import java.util.*;

public class Main {
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> curPath = new Stack<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        checkPath(root, targetSum);
        return result;
    }

    public void checkPath(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        curPath.push(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<Integer>(curPath));
        }
        checkPath(root.left, targetSum);
        checkPath(root.right, targetSum);
        curPath.pop();
    }

    public static void main(String[] args) {
//        List<Integer> l = new ArrayList<>();
//        l.add(0);
//        l.add(1);
//        l.add(2);
//        l.add(3);
//        l.remove(2);
//        Iterator<Integer> it = l.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

    }
}
