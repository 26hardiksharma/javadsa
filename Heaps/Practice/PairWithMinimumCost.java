import java.util.PriorityQueue;

public class PairWithMinimumCost {
    static class Pair{
        int val;
        int i,j;
        Pair(int val,int i,int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    public static int nSlotsMinTime(int[][] matrix) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Pair[][] pairMatrix = new Pair[matrix.length][];
        for (int i = 0; i < pairMatrix.length; i++) {
            for (int j = 0; j < pairMatrix[0].length; j++) {
                pairMatrix[i][j] = new Pair(matrix[i][j], i, j);
            }
        }   
        int cost =0;
        pq.add(pairMatrix[0][0]);
        while(!(pq.peek().i == matrix.length-1 && pq.peek().j==matrix.length-1)) {
            Pair curr = pq.peek();
            cost+=curr.val;
            int i = curr.i;
            int j = curr.j;
            pq.remove();
            if(i == 0 && j == 0) {
                if(matrix[1][0]<matrix[0][1]) {
                    pq.add(new Pair(matrix[1][0], 1, 0));
                } else {
                    pq.add(new Pair(matrix[0][1], 0, 1));
                }
            } else if(i == 0 && j == matrix.length-1) {
                if(matrix[0][matrix.length-2]<matrix[1][j]) {
                    pq.add(new Pair(matrix[0][j-1], 0, j-1));
                } else {
                    pq.add(new Pair(matrix[1][j], 1, j));
                }
            } else if(i == matrix.length-1 && j == 0) {
                if(matrix[i][j+1]<matrix[i-1][j]) {
                    pq.add(new Pair(matrix[i][j-1], i, j-1));
                } else {
                    pq.add(new Pair(matrix[i-1][j], i-1, j));
                }
            } else if(i == matrix.length-1 && j == matrix.length -1) {
                if(matrix[i-1][j]>matrix[i][j-1]) {
                    pq.add(new Pair(matrix[i][j-1], i, j-1));
                } else {
                    pq.add(new Pair(matrix[i-1][j], i-1, j));
                }
            } else {
                
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { 
            { 31, 100, 65, 12, 18 },
            { 10, 13, 47, 157, 6 },
            { 100, 113, 174, 11, 33 },
            { 88, 124, 41, 20, 140 },
            { 99, 32, 111, 41, 20 } 
        };
        System.out.println(nSlotsMinTime(matrix));
    }
}
