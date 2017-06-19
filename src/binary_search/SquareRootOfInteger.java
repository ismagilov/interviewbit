package binary_search;

/**
* https://www.interviewbit.com/problems/square-root-of-integer/
*/
public class Solution {
	public int sqrt(int a) {
	    if (a == 0)
	        return 0;
	        
	    int b = 1, e = a;
	    int res = 0;
	    while (b <= e) {
	        int mid = b + (e - b) / 2;

	        if (mid <= a / mid) {
	            res = mid;
	            b = mid + 1;
	        } else {
	            e = mid - 1;
	        }
	        
	    }
	    
        return res;
	}
}
