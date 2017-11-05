package graphs;

/**
* https://www.interviewbit.com/problems/commutable-islands/
*
* Find minimal spanning tree using Kruskal's algo.
*/
public class CommutableIslandsB {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Edge> edges = new ArrayList<>();
        DisjointSet ds = new DisjointSet(A);
        
        for (ArrayList<Integer> row : B)
            edges.add(new Edge(row.get(0), row.get(1), row.get(2)));
        
        edges.sort(Comparator.comparingInt(value -> value.w));
        
        int res = 0;
        
        for (Edge e : edges) {
            int root1 = ds.find(e.v1);
            int root2 = ds.find(e.v2);
            
            if (root1 != root2) {
                ds.union(e.v1, e.v2);
                
                res += e.w;
            }
        }

        return res;
    }

    private class Edge {
        private final int v1;
        private final int v2;
        private final int w;
        
        private Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }
    
    private class DisjointSet {
        private final Set[] ss;
        
        private DisjointSet(int sz) {
            ss = new Set[sz + 1];
            
            for (int i = 1; i <= sz; i++)
                ss[i] = new Set(i, 0);
        }
        
        private int find(int i) {
            if (ss[i].parent == i)
                return ss[i].parent;
                
            ss[i].parent = find(ss[i].parent);
            
            return ss[i].parent;
        }
        
        private void union(int i1, int i2) {
            int root1 = find(i1);
            int root2 = find(i2);
         
            if (ss[root1].rank > ss[root2].rank) {
                ss[root2].parent = root1;
            } else if (ss[root1].rank < ss[root2].rank) {
                ss[root1].parent = root2;
            } else {
                ss[root1].parent = root2;
                ss[root2].rank++;
            }
        }
    }
    
    private class Set {
        private int parent;
        private int rank;
        
        private Set(int p, int r) {
            this.parent = p;
            this.rank = r;
        }
    }
}
