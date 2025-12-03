import java.util.PriorityQueue;

public class ConnectNRopes {
    public static int cost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;
        for (int i : arr) {
            pq.add(i);
        }
        while(pq.size()>1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost +=min1+min2;
            pq.add(min1+min2);   
        }

        return cost;
    }

    public static void main(String[] args) {
        int[]arr = {4,3,2,6};
        System.out.println(cost(arr));
    }
}
