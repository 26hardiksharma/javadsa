
import java.util.*;
public class PushAtBottom {
    public static void pushAtBottom(Stack<Integer> s,int k) {
        if(s.isEmpty()) {
            s.push(k);
            return;
        }

        int x = s.pop();
        pushAtBottom(s, k);
        s.push(x);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s,4);
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }    
}
