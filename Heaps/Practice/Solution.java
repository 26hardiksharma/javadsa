import java.util.*;
class Solution {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
            if(Math.abs(a-x)<Math.abs(b-x)) return -1;
            else if(Math.abs(a-x)==Math.abs(b-x)) {
                return Integer.compare(a,b);
            } else {
                return 1;
            }
        });

        for(int i = 0;i<arr.length;i++) {
            pq.add(arr[i]);
        }
        List<Integer> l = new ArrayList<>();
        for(int i = 0;i<k;i++) {
            l.add(pq.poll());
        }

        return l;
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3,4,5},4,3));
    }
}