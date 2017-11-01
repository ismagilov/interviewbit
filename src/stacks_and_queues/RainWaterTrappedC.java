package stacks_and_queues;

/**
* https://www.interviewbit.com/problems/rain-water-trapped/
*
* One-pass solution with clearer logic.
*/
public class RainWaterTrappedC {
	// DO NOT MODIFY THE LIST
	public int trap(final List<Integer> a) {
	    int left = 0;
	    int right = a.size() - 1;
	    int leftMax = 0;
	    int rightMax = 0;
	    int v = 0;
	    
	    while (left < right) {
	        if (a.get(left) <= a.get(right)) {
	            if (a.get(left) > leftMax)
	                leftMax = a.get(left);
	            else 
	                v += leftMax - a.get(left);
	                
	            left++;
	        } else {
	            if (a.get(right) > rightMax)
	                rightMax = a.get(right);
	            else
	                v += rightMax - a.get(right);
	                
	            right--;
	        }
	    }
	    
        return v;	    
	}
}
