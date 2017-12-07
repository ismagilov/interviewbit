package graphs;

/**
* https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
*/
public class LargestDistanceBetweenNodesOfATree {
    public int solve(ArrayList<Integer> arr) {
        if (arr == null || arr.isEmpty())
            return 0;
            
        Graph g = new Graph(arr.size());
        int root = -1;
        for (int v = 0; v < arr.size(); v++) {
            if (arr.get(v) == -1) {
                root = v;
                continue;
            }
            
            g.addEdge(v, arr.get(v));
        } 
        
        int[] distTo = calcDists(g, root);
        
        int maxDist = -1;
        int distStart = -1;
        for (int v = 0; v < g.v(); v++) {
            if (distTo[v] > maxDist) {
                maxDist = distTo[v];
                distStart = v;
            }
        }

        maxDist = -1;        
        distTo = calcDists(g, distStart);
        for (int v = 0; v < g.v(); v++) {
            if (distTo[v] > maxDist)
                maxDist = distTo[v];
        }
        
        return maxDist;
    }
    
    private int[] calcDists(Graph g, int start) {
        int[] distTo = new int[g.v()];
        boolean[] visited = new boolean[g.v()];
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        
        while (!q.isEmpty()) {
            int v = q.poll();
            visited[v] = true;
            
            for (int w : g.adj(v)) {
                if (visited[w]) continue;
                
                distTo[w] = distTo[v] + 1;
                q.offer(w);
            }
        }
        
        return distTo;
    }
    
    private final class Graph {
        private final int v;
        private final List<Integer>[] adjs;
        
        private Graph(int v) {
            this.v = v;    
            
            adjs = (List<Integer>[])new ArrayList[v]; // (List<Integer>[])
            for (int i = 0; i < v; i++)
                adjs[i] = new ArrayList<>();
        }
        
        private void addEdge(int v, int w) {
            adjs[v].add(w);
            adjs[w].add(v);
        }
        
        private List<Integer> adj(int v) {
            return adjs[v];
        }
        
        private int v() {
            return v;
        }
    }
}
