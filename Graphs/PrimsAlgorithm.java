import java.util.*;
public class PrimsAlgorithm {
    static class Pair implements Comparable<Pair>{
        int v,cost;
        Pair(int v,int cost) {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Pair c) {
            return Integer.compare(cost,c.cost);
        }
    }
    public static void prims(ArrayList<Edge> [] graph) {
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0));
        int finalCost = 0;
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            if(!vis[curr.v]) {
                vis[curr.v]=true;
                finalCost+=curr.cost;

                for(int i = 0;i<graph[curr.v].size();i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.offer(new Pair(e.dest, e.weight));
                }
            }
        }
        System.out.println(finalCost);

    }
}