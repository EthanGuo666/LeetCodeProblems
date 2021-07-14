import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        dfsPath(root, "", paths);
        return paths;
    }

    public void dfsPath(TreeNode root, String str, List<String> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            str += "->" + String.valueOf(root.val);
            paths.add(str);
        }
        if (root.left != null || root.right != null) {
            if (str == "") {
                str += String.valueOf(root.val);
            } else {
                str += "->" + String.valueOf(root.val);
            }
        }
        dfsPath(root.left, str, paths);
        dfsPath(root.right, str, paths);
    }

    public static void main(String[] args) {

    }
}
