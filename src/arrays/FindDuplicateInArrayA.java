package arrays;

import java.util.List;

/**
* https://www.interviewbit.com/problems/find-duplicate-in-array/
* 
* Space O(n)
*/
public class FindDuplicateInArrayA {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    int[] count = new int[a.size()];
	    
	    for (int i = 0; i < a.size(); i++)
	        count[a.get(i)]++;
	    
	    for (int i = 0; i < count.length; i++)
	        if (count[i] > 1)
	            return i;
	        
	    return -1;
	}
}
