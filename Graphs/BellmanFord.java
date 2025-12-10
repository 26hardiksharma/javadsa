import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    public static void bellmanFordShortestPath(ArrayList<Edge>[] graph,int src) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        int V = graph.length;
        for(int i = 0;i<V-1;i++) {
            for(int j = 0;i<graph.length;j++) {
                for(int k = 0;k<graph[j].size();k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;
                    dist[v] = (dist[u]!= Integer.MAX_VALUE && dist[u] + wt<dist[v]) ? dist[u] + wt:dist[v]; 
                }
            }
        } 
        for(int i: dist) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        
    }
}
