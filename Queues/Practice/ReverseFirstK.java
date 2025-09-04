import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstK {

    public static void reverseFirstK(Queue<Integer> q,int k) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<k;i++) {
            s.push(q.remove());

        }

        Queue<Integer> temp = new LinkedList<>();
        while(!q.isEmpty()) {
            temp.add(q.remove());
        }

        while(!s.isEmpty()) {
            q.add(s.pop());
        } 

        while (!temp.isEmpty()) {
            q.add(temp.remove());
        }

        System.out.println(q);

    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<10;i++) {
            q.add(i);
        }

        reverseFirstK(q, 5);
    }
}
