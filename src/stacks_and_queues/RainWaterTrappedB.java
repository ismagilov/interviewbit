package stacks_and_queues;

/**
* https://www.interviewbit.com/problems/rain-water-trapped/
*
* Very straightforward three-pass solution.
*/
public class RainWaterTrappedB {
	// DO NOT MODIFY THE LIST
	public int trap(final List<Integer> a) {
	    int sz = a.size();
	    int[] leftMaxs = new int[sz];
	    int[] rightMaxs = new int[sz];

	    leftMaxs[0] = a.get(0);
	    for (int i = 1; i < a.size(); i++)
	        leftMaxs[i] = Math.max(a.get(i), leftMaxs[i - 1]);
	    
	    rightMaxs[a.size() - 1] = a.get(a.size() - 1);    
	    for (int i = a.size() - 2; i >= 0; i--)
	        rightMaxs[i] = Math.max(a.get(i), rightMaxs[i + 1]);
	    
	    int v = 0;
	    for (int i = 0; i < a.size(); i++)
	        v += Math.min(leftMaxs[i], rightMaxs[i]) - a.get(i);
	    
	    return v;
	}
}
