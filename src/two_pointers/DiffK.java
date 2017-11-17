package two_pointers;

/**
* https://www.interviewbit.com/problems/diffk/
*/
public class DiffK {
	public int diffPossible(ArrayList<Integer> arr, int k) {
	    int i = 0, j = 0;
	    
	    while (i < arr.size() && j < arr.size()) {
	        if (i == j) {
	            j++;
	            continue;
	        }
	       
	        int diff = arr.get(j) - arr.get(i);
	        if (diff == k)
	            return 1;
	        else if (diff > k) 
	            i++;
	        else
	            j++;
	    }
	    
	    return 0;
	}
}
