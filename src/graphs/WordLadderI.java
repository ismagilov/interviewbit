package graphs;

/**
* https://www.interviewbit.com/problems/word-ladder-i/
*/
public class WordLadderI {
	public int ladderLength(String start, String end, ArrayList<String> dict) {
	    Dict d = new Dict(dict);

	    Queue<String> q = new ArrayDeque<>();
	    Set<String> visited = new HashSet<>();
	    Map<String, Integer> distTo = new HashMap<>();
        	    
	    q.offer(start);
	    visited.add(start);
	    distTo.put(start, 0);

	    boolean found = false;
	    while (!q.isEmpty()) {
	        String cur = q.poll();
	        for (String next : d.adj(cur)) {
	            if (visited.contains(next)) continue;
                
                int dist = distTo.getOrDefault(next, 0);
                
                dist = distTo.get(cur) + 1;
                distTo.put(next, dist);
                visited.add(next);
                q.offer(next);
                
                if (next.equals(end)) {
                    found = true;
                    break;
                }
            }
            
            if (found) break;
	    }
	    
	    return distTo.containsKey(end) ? distTo.get(end) + 1 : 0;
	}
	
	private static class Dict {
	    private final int size;
	    private final Map<String, Set<String>> vs = new HashMap<>();
	    
	    private Dict(ArrayList<String> dict) {
	        size = dict.size();
	        
	        for (int i = 0; i < dict.size(); i++) {
	            for (int j = i + 1; j < dict.size(); j++) {
	                if (!isOneLetterDiff(dict.get(i), dict.get(j)))     
	                    continue;
	                
	                addEdge(dict.get(i), dict.get(j));
	            }
	        }
	    }
	    
        private boolean isOneLetterDiff(String w1, String w2) {
            int cnt = 0;
            for (int i = 0; i < w1.length(); i++) {
                if (w1.charAt(i) != w2.charAt(i))
                    cnt++;

                if (cnt > 1)
                    break;
            }

            return cnt == 1 ? true : false;
        }
    	
	    private void addEdge(String w1, String w2) {
	        Set<String> s = vs.getOrDefault(w1, new HashSet<>());
	        s.add(w2);
	        vs.put(w1, s);
	        
	        s = vs.getOrDefault(w2, new HashSet<>());
	        s.add(w1);
	        vs.put(w2, s);
	    }
	    
	    private Set<String> adj(String word) {
	        return vs.getOrDefault(word, new HashSet<>());
	    }
	    
	    private int size() {
	        return size;
	    }
	}
}
