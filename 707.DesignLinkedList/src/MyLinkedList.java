import java.util.Vector;

public class MyLinkedList {
    Vector<Integer> lkList;

    public MyLinkedList() {
        lkList = new Vector<>();
    }

    public int get(int index) {
        if (!lkList.isEmpty() && index < lkList.size() && index >= 0) {
            return lkList.get(index);
        }
        return -1;
    }

    public void addAtHead(int val) {
        lkList.add(0, val);
    }

    public void addAtTail(int val) {
        lkList.add(lkList.size(), val);
    }

    public void addAtIndex(int index, int val) {
        if (index <= lkList.size()){
            lkList.add(index, val);
        }
    }

    public void deleteAtIndex(int index) {
        if (index < lkList.size() && index >= 0)
            lkList.removeElementAt(index);
    }
}

/**
 * ["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
 * [[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]
 *
 * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
 * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
 *
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 * <p>
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 * <p>
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 * <p>
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */