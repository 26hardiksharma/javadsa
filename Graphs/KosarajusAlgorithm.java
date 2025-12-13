import java.util.*;

public class KosarajusAlgorithm {

    public static void topSort(ArrayList<Edge>[] graph,int curr,boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for(int i = 0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    public static ArrayList<Edge>[] transpose(ArrayList<Edge>[] graph) {
        ArrayList<Edge>[] transposed = new ArrayList[graph.length];
        for(int i = 0;i<graph.length;i++) {
            transposed[i] = new ArrayList<>();
        }

        for(int i = 0;i<graph.length;i++) {
            for(int j = 0 ;j<graph[i].size();j++) {
                Edge e = graph[i].get(j);
                int src = e.dest;
                int dest = e.src;
                transposed[src].add(new Edge(src, dest, 0));
            }
        }
        return transposed;

        
    }
    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for(int i = 0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge>[] graph) {
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[graph.length];
        for(int i = 0;i<graph.length;i++) {
            if(!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }
        Arrays.fill(vis,false);
        ArrayList<Edge>[] transpose = transpose(graph);
        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                System.out.print("SCC -> ");
                dfs(transpose,curr,vis);
                System.out.println();
            }
        }

    }
    public static void main(String[] args) {
        ArrayList<Edge> [] graph = new ArrayList[5];
        for(int i = 0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2,0));
        graph[1].add(new Edge(1,0,0));
        graph[2].add(new Edge(2,1,0));
        graph[0].add(new Edge(0,3,0));
        graph[3].add(new Edge(3,4,0));
        kosaraju(graph);
    }
}
