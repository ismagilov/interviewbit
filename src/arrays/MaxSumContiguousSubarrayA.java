package arrays;

/**
* https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
*/
public class MaxSumContiguousSubarrayA {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> a) {
	    if (a.size() == 0)
	        return -1000000000;
	        
	    int max = a.get(0);
	    int slice = a.get(0);
	    
	    for (int i = 1; i < a.size(); i++) {
	        slice = Math.max(slice + a.get(i), a.get(i));
	        max = Math.max(max, slice);
	    }
	    
	    return max;
	}
}
