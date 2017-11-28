package two_pointers;

/**
* https://www.interviewbit.com/problems/remove-element-from-array/
*/
public class RemoveElementFromArray {
	public int removeElement(ArrayList<Integer> a, int target) {
	    int left = 0, right = 0;
	    
	    while (right < a.size()) {
	        if (a.get(right) != target) {
	            a.set(left, a.get(right));
	            left++;
	        }
	        
	        right++;
	    }

	    return left;
	}
}
