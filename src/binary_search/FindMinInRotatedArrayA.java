package binary_search;

import java.util.List;

/**
 * Compare mid with prev and next using cyclic index
 *
 * https://www.interviewbit.com/problems/rotated-array/
*/
public class FindMinInRotatedArrayA {
	public int findMin(final List<Integer> a) {
		int lng = a.size();
	    int b = 0;
	    int e = lng - 1;
	    
	    while (b <= e) {
	        if (a.get(b) < a.get(e))
	            return a.get(b);
	            
	        int mid = b + (e - b) / 2;
	        
	        int next = (mid + 1) % lng;
	        int prev = (mid - 1 + lng) % lng;
	        
	        if (a.get(mid) <= a.get(next) && a.get(mid) <= a.get(prev))
	            return a.get(mid);
	        else if (a.get(mid) <= a.get(e))
	            e = mid - 1;
	        else if (a.get(mid) >= a.get(b))
	            b = mid + 1;
	    }
	    
	    return -1;
	}
}
