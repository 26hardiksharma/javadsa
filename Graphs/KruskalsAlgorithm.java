import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgorithm {

    public static int mst(ArrayList<Edge> edges,int V) {

        DisjointSet set = new DisjointSet(4);
        Collections.sort(edges,(a,b)->Integer.compare(a.weight, b.weight));

        int ans = 0;
        int count = 0;
        ArrayList<Edge> mst = new ArrayList<>();
        for(int i = 0;count<V-1;i++) {
            Edge e = edges.get(i);
            int a = e.src;
            int b = e.dest;

            int parA = set.find(a);
            int parB = set.find(b);
            if(parA != parB) {
                set.union(a, b);
                mst.add(e);
                ans+=e.weight;
                count++;
            }
        }

        for (Edge edge : mst) {
            System.out.println(edge.src + " -> " + edge.dest + " @ " + edge.weight);
        }

        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
        System.out.println(mst(edges, 4));

    }
}
