import java.util.*;

public class RottenOranges {
    static class Pair {
        int val;
        int x,y;
        Pair(int val,int x,int y) {
            this.x = x;
            this.val = val;
            this.y = y;
        }
    }
    public static int orangesRotting(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;
        Pair[][] pairs = new Pair[graph.length][n];
        Queue<Pair> q = new LinkedList<>();
        int count = 0;
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                Pair p = new Pair(graph[i][j], i, j);
                pairs[i][j] = p;
                if(p.val == 2) {
                    q.offer(p);
                } else if(p.val ==1) {
                    count++;
                }
            }
        }
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int[] combos = {-1,+1,0,0};
            int[] combos2 = {0,0,-1,1};
            for(int itr = 0;itr<size;itr++) {
                Pair p= q.poll();
                for(int x=0;x<4;x++) {
                    try {
                        Pair newPair = pairs[p.x + combos[x]][p.y + combos2[x]];
                        if(newPair.val == 1) {
                            newPair.val = 2;
                            q.offer(newPair);
                            count--;
                        } 
                    } catch (Exception e){
                        continue;
                    }
                }
            }
            if(!q.isEmpty()) time++;
            
            
        }
        if(count >0) return -1;
        return time;

        
    }
    public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        System.out.println(orangesRotting(grid));
    }
}
