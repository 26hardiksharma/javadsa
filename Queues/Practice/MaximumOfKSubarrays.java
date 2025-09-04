import java.util.LinkedList;
import java.util.Queue;
public class MaximumOfKSubarrays {

    public static void maxOfKSubarrays(int[] arr,int k) {
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        while(i<=arr.length-k) {
            for(int j = i;j<i+k;j++) {
                if(q.isEmpty()) {
                    q.add(arr[j]);
                } else {
                    if(q.peek()<arr[j]) {
                        q.remove();
                        q.add(arr[j]);
                    }
                }
            }

            i++;
            System.out.println(q);
            while(!q.isEmpty()) q.remove();
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,4,5,2,3,6};
        maxOfKSubarrays(arr, 3);
    }
}
