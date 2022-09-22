import java.util.Stack;

public class MinStack {
    private Stack<Integer> min;
    private Stack<Integer> max;
    private Stack<Integer> s;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        min = new Stack<>();
        max = new Stack<>();
        s = new Stack<>();
    }

    public void push(int x) {
        s.push(x);

        if (max.isEmpty()) {
            max.push(x);
        } else {
            if (x > max.peek()) {
                max.push(x);
            } else {
                max.push(max.peek());
            }
        }

        if (min.isEmpty()) {
            min.push(x);
        } else {
            if (x < min.peek()) {
                min.push(x);
            } else {
                min.push(min.peek());
            }
        }
    }

    public void pop() {
        if (!s.isEmpty()) {
            s.pop();
            max.pop();
            min.pop();
        }
    }

    public int top() {
        if (!s.isEmpty()) {
            return s.peek();
        } else {
            return -1;
        }
    }

    public int min() {
        if (!s.isEmpty()) {
            return min.peek();
        } else {
            return -1;
        }
    }
}