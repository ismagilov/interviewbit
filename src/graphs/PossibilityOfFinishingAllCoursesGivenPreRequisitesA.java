package graphs;

/**
* https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/
*
* DFS recursion approach.
*/
public class PossibilityOfFinishingAllCoursesGivenPreRequisitesA {
    private boolean[] visited;
    private boolean[] inProcess;

    public int solve(int N, ArrayList<Integer> PC, ArrayList<Integer> C) {
        visited = new boolean[N];
        inProcess = new boolean[N];
        
        Graph g = new Graph(N);
        for (int i = 0; i < PC.size(); i++)
            g.addEdge(PC.get(i) - 1, C.get(i) - 1);
        
        for (int v = 0; v < g.v(); v++) {
            if (!visited[v]) {
                if (cycleSearch(g, v))
                    return 0;
            }
        }
        
        return 1;
    }
    
    private boolean cycleSearch(Graph g, int v) {
        visited[v] = true;
        inProcess[v] = true;
        
        for (int w : g.adj(v)) {
            if (inProcess[w])
                return true;

            if (visited[w])
                continue;
                
            if (cycleSearch(g, w))
                return true;
        }
        
        inProcess[v] = false;
        
        return false;
    }
    
    private static class Graph {
        private final int v;
        private final List<Integer>[] edges;
        
        private Graph(int v) {
            this.v = v;
            edges = (List<Integer>[])new ArrayList[v];
            for (int i = 0; i < v; i++)
                edges[i] = new ArrayList<>();
        }
        
        private void addEdge(int v, int w) {
            edges[v].add(w);
        }
        
        private int v() {
            return v;
        }
        
        private List<Integer> adj(int v) {
            return edges[v];
        }
    }
}
