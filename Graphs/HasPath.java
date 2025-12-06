import java.util.ArrayList;
import java.util.Stack;

public class HasPath {
    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest) {
        Stack<Integer> s = new Stack<>();
        s.push(src);
        boolean visited[] = new boolean[graph.length];
        while(!s.isEmpty()) {
            int v = s.pop();
            if(!visited[v]) {
                if(v == dest) {
                    return true;
                } else {
                    visited[v] = true;
                    for(int i = 0;i<graph[v].size();i++) {
                        Edge e = graph[v].get(i);
                        s.push(e.dest);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 1000;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i = 0; i < v; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < v - 1; i++) {
            graph[i].add(new Edge(i, i + 1, 1));
        }

        for(int i = 1; i < v; i++) {
            graph[i].add(new Edge(i, i - 1, 1));
        }

        for(int i = 0; i < v; i += 10) {
            for(int j = i + 2; j < i + 20 && j < v; j++) {
                graph[i].add(new Edge(i, j, 1));
            }
        }
        int v2 = 1000;
        ArrayList<Edge>[] graph2 = new ArrayList[v2];
        for(int i = 0; i < v; i++) graph2[i] = new ArrayList<>();

        for(int i = 0; i < 499; i++) {
            graph2[i].add(new Edge(i, i + 1, 1));
        }

        for(int i = 500; i < 999; i++) {
            graph2[i].add(new Edge(i, i + 1, 1));
        }
        System.out.println(hasPath(graph, 0, 999));

        System.out.println(hasPath(graph2, 0, 999));
    }
}
