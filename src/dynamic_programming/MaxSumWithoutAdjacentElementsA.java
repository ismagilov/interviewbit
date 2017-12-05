package dynamic_programming;

/**
* https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
*
* Using two vars with max sum including or excluding an element.
*/
public class MaxSumWithoutAdjacentElementsA {
	public int adjacent(ArrayList<ArrayList<Integer>> arr) {
        if (arr == null || arr.isEmpty()) return 0;
            
	    int lng = arr.get(0).size();
	    if (lng == 0) return 0;
	        
	    int exclMax = 0;
	    int inclMax = Math.max(arr.get(0).get(0), arr.get(1).get(0));
	    for (int i = 1; i < lng; i++) {
	        int nextExclMax = Math.max(exclMax, inclMax);
	        
	        int maxInCol = Math.max(arr.get(0).get(i), arr.get(1).get(i));
	        inclMax = exclMax + maxInCol;
	        
	        exclMax = nextExclMax;
	    }
	    
	    return Math.max(exclMax, inclMax);
	}
}
