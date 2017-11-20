package binary_search;

/**
* https://www.interviewbit.com/problems/median-of-array/
*
* Use binary search on smaller array to find correct partition.
*/
public class MedianOfArrayB {
	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	    if (a.size() <= b.size())
	        return findMedian(a, b);
	    else 
	        return findMedian(b, a);
	}

    private double findMedian(final List<Integer> a1, final List<Integer> a2) {
        int sz1 = a1.size(), sz2 = a2.size();
        int b = 0, e = a1.size();
        
        while (b <= e) {
            int p1 = b + (e - b) / 2;
            int p2 = (sz1 + sz2 + 1) / 2 - p1;
            
            int leftMax1 = (p1 == 0) ? Integer.MIN_VALUE : a1.get(p1 - 1);
            int rightMin1 = (p1 == sz1) ? Integer.MAX_VALUE : a1.get(p1);
            int leftMax2 = (p2 == 0) ? Integer.MIN_VALUE : a2.get(p2 - 1);
            int rightMin2 = (p2 == sz2) ? Integer.MAX_VALUE : a2.get(p2);

            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1)
                if ((sz1 + sz2) % 2 == 0)
                    return (Math.min(rightMin1, rightMin2) + Math.max(leftMax1, leftMax2)) / 2.0; 
                else
                    return Math.max(leftMax1, leftMax2);
            else if (leftMax1 > rightMin2)
                e = p1 - 1;
            else 
                b = p1 + 1;
        }
        
        throw new IllegalStateException();
    }
}
