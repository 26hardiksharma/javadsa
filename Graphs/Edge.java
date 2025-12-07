import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Edge {
    
    int src;
    int dest;
    int weight;

    public Edge(int s,int d,int w) {
        this.src = s;
        this.dest = d;
        this.weight = w;
    }

    public static void bfs(ArrayList<Edge>[] graph) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()) {
            int v = q.poll();
            if(visited[v]) {
                continue;
            } else {
                System.out.println(v);
                visited[v] = true;

                for(int i = 0;i<graph[v].size();i++) {
                    Edge e = graph[v].get(i);
                    q.offer(e.dest);
                }
                
            }
        }

    }

    public static void dfs(ArrayList<Edge>[] graph) { // O(V+E)
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        s.push(0);
        while(!s.isEmpty()) {
            int v = s.pop();
            if(!visited[v]) {
                System.out.println(v);
                visited[v] = true;
                for(int i = 0;i<graph[v].size();i++) {
                    Edge e = graph[v].get(i);
                    s.push(e.dest);
                }
            }
        }
    }
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i = 0;i<graph.length;i++) {
            if(!vis[i]) {
                if(detectCycleUtil(graph,vis,i,-1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis,int curr,int par) {
        vis[curr] = true;
        for(int i = 0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest] && detectCycleUtil(graph, vis, e.dest, curr)) {
                return true;
            } else if(vis[e.dest] && e.dest!=par) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i = 0;i<v;i++) {
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 2));
        graph[1].add(new Edge(1, 2, 3));
        graph[1].add(new Edge(1, 4, 7));

        graph[2].add(new Edge(2, 0, 4));
        graph[2].add(new Edge(2, 1, 3));
        graph[2].add(new Edge(2, 3, 2));
        graph[2].add(new Edge(2, 4, 5));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 2, 2));
        graph[3].add(new Edge(3, 4, 6));

        graph[4].add(new Edge(4, 1, 7));
        graph[4].add(new Edge(4, 2, 5));
        graph[4].add(new Edge(4, 3, 6));

        dfs(graph);
    }   

    
}
