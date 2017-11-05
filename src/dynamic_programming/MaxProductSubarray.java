package dynamic_programming;

/**
* https://www.interviewbit.com/problems/max-product-subarray/
*/
public class MaxProductSubarray {
	public int maxProduct(final List<Integer> arr) {
	    if (arr.size() == 1)
	        return arr.get(0);
	        
	    int maxRes = arr.get(0);
	    int min = arr.get(0);
	    int max = arr.get(0);
	    for (int i = 1; i < arr.size(); i++) {
	        int r1 = arr.get(i);
	        int r2 = min * r1;
	        int r3 = max * r1;
	        
	        min = Math.min(r1, Math.min(r2, r3));
	        max = Math.max(r1, Math.max(r2, r3));
	        
	        maxRes = Math.max(maxRes, max);
	    }
	    
	    return maxRes;
	}
}
