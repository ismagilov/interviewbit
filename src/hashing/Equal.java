package hashing;

/**
* https://www.interviewbit.com/problems/equal/
*/
public class Equal {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        HashMap<Integer, Pair> hash = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                int s = a.get(i) + a.get(j);
                
                if (hash.containsKey(s)) {
                    Pair p = hash.get(s);
                    
                    ArrayList<Integer> found = new ArrayList<>();
                    if (p.i < i && p.j != i && p.j != j) {
                        found.add(p.i);
                        found.add(p.j);
                        found.add(i);
                        found.add(j);
                        
                        if (res.isEmpty()) {
                            res = found;
                        } else {
                            boolean foundLess = false;
                            //res: 0 1 3 2; found: 1 2 2 7
                            for (int k = 0; k < found.size(); k++) {
                                if (res.get(k) < found.get(k))
                                    break;
                                else if (found.get(k) < res.get(k)) {
                                    foundLess = true;
                                    break;
                                }
                            }
                            
                            if (foundLess)
                                res = found;
                        }
                    }
                } else {
                    hash.put(s, new Pair(i, j));
                }     
            }
        }

        return res;
    }
    
    private static class Pair {
        private final int i;
        private final int j;
        
        private Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
