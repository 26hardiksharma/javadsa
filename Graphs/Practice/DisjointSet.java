public class DisjointSet {
    int[] par;
    int[] rank;

    public DisjointSet(int n) {
        par = new int[n];
        rank = new int[n];

        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }


    }

    public int find(int x) {
        if(x == par[x]) return x;

        return par[x] = find(par[x]);
    }

    public void union(int a,int b) {
        int parA = par[a];
        int parB = par[b];

        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA]<rank[parB]) {
            par[parA] = parB;
            
        } else {
            par[parB] = parA;
        }
    }

    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(9);
        set.union(1,3);
        System.out.println(set.find(3));
        set.union(2, 4);
        set.union(1,2);
        System.out.println(set.find(4));
    }

}
