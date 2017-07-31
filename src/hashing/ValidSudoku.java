/**
* https://www.interviewbit.com/problems/valid-sudoku/
*/
public class ValidSudoku {
	public int isValidSudoku(final List<String> a) {
	    HashMap<Integer, Set<Integer>> rows = new HashMap<>();
	    HashMap<Integer, Set<Integer>> cols = new HashMap<>();
	    HashMap<Integer, Set<Integer>> qs = new HashMap<>();
	    
	    for (int r = 0; r < 9; r++) {
	        for (int c = 0; c < 9; c++) {
	            char ch = a.get(r).charAt(c);
	            if (ch == '.')
	                continue;
	                
	            int d = ch - '0';
	            int qn = (c / 3) + 3 * (r / 3);
	            
                if (!addOfFail(rows, r, d) || !addOfFail(cols, c, d) || !addOfFail(qs, qn, d))
                    return 0;
	        }
	    }
	    
	    return 1;
	}
	
	private boolean addOfFail(HashMap<Integer, Set<Integer>> ht, int idx, int d) {
	    if (ht.containsKey(idx) && ht.get(idx).contains(d))
            return false;

        if (ht.containsKey(idx)) {
            ht.get(idx).add(d);
        } else {
            Set<Integer> vs = new HashSet<>();
            vs.add(d);
            ht.put(idx, vs);
        }
    
        return true;
	}
}
