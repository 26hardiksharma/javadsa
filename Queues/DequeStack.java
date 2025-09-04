import java.util.Deque;
import java.util.LinkedList;

public class DequeStack {

    Deque<Integer> deque;
    DequeStack() {
        deque = new LinkedList<>();

    }

    public void push(int n) {
        deque.addLast(n);
    }

    public int pop() {
        return deque.removeLast();
    }

    public int peek() {
        return deque.getLast();
    }
    public static void main(String[] args) {
        DequeStack stack = new DequeStack();
        for(int i = 0;i<10;i++) {
            stack.push(i);
        }
        System.out.println(stack.deque);
    }
}
