import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        MyLinkedList my = new MyLinkedList();
        // ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        // [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
        my.addAtHead(7);
        my.addAtHead(2);
        my.addAtHead(1);
        my.addAtIndex(3, 0);
        my.deleteAtIndex(2);
        my.addAtHead(6);
        my.addAtTail(4);
        my.get(4);
        my.addAtHead(4);
        my.addAtIndex(5, 0);
        my.addAtHead(6);
    }
}
