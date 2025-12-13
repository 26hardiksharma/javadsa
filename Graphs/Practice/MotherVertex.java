import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MotherVertex {

    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean[] vis) {
        vis[curr] = true;
        for(int i = 0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfs(graph,e.dest,vis);
            }
        }
    }
    public static int motherVertexDFS(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        int last=-1;
        for(int i = 0;i<graph.length;i++) {
            if(!vis[i]) {
                dfs(graph, i, vis);
                last = i;
            }
        }

        Arrays.fill(vis, false);
        dfs(graph, last, vis);
        for(boolean b:vis) {
            if(!b) return -1;
        }
        return last;
    }
    public static int motherVertexBFS(ArrayList<Edge>[] graph) {
        int mv = 0;

        for(int i = 0;i<graph.length;i++) {
            boolean[] vis =  new boolean[graph.length];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            vis[i] = true;
            while(!q.isEmpty()) {
                int curr = q.poll();
                for(int j = 0;j<graph[curr].size();j++) {
                    Edge e = graph[curr].get(j);
                    if(!vis[e.dest]) {
                        vis[e.dest] = true;
                        q.offer(e.dest);
                    }
                }
            }
            int c = 0;
            for (boolean v : vis) {
                if(v == true) {
                    c++;
                }
            }

            if(c == graph.length) return i;

        }

        return -1;
    }

    public static void main(String[] args) {
        
    }
}
