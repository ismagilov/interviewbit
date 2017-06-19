package binary_search;

/**
* https://www.interviewbit.com/problems/count-element-occurence/
*/
public class CountElementOccurence {
	// DO NOT MODIFY THE LIST
	public int findCount(final List<Integer> a, int b) {
	    int s = bs(a, b, true); 
	    int f = bs(a, b, false);
	    
	    if (f == -1 || s == -1)
	        return 0;
	    else 
	        return f - s + 1;
	}
	
	private int bs(List<Integer> arr, int n, boolean first) {
	    int b = 0, e = arr.size() - 1;
	    
	    int res = -1;
	    while (b <= e) {
	        int mid = b + (e - b) / 2;
	        
	        if (arr.get(mid) == n) {
	            res = mid;
	            if (first)
	                e = mid - 1;
	            else
	                b = mid + 1;
	        } else if (arr.get(mid) < n)
	            b = mid + 1;
	        else 
	            e = mid - 1;
	    }
	    
	    return res;
	}
}
