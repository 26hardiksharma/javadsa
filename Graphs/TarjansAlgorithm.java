import java.util.ArrayList;

public class TarjansAlgorithm {

    public static void dfs(ArrayList<Edge>[] graph,int curr,int par,int[] dt,int[] low,boolean[] vis,int time) {
        vis[curr] = true;
        
        dt[curr] = low[curr] = ++time;
        for(int i =0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(e.dest == par) {
                continue;
            } else if(!(vis[e.dest])) {
                dfs(graph, e.dest, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr],low[e.dest]);
                if(dt[curr]<low[curr]) {
                    System.out.println("Bridge: "+curr + " --- "+e.dest);

                } else {
                    low[curr] = Math.min(low[curr],dt[e.dest]);
                }
            }
        }
    }

    public static void bridges(ArrayList<Edge>[] graph) {
        int dt[] = new int[graph.length];
        int low[] = new int[graph.length];
        int time = 0;
        boolean[]vis = new boolean[graph.length];
        for(int i = 0;i<graph.length;i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time);
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
