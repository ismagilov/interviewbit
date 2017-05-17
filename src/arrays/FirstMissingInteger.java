package arrays;

/**
* https://www.interviewbit.com/problems/first-missing-integer/
*/
public class FirstMissingInteger {
	public int firstMissingPositive(ArrayList<Integer> a) {
	    Integer missing = 1;
	    
	    for (int i = 0; i < a.size(); i++) {
	        int idx = i;
	        int val = a.get(idx);
            
            //1 <= val && val <= a.size() - we need to count
            //val - 1 != idx - value is not on its place
            //a.get(val - 1) != val - index to where we can move already has correct number
	        while (1 <= val && val <= a.size() && val - 1 != idx && a.get(val - 1) != val) {
	            int moveToIdx = val - 1;
	            
	            int tmp = a.get(moveToIdx);
	            a.set(moveToIdx, val);
	            a.set(idx, tmp);
	            
	            val = tmp;
	        }
	    }

	    for (int i = 0; i < a.size(); i++) {
	        if (i + 1 != a.get(i))
	            return i + 1; 
	    }

	    return a.size() + 1;
	}
}
