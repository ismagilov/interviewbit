package two_pointers;

/**
* https://www.interviewbit.com/problems/container-with-most-water
*/
public class ContainerWittMostWater {
	public int maxArea(ArrayList<Integer> a) {
	    int l = 0, r = a.size() - 1;
	    
	    int maxV = 0;
	    int minW = -1; 
	    while (l < r) {
	        minW = Math.min(a.get(l), a.get(r));
	        maxV = Math.max(maxV, (r - l) * minW);
	        
	        if (a.get(l) < a.get(r))
	            l++;
	        else
	            r--;
	    }
	    
	    return maxV;
	}
}
