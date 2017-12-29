package graphs;

/**
* https://www.interviewbit.com/problems/word-ladder-ii/
*/
public class WordLadderII {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> wordList) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);
        ArrayDeque<PathNode> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        visited.add(start);
        q.offer(new PathNode(start, null));
        
        boolean reached = false;
        while (!q.isEmpty()) {
            ArrayDeque<PathNode> nextQueue = new ArrayDeque<>();
            Set<String> nextVisited = new HashSet<>();
            
            while(!q.isEmpty()) {
                PathNode cur = q.poll();
                
                if (cur.word.equals(end)) {
                    reached = true;
                    
                    ArrayDeque<String> track = new ArrayDeque<>();
                    track.push(cur.word);
                    PathNode last = cur.prev;
                    while (last != null) {
                        track.push(last.word);
                        last = last.prev;
                    }
                    res.add(new ArrayList<>(track));
                }
            
                for (String w : dict) {
                    if (visited.contains(w) || !isConnected(cur.word, w)) 
                        continue;

                    nextVisited.add(w);
                    nextQueue.offer(new PathNode(w, cur));
                }
            }

            if (!reached) {
                q = nextQueue;
                visited.addAll(nextVisited);
            }
        }

        return res;
    }

    private boolean isConnected(String w1, String w2) {
        int cnt = 0;
        
        if (w1.equals(w2)) return false;
        
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) cnt++;
            if (cnt == 2) return false;
        } 

        return true;
    }
    
    private static class PathNode {
        private String word;
        private PathNode prev;
        
        private PathNode(String w, PathNode p) {
            this.word = w;
            this.prev = p;
        }
    }
}

     
