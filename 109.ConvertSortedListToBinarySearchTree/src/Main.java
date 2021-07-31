public class Main {
    public ListNode findMid(ListNode start, ListNode end) {
        ListNode fast = start;
        ListNode slow = start;
        while (fast != end && fast.next != end) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public TreeNode buildTree(ListNode head, ListNode rear) {
        if (head == rear) {
            return null;
        }
        ListNode mid = findMid(head, rear);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(head, mid);
        root.right = buildTree(mid.next, rear);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public static void main(String[] args) {

    }
}
