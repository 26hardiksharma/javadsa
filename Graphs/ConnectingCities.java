import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingCities {

    public static int minCost(int[][] cities) {
        int finalCost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->Integer.compare(a.weight, b.weight));
        boolean[] vis = new boolean[cities.length];
        pq.offer(new Edge(0,0,0));

        ArrayList<Edge> mst = new ArrayList<>();
        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            if(!vis[curr.dest]) {
                mst.add(curr);
                vis[curr.dest] = true;
                finalCost+=curr.weight;
                for(int i = 0;i<cities[curr.dest].length;i++) {
                    if(cities[curr.dest][i]!=0) {
                        pq.offer(new Edge(curr.dest, i, cities[curr.dest][i]));
                    }
                }
            }

        }
        mst.remove(0);
        for(Edge x: mst) {
            System.out.println(x.src + " -> " + x.dest + " @" + x.weight);
        }
        return finalCost;
    }
    public static void main(String[] args) {
        int[][] cities = {
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0}
        };
        System.out.println(minCost(cities));
    }
}
