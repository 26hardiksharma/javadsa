import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
public class GenerateBinaryNumbers {
    public static void printBinaryNumbers(int n) {
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++) {
            if(q.isEmpty()) {
                q.addLast(1);
                System.out.println(q);
                continue;
            }

            if(q.getLast()==0) {
                q.remove();
                q.addLast(1);
            } else {
                int count = 0;
                while(!q.isEmpty()) {
                    int k = q.removeLast();
                    count++;
                    if(k==0) break;

                }

                if(q.isEmpty()) {
                    for(int x = 0;x<count+1;x++) {
                        q.add(1);
                    }
                    System.out.println(q);
                } else {
                    q.removeLast();
                    q.add(1);
                    for(int x= 0;x<count;x++) {
                        q.add(0);
                        System.out.println(q);
                    }

                }
            }
            System.out.println(q);
        }
    }    

    public static void main(String[] args) {
        printBinaryNumbers(10);
    }
}
