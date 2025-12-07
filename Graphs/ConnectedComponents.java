import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class ConnectedComponents {

    public void bfsUtil(ArrayList<Edge>[] graph,int start,boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if(!vis[curr]) {
                System.out.println(curr + " ");
                for(int i = 0;i<graph[curr].size();i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);

                }
            }
        }
    }

    public void bfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for(int i = 0;i<graph.length;i++) {
            if(!vis[i]) {
                bfsUtil(graph, i,vis);
            }
        }
    }
    public void dfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i = 0 ;i<graph.length;i++) {
            if(!vis[i]) {
                dfsUtil(graph,i,vis);
            }
        }
    }

    public void dfsUtil(ArrayList<Edge>[] graph,int curr,boolean vis[]) {
        System.out.println(curr + " ");
        vis[curr] = true;

        for(int i = 0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }
    public static void main(String[] args) {
        
    }

}
