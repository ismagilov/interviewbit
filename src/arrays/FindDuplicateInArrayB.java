package arrays;

/**
* https://www.interviewbit.com/problems/find-duplicate-in-array/
*
* Solution with space O(sqrtN)
*/
public class FindDuplicateInArrayB {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    int range = a.size() - 1;
	    
	    int sqrt = (int)Math.sqrt(range); //numbers: 1 ... n, size: n + 1
	    int sz = sqrt;
	    
	    if (sqrt * sqrt < range)
	        sz++;
	    
	    int[] count = new int[sz];
	    
	    for (int i = 0; i < a.size(); i++)
	        count[(a.get(i) - 1) / sz]++;
	    
        int repeating = -1;
        int lastCnt = range % sz;
        int rangesNum = lastCnt == 0 ? range / sz : range / sz + 1;
        for (int i = 0; i < rangesNum; i++) {
            if (i + 1 == rangesNum && lastCnt != 0 && count[i] > lastCnt) {
                repeating = i;
            } else if (count[i] > sz) {
                repeating = i;
            }
        }

	    Arrays.fill(count, 0);
	    
	    for (int i = 0; i < a.size(); i++) {
	        if (repeating * sz < a.get(i) && a.get(i) <= (repeating + 1) * sz) {
	            int idx = (a.get(i) - 1) - (repeating * sz);
	            if (count[idx] == 1)
	                return a.get(i);
	            else
	                count[idx] = 1;
	        }
	            
	    }

	    return -1;
	}
}
