package two_pointers;

import java.util.ArrayList;
import java.util.List;

/**
* https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
*/
public class IntersectionOfSortedArrays {
	// DO NOT MODIFY THE LISTS
	public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    int i1 = 0, i2 = 0;
	    while (i1 < a.size() && i2 < b.size()) {
	        //System.out.println(i1 + " " + i2 + " " + a.get(i1) + " " + b.get(i2));
	        if (a.get(i1).equals(b.get(i2))) {
	            res.add(a.get(i1));
	            i1++;
	            i2++;
	        } else if (a.get(i1) < b.get(i2)) {
	            i1++;
	        } else if (a.get(i1) > b.get(i2)) {
	            i2++;
	        }
	    }
	    
	    return res;
	}
}
