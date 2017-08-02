package backtracking;

import java.util.ArrayList;

/**
* https://www.interviewbit.com/problems/combinations/
*/
public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    if (k > n)
	        return new ArrayList<>();
	    
	    return combinations(new ArrayList<>(), 1, n, k);
	}
	
	private ArrayList<ArrayList<Integer>> combinations(ArrayList<Integer> prefix, int s, int n, int k) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    
	    if (prefix.size() == k) {
	        res.add(prefix);
	        return res;
	    }
	    
	    for (int i = s; i <= n; i++) {
	        ArrayList<Integer> p = new ArrayList<>(prefix);
	        p.add(i);
	        res.addAll(combinations(p, i + 1, n, k));
	    }
	        
        return res;
	}
}


