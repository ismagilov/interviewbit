package graphs;

/**
* https://www.interviewbit.com/problems/commutable-islands/
*
* Correct, but exceeds time limit.
*/
public class CommutableIslands {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Edge> edges = new ArrayList<>();
        HashMap<Integer, Set<Integer>> lookup = new HashMap<>();
        
        for (ArrayList<Integer> row : B)
            edges.add(new Edge(row.get(0), row.get(1), row.get(2)));
        
        edges.sort(Comparator.comparingInt(value -> value.w));
        
        for (int i = 1; i <= A; i++) {
            Set<Integer> s = new HashSet<>();
            s.add(i);
            lookup.put(i, s);
        }

        int res = 0;
        
        for (Edge e : edges) {
            Set<Integer> s1 = lookup.get(e.v1);
            Set<Integer> s2 = lookup.get(e.v2);
            
            if (s1 != s2) {
                s1.addAll(s2);
                
                for (Integer i : s2)
                    lookup.put(i, s1);

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
}
