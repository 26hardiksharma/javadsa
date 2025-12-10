import java.util.ArrayList;

public class AllPaths {
    public static void allPaths(ArrayList<Edge>[] graph,int src,int dest,String path) {
        if(src == dest) {
            System.out.println(path+dest);
        }
        
        for(int i = 0;i<graph[src].size();i++) {
            Edge e = graph[src].get(i);
            allPaths(graph, e.dest, dest, path+src);
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
        graph[0].add(new Edge(0, 3,0));
        allPaths(graph, 5, 1,"");
    }
}
