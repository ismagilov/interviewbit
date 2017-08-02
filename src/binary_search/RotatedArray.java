package binary_search;

import java.util.List;

/**
* https://www.interviewbit.com/problems/rotated-array/
*/
public class RotatedArray {
	// DO NOT MODIFY THE LIST
	public int findMin(final List<Integer> a) {
	    int low = 0;
	    int high = a.size() - 1;
	    
	    while (low <= high) {
	        if (a.get(low) < a.get(high))
	            return a.get(low);
	            
	        int mid = low + (high - low) / 2;
	        
	        int next = (mid + 1) % a.size();
	        int prev = (mid - 1 + a.size()) % a.size();
	        
	        if (a.get(mid) <= a.get(next) && a.get(mid) <= a.get(prev))
	            return a.get(mid);
	        else if (a.get(mid) <= a.get(high))
	            high = mid - 1;
	        else if (a.get(mid) >= a.get(low))
	            low = mid + 1;
	    }
	    
	    return -1;
	}
}
