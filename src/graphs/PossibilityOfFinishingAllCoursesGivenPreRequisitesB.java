package graphs;

/**
* https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/
*
* DFS approach using stack, without recursion.
*/
public class PossibilityOfFinishingAllCoursesGivenPreRequisitesB {
    private boolean[] visited;
    private boolean[] inProcess;
    private Iterator<Integer>[] adj;
    
    public int solve(int N, ArrayList<Integer> PC, ArrayList<Integer> C) {
        visited = new boolean[N];
        inProcess = new boolean[N];
        
        Graph g = new Graph(N);
        for (int i = 0; i < PC.size(); i++)
            g.addEdge(PC.get(i) - 1, C.get(i) - 1);
        
        adj = (Iterator<Integer>[]) new Iterator[g.v()];
        for (int v = 0; v < g.v(); v++)
            adj[v] = g.adj(v).iterator();
            
        for (int v = 0; v < g.v(); v++) { 
            if (!visited[v]) {
                if (cycleSearch(g, v))
                    return 0;
            }
        }
  
        return 1;
    }
    
    private boolean cycleSearch(Graph g, int v) {
        Deque<Integer> s = new ArrayDeque<>();

        s.push(v);
        while (!s.isEmpty()) {
            int cur = s.peek();
        
            visited[cur] = true;    
            inProcess[cur] = true;

            if (adj[cur].hasNext()) {
                int w = adj[cur].next();
                
                if (inProcess[w])
                    return true;
                
                if (!visited[w])
                    s.push(w);
            } else {
                inProcess[cur] = false;
                s.pop();
            }
        }

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
