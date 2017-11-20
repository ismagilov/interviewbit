package binary_search;

/**
* https://www.interviewbit.com/problems/median-of-array
*
* Solved using method for searching K-th element in two sorted arrays.
*/
public class MedianOfArrayA {
	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	    int l = (a.size() + b.size() + 1) / 2;
	    int r = (a.size() + b.size() + 2) / 2;
	    
	    return getKth2(a, 0, a.size() - 1, b, 0, b.size() - 1, 9);         
	}
	
	private int getKth(List<Integer> a, int startA, List<Integer> b, int startB, int k) {
	    if (startA > a.size() - 1) return b.get(startB + k - 1);
	    if (startB > b.size() - 1) return a.get(startA + k - 1);
	    if (k == 1) return Math.min(a.get(startA), b.get(startB));
	    
	    int midA = Integer.MAX_VALUE, midB = Integer.MAX_VALUE;
	    if (startA + k/2 - 1 < a.size()) midA = a.get(startA + k/2 - 1);
	    if (startB + k/2 - 1 < b.size()) midB = b.get(startB + k/2 - 1);
	    
	    if (midA < midB)
	        return getKth(a, startA + k/2, b, startB, k - k/2);
	    else
	        return getKth(a, startA, b, startB + k/2, k - k/2);
	}
}
