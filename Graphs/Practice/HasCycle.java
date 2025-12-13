
import java.util.ArrayList;

public class HasCycle {

    public boolean hasCycle(ArrayList<Edge> edges,int V) {
        DisjointSet set = new DisjointSet(v);
        for (Edge edge : edges) {
            int a = edge.src;
            int b = edge.dest;

            if(set.find(a) == set.find(b)) {
                return true;
            } else {
                set.union(a,b);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }    
}
