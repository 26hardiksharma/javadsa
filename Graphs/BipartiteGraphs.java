import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class BipartiteGraphs {

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<graph.length;i++) {
            if(color[i] == -1) {
                q.offer(i);
                color[i] = 0;
                while(!q.isEmpty()) {
                    int curr = q.poll();
                    for(int itr = 0;itr<graph[curr].size();itr++) {
                        Edge e = graph[curr].get(itr);
                        if(color[e.dest] == -1) {
                            if(color[curr] == 0) {
                                color[e.dest] = -1;
                            } else {
                                color[e.dest] = 1;
                            }
                            q.add(e.dest);
                        } else if(color[curr] == color[e.dest]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
