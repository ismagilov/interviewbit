package arrays;

/**
* https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
*/
public class MaxSumContiguousSubarrayB {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> a) {
	    return maxSubArray(a, 0, a.size() - 1);
	}
	
	public int maxSubArray(final List<Integer> a, int b, int e) {
	    if (b == e)
            return a.get(b);
        
        int mid = b + (e - b) / 2;
    
        int left = maxSubArray(a, b, mid);
        int right = maxSubArray(a, mid + 1, e);
        
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= b; i--) {
            sum += a.get(i);
            maxLeft = Math.max(maxLeft, sum);
        }
        sum = 0;
        for (int i = mid + 1; i <= e; i++) {
            sum += a.get(i);
            maxRight = Math.max(maxRight, sum);
        }

        int max = Math.max(maxLeft + maxRight, left);
        
        return Math.max(right, max);
	}
}
