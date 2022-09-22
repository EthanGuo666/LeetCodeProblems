import java.util.ArrayDeque;

class CQueue {
    private ArrayDeque<Integer> dq;

    public CQueue() {
        dq = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        dq.offer(value);
    }

    public int deleteHead() {
        if (dq.isEmpty()) {
            return -1;
        } else {
            return dq.removeFirst();
        }
    }
}