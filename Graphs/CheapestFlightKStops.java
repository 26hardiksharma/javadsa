import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightKStops{
    static class  Info implements Comparable<Info>{
        
        int vertex;
        int weight;
        int stops;

        public Info(int v,int wt,int stops) {
            this.vertex = v;
            this.weight = wt;
            this.stops = stops;
        }

        public int compareTo(Info x) {
            if(x.weight == this.weight) {
                return Integer.compare(this.stops, x.stops);

            } else {
                return Integer.compare(this.weight, x.weight);
            }
        }

    }
    public static int cheapestFlight(ArrayList<Edge>[] graph,int src,int dest,int k) {

        PriorityQueue<Info> pq = new PriorityQueue<>();

        pq.offer(new Info(src,0,0));
        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while(!pq.isEmpty()) {
            Info curr = pq.poll();

            if(curr.stops<=k) {
                for(int i = 0;i<graph[curr.vertex].size();i++) {
                    Edge e = graph[curr.vertex].get(i);
                    if(dist[e.src]!=Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.dest]) {
                        dist[e.dest] = dist[e.src] + e.weight;
                    }

                    pq.offer(new Info(e.dest, dist[e.dest], curr.stops+1));
                }
            } else {
                break;
            }
        }



        if(dist[dest] == Integer.MAX_VALUE) return -1;
        return dist[dest];
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[4];
        for(int i = 0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,100));
        // graph[0].add(new Edge(0,3,1000));
        graph[1].add(new Edge(1,2,100));
        graph[1].add(new Edge(1,3,600));
        graph[2].add(new Edge(2,3,200));
        graph[2].add(new Edge(2,0,100));

        System.out.println(cheapestFlight(graph, 0, 3, 1));
    }
}
