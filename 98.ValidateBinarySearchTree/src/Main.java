import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public ArrayList<TreeNode> midOrderTraverse(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        arr.addAll(midOrderTraverse(root.left));
        arr.add(root);
        arr.addAll(midOrderTraverse(root.right));
        return arr;
    }

    public boolean isValidBST(TreeNode root) {
        ArrayList<TreeNode> arr = midOrderTraverse(root);
        long max = Long.MIN_VALUE;
        Iterator<TreeNode> it = arr.iterator();
        while (it.hasNext()) {
            long thisVal = it.next().val;
            if (thisVal > max) {
                max = thisVal;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
