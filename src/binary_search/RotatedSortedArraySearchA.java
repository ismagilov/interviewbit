package binary_search;

import java.util.List;

/**
 * https://www.interviewbit.com/problems/rotated-sorted-array-search/
 */
public class RotatedSortedArraySearchA {
	// DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int x) {
	    int b = 0, e = a.size() - 1;
	    
	    while (b <= e) {
	        int mid = b + (e - b) / 2;
	        
	        if (a.get(mid) == x)
	            return mid;
	        else if (a.get(mid) <= a.get(e)) {
	            if (x > a.get(mid) && x <= a.get(e))
	                b = mid + 1;
	            else 
	                e = mid - 1;
	        } else if (a.get(mid) >= a.get(b)) {
	            if (x < a.get(mid) && x >= a.get(b))
	                e = mid - 1;
	            else 
	                b = mid + 1;
	        }
	    }
	    
	    return -1;
	}
}
