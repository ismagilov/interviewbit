/**
* https://www.interviewbit.com/problems/commutable-islands/
*
* Find minimal spanning tree using Prim's algo.
*/
public class Solution {
    private Graph g;
    private PriorityQueue<Edge> q = new PriorityQueue<>();
    private boolean[] inTree;
    
    public int solve(int V, ArrayList<ArrayList<Integer>> arr) {
        inTree = new boolean[V];
        g = new Graph(V);
        for (ArrayList<Integer> row : arr)
            g.addEdge(new Edge(row.get(0) - 1, row.get(1) - 1, row.get(2)));

        visit(0);

        int res = 0;
        while (!q.isEmpty()) {
            Edge cur = q.poll();
            int v = cur.either(), w = cur.other(v);
            if (inTree[v] && inTree[w]) continue;
            
            //in MST
            res += cur.weight();
            
            if (!inTree[v]) visit(v);
            if (!inTree[w]) visit(w);
        }

        return res;
    }
    
    private void visit(int v) {
        inTree[v] = true;
        
        for (Edge e : g.edges(v)) {
            if (!inTree[e.other(v)])
                q.offer(e);
        }
    }

    private final class Edge implements Comparable<Edge> {
        private final int v1;
        private final int v2;
        private final int w;
        
        private Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
        
        private int either() {
            return v1;
        }
        
        private int other(int v) {
            return v1 == v ? v2 : v1;
        }
        
        private int weight() {
            return w;
        }
        
        public String toString() {
            return v1 + "-" + v2 + ":" + w;
        }
        
        public int compareTo(Edge e) {
            return Comparator.<Edge>comparingInt(v -> v.w).compare(this, e);
        }
    }
    
    private final class Graph {
        private final List<Edge>[] edges;
        
        private Graph(int v) {
            edges = (List<Edge>[]) new List[v];   
            for (int i = 0; i < v; i++)
                edges[i] = new ArrayList<>();
        }
        
        private void addEdge(Edge e) {
            edges[e.v1].add(e);
            edges[e.v2].add(e);
        }
        
        private List<Edge> edges(int v) {
            return edges[v];
        }
        
        private int v() {
            return edges.length;
        }
    }
}
