package binary_search;

/**
* https://www.interviewbit.com/problems/search-for-a-range/
*/
public class SearchForARangeA {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    int s = bs(a, b, true);
	    int e = bs(a, b, false);
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    res.add(s);
	    res.add(e);
	    
	    return res;
	}
	
	private int bs(List<Integer> arr, int x, boolean first) {
	    int b = 0, e = arr.size() - 1;
	    
	    int res = -1;
	    while (b <= e) {
	        int mid = b + (e - b) / 2;

	        if (arr.get(mid) == x) {
	            res = mid;
	            
	            if (first)
	                e = mid - 1;
	            else
	                b = mid + 1;
	        } else if (arr.get(mid) < x) {
	            b = mid + 1;
	        } else {
	            e = mid - 1;
	        }
	    }
	    
	    return res;
	}
}
