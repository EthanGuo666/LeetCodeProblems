public class Main {
    public static int[] copyRange(int[] array, int from, int to) {
        if (from < 0 || to < 0 || from >= array.length || from > to) {
            return new int[]{};
        }
        int[] result = new int[to - from + 1];
        for (int i = from, j = 0; i <= to; j++, i++) {
            result[j] = array[i];
        }
        return result;
    }

    public static int findFirst(int[] preorder, int[] inorder) {
        int result;
        for (result = 0; result < inorder.length; result++) {
            if (inorder[result] == preorder[0]) {
                return result;
            }
        }
        return -1;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int pivot = findFirst(preorder, inorder);
        int len = inorder.length;

        if (pivot == -1) {
            System.out.println("wrong");
            return new TreeNode();
        }

        int[] leftIn = copyRange(inorder, 0, pivot - 1);
        int[] rightIn = copyRange(inorder, pivot + 1, len - 1);
        int[] leftPre = copyRange(preorder, 1, pivot);
        int[] rightPre = copyRange(preorder, pivot + 1, len - 1);


        TreeNode root = new TreeNode(preorder[0]);
        System.out.println("ayo: " + root.val);
        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree(preorder, inorder);
    }
}
