import java.util.LinkedList;
import java.util.Queue;


public class InterleaveQueues {
    public static void main(String[] args) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> finalQueue = new LinkedList<>();
        for(int i = 1;i<=10;i++) {
            q1.add(i);
        }

        int size1 = q1.size();
        for(int i = 0;i<size1/2;i++) {
            q2.add(q1.remove());
        }
        while(!q1.isEmpty()) {
            finalQueue.add(q2.remove());
            finalQueue.add(q1.remove());
        }
        while(!finalQueue.isEmpty()) {
            System.out.println(finalQueue.remove());
        }
    }
}
