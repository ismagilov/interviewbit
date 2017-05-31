package math;

/**
* https://www.interviewbit.com/problems/all-factors/
*
* If insert is O(N), it is faster to append to end and then sort with O(N*logN).
* O(N*sqrtN) > O(sqrtN) + O(N*logN) (= O(N*logN)).
*/
public class AllFactors {
	public ArrayList<Integer> allFactors(int a) {
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    int i = 1;
	    int idx = 0;
	    while (i * i <= a) {
	        if (a % i == 0) {
	            int a1 = i;
	            int a2 = a / i;
	            
	            if (a1 != a2)
	                res.add(idx, a2);
	            
	            res.add(idx, a1);
	            idx++;
	        }
	        
	        i++;
	    }
	    
	    return res;
	}
}
