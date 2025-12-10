import java.util.*;
public class DijkstraAlgorithm {

    static class Pair implements Comparable<Pair>{
        int vertex;
        int dist;

        public Pair(int n,int dist) {
            this.vertex = n;
            this.dist = dist;

        }

        public int compareTo(Pair x) {
            return dist-x.dist;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph,int src) {
        int[] dist = new int[graph.length];
        boolean[] vis = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0;i<graph.length;i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            if(!vis[curr.vertex]) {
                vis[curr.vertex] = true;
                for(int i = 0;i<graph[curr.vertex].size();i++) {
                    Edge e = graph[curr.vertex].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if(dist[u] + wt<dist[v])  {
                        dist[v] = dist[u] + wt;
                    }
                    pq.add(new Pair(v, dist[v]));
                }
            }

        }
        for (int x:dist) {
            System.out.print(x + " ");
        }

    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        for(int i = 0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));
        graph[2].add(new Edge(2,4,3));
        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

        
        dijkstra(graph,0);
    }
}
