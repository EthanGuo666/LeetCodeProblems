import java.util.Stack;
import java.util.Vector;

class MinStack {

    int[] stack;
    int top;
    int min;

    public MinStack() {
        stack = new int[102400];
        top = 0;
        min = 2147483647;
    }

    public void push(int x) {
        stack[top] = x;
        top++;
        if (min > x)
            min = x;
    }

    public void pop() {
        top--;
        stack[top] = 0;
    }

    public int top() {
        return stack[top - 1];
    }

    public int getMin() {
        return min;
    }

    public void show() {
        System.out.print("stack:");
        for (int i = 0; i < top; i++) {
            System.out.print(stack[i]);
        }
        System.out.println("\ntop:" + top);
    }

    public static void main(String[] args) {
        MinStack v = new MinStack();
        v.push(2147483647);
        v.push(-2147483648);
        v.show();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */