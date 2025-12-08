import java.util.ArrayList;

public class CycleDetection {
    public static boolean hasCycleUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis,boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i = 0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest] == true) {
                return true;
            } 

            if(!vis[e.dest] && hasCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public static boolean hasCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i] && hasCycleUtil(graph,i,vis,stack)) {
                return true;
            }   
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
