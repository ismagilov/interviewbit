package hashing;

import java.util.HashSet;
import java.util.List;

/**
* https://www.interviewbit.com/problems/diffk-ii/
*/
public class DiffkII {
	public int diffPossible(final List<Integer> arr, int diff) {
	    HashSet<Integer> set = new HashSet<>();
	    
	    for (Integer n : arr) {
	        // A[i] - A[j] = k, i != j, so i can be greater than j and vice versa
	        // While we iterate through the array, we need to check that 
	        // set contains current plus diff (A[i] - A[cur] = diff) or
	        // set contains current minus diff (A[cur] - A[i] = diff) 
	        if (set.contains(n + diff) || set.contains(n - diff))
	            return 1;
	        
	        set.add(n);
	    }
	    
	    return 0;
	}
}
