import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSubarraysSizeK {
    static class Pair implements Comparable<Pair>{
        int val,idx;
        Pair(int val,int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Pair c2) {
            return Integer.compare(val, c2.val);

        }
    }
    public static void maxArraysSizeK(int[] arr,int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0;i<k;i++) {
            pq.add(new Pair(arr[i], i));
        }
        int[] window = new int[arr.length-k+1];
        window[0] = pq.peek().val;
        for(int i =k;i<arr.length;i++) {
            while(pq.size()>0 && pq.peek().idx<=i-k) {
                pq.remove();
            }   
            pq.add(new Pair(arr[i],i));
            window[i-k+1] = pq.peek().val;
        }
        for (int i : window) {
            System.out.print(i + " ");
        }
        

    
    }
    public static void main(String[] args) {
        int[] arr = {1,3,-1,3,5,3,6,7};
        maxArraysSizeK(arr, 3   );

    }
}
