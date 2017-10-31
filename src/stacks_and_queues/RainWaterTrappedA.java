package stacks_and_queues;

/**
* https://www.interviewbit.com/problems/rain-water-trapped/
*
* One pass solution.
*/
public class RainWaterTrappedA {
	// DO NOT MODIFY THE LIST
	public int trap(final List<Integer> a) {
	    if (a.size() <= 2)
	        return 0;
	    
	    int left = 0; 
	    int right = a.size() - 1;
	    int leftMax = 0;
	    int rightMax = 0;
	    
	    int v = 0;
	    while (left < right) {
	        if (a.get(left) > leftMax)
	            leftMax = a.get(left);
	            
	        if (a.get(right) > rightMax)
	            rightMax = a.get(right);
	        
	        if (leftMax >= rightMax) {
	            v += rightMax - a.get(right);
	            right--;
	        } else {
	            v += leftMax - a.get(left);
	            left++;
	        }
	    }
	    
	    return v;
	}
}

