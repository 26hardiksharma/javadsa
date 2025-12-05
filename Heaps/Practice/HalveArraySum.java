import java.util.Comparator;
import java.util.PriorityQueue;

public class HalveArraySum {
    public static int minOperations(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        
        int operations = 0;
        for(int i = 0;i<arr.length;i++) {
            sum += arr[i];
            pq.add(arr[i]);
        }
        int half = sum/2;

        while(!pq.isEmpty() && half<sum) {
            int elem = pq.remove();
            
            if(elem ==0) {
                continue;
            }
            elem = elem/2;
            sum = sum - elem;
            
            operations++;
            pq.add(elem);
        }
        return operations;

    }

    public static void main(String[] args) {
        int[] arr = {100, 250, 90, 300, 40, 500, 120, 60, 30, 1000};
        System.out.println(minOperations(arr));
    }
}
