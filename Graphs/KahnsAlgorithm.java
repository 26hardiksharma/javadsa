import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm {
    public static int[] calculateIndeg(ArrayList<Edge>[] graph) {
        int[] indeg = new int[graph.length];
        for(int i =0 ;i<graph.length;i++) {
            for(int j = 0;j<graph[i].size();j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
        return indeg;
    }
    public static void topSort(ArrayList<Edge>[] graph) {
        int[] indegree = calculateIndeg(graph);

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<indegree.length;i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for(int i  = 0;i<graph[curr].size();i++) {
                Edge e = graph[curr].get(i);
                if(--indegree[e.dest] == 0) {
                    q.offer(e.dest);
                }
            }
        }

        
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        for(int i = 0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3,1,1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[5].add(new Edge(5,0, 0));
        graph[5].add(new Edge(5, 2, 0));
        topSort(graph);
    }   
}
