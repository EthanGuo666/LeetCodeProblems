import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public ArrayList<TreeNode> InOrder(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        if (root == null) {
            return arr;
        }
        arr.addAll(InOrder(root.left));
        arr.add(root);
        arr.addAll(InOrder(root.right));
        return arr;
    }

    public int[] findChange(ArrayList<TreeNode> arr) {
        int len = arr.size();
        int change1 = 0;
        int change2 = len - 1;
        double lowVal = -1 * Double.MAX_VALUE;
        double highVal = Double.MAX_VALUE;
        for (; change1 < len ; change1++) {
            double leftVal = arr.get(change1).val;
            if (lowVal < leftVal) {
                lowVal = leftVal;
            } else {
                change1--;
                break;
            }
        }
        for (; change2 >= 0; change2--) {
            double rightVal = arr.get(change2).val;
            if (highVal > rightVal) {
                highVal = rightVal;
            } else {
                change2++;
                break;
            }
        }
        return new int[]{arr.get(change1).val, arr.get(change2).val};
    }

    public void recover(TreeNode root, int[] changeList) {
        if (root == null) {
            return;
        }
        if (root.val == changeList[0] || root.val == changeList[1]) {
            int setVal = root.val == changeList[0] ? changeList[1] : changeList[0];
            root.val = setVal;
        }
        recover(root.left, changeList);
        recover(root.right, changeList);
    }

    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> arr = InOrder(root);
        int[] changeList = findChange(arr);
        recover(root, changeList);
    }

    public static void main(String[] args) {
        int low = Integer.MIN_VALUE;
        System.out.println("low = " + low);
    }
}
