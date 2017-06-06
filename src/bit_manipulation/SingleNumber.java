package bit_manipulation;

import java.util.List;

/**
* https://www.interviewbit.com/problems/single-number/
*/
public class SingleNumber {
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
	    int res = 0;
	    
	    for (int elem : a) {
	        res = res ^ elem;
	    }
	    
	    return res;
	}
}

