import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class WeakestSoldier {

    static class  Row implements Comparable<Row>{
        int soldierLen;
        int index;

        Row(int[] arr,int i) {
            for (int x : arr) {
                if(x==1) soldierLen++;

            }
            this.index = i;
        }

        public int compareTo(Row r1) {
            if(this.soldierLen==r1.soldierLen) {
                return Integer.compare(index, r1.index);
            }
            return Integer.compare(soldierLen, r1.soldierLen);
        }
        
    }

    public static void kWeakestSoldiers(int[][] matrix,int k) {
        PriorityQueue<Row> pq =new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            pq.add(new Row(matrix[i],i));
        }

        for(int i = 0;i<k;i++) {
            System.out.println(pq.remove().index);
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0}
        };
        kWeakestSoldiers(matrix, 2);
    }
}
