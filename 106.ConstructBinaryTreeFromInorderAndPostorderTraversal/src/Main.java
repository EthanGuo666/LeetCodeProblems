public class Main {
    public static int[] copyRange(int[] array, int from, int to) {
        if (from < 0 || from > to || from > array.length) {
            return new int[]{};
        }
        int[] result = new int[to - from + 1];
        for (int i = from, j = 0; i <= to; i++, j++) {
            result[j] = array[i];
        }
        return result;
    }

    public static int findInOrder(int[] inorder, int rootVal) {
        int result;
        for (result = 0; result < inorder.length; result++) {
            if (inorder[result] == rootVal) {
                return result;
            }
        }
        return -1;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int len = postorder.length;
        int pivot = findInOrder(inorder, postorder[len - 1]);
        if (pivot == -1) {
            System.out.printf("wrong");
            return null;
        }

        int[] leftIn = copyRange(inorder, 0, pivot - 1);
        int[] rightIn = copyRange(inorder, pivot + 1, len - 1);
        int[] leftPost = copyRange(postorder, 0, pivot - 1);
        int[] rightPost = copyRange(postorder, pivot, len - 2);

        TreeNode t = new TreeNode(postorder[len - 1]);
        t.left = buildTree(leftIn, leftPost);
        t.right = buildTree(rightIn, rightPost);
        return t;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        buildTree(inorder, postorder);
    }
}
