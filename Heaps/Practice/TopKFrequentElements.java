import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    static class Pair implements Comparable<Pair>{
        int val;
        int freq;

        Pair(int val,int freq) {
            this.val = val;
            this.freq = freq;
        }
        public int compareTo(Pair x) {
            return Integer.compare(freq, x.freq);
        }

    }
    public static void topK(int[] arr,int k) {
        // int[] freqs = new int[10000];
        // int[] negFreqs = new int[10000];
        // PriorityQueue<Integer> pq = new PriorityQueue<>(
        //     (i1,i2)-> {
        //         if(i1<0 && i2<0) {
        //             return -Integer.compare(negFreqs[-i1], negFreqs[-i2]);
        //         } else if(i1<0 && i2>=0) {
        //             return -Integer.compare(negFreqs[-i1],freqs[i2]);
        //         } else if(i1>=0 && i2<0) {
        //             return -Integer.compare(freqs[i1],negFreqs[-i2]);
        //         } else {
        //             return -Integer.compare(freqs[i1],freqs[i2]);
        //         }
        //     });
    
        // for (int i : arr) {
        //     if(i<0) {
        //         negFreqs[-i]++;
        //     } else {
        //         freqs[i]++;
        //     }
        // }
        // for (int i = 0; i < freqs.length; i++) {
        //     if(freqs[i] > 0) pq.add(i);
        // }
        // for(int i = 1;i<negFreqs.length;i++) {
        //     if(negFreqs[i] > 0) pq.add(-i);
        // }
        // for(int i = 0;i<k;i++) {
        //     System.out.println(pq.poll());
        // }

        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (o1,o2) ->{
            return -Integer.compare(map.get(o1),map.get(o2));
        });

        for (Integer i: arr) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }
        HashSet<Integer> checked = new HashSet<>();
        for (Integer i : arr) {
            if(!checked.contains(i)) {
                checked.add(i);
                pq.add(i);
            }
        }

        for(int i = 0;i<k;i++) {
            System.out.println(pq.poll());
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,1,4,0,4,-1,-2,-1};
        topK(arr, 5);
    }
    

}
