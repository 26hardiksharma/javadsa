import java.util.*;
public class CycleDetectionBFS {

    public static boolean hasCycleUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(curr);
        while(!q.isEmpty()) {
            int c = q.poll();
            for(int i = 0;i<graph[c].size();i++) {
                Edge e = graph[c].get(i);
                if(vis[e.dest]) {
                    
                }
            }
        }



    }
    public static boolean hasCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for(int i = 0;i<graph.length;i++) {
            if(hasCycleUtil(graph,i,vis)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        for(int i = 0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();

        }



        graph[0].add(new Edge(1, 3, 0));
        graph[0].add(new Edge(0,5,0));
        // graph[];
    }
}
