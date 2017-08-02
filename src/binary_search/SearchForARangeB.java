package binary_search;

import java.util.ArrayList;
import java.util.List;

/**
* https://www.interviewbit.com/problems/search-for-a-range/
*/
public class SearchForARangeB {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> arr, int x) {
	    int b = 0, e = arr.size() - 1;
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    res.add(-1);
	    res.add(-1);

	    while (b < e) {
	        int mid = b + (e - b) / 2;

	        if (arr.get(mid) < x)
	            b = mid + 1;
	        else
	            e = mid;
	    }
	    
	    if (arr.get(b) != x)
            return res;
        else
            res.set(0, b);
	    
	    e = arr.size() - 1;
	    while (b < e) {
	        int mid = b + (e - b) / 2 + 1; // Move a middle to the right

            if (arr.get(mid) > x)
	            e = mid - 1;
	        else
	            b = mid;
	    }
	    
        res.set(1, e);

	    return res;
	}

}
