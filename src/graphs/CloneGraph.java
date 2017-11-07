/**
 * https://www.interviewbit.com/problems/clone-graph/
 *
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        
        ArrayDeque<UndirectedGraphNode> q = new ArrayDeque<>();    
        HashMap<Integer, UndirectedGraphNode> copies = new HashMap<>();
        
        UndirectedGraphNode copiedNode = new UndirectedGraphNode(node.label);
        q.offer(node);
        
        copies.put(node.label, copiedNode);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            
            for (UndirectedGraphNode nbr : cur.neighbors) {
                if (!copies.containsKey(nbr.label)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(nbr.label);
                    copies.put(nbr.label, copy);
                    copies.get(cur.label).neighbors.add(copy);
                    q.offer(nbr);
                } else {
                    copies.get(cur.label).neighbors.add(copies.get(nbr.label));
                }
            }
        }
        
        return copiedNode;
    }
}
