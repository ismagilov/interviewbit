package hashing;

/**
* https://www.interviewbit.com/problems/2-sum/
*/
public class 2Sum {
    public ArrayList<Integer> twoSum(final List<Integer> arr, int v) {
	    HashMap<Integer, Integer> map = new HashMap<>();
	    
	    Integer idx1 = -1, idx2 = -1;
	    for (int i = 0; i < arr.size(); i++) {
	        int v1 = arr.get(i);
	        int v2 = v - v1;
	        
	        if (map.containsKey(v2)) {
	            idx1 = map.get(v2);
	            idx2 = i;
	            break;
	        } else if (!map.containsKey(v1)) {
	                map.put(v1, i);
	        }
	    }
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    if (idx1 != -1 && idx2 != -1) {
	        res.add(idx1 + 1);
	        res.add(idx2 + 1);
	    }
	    
	    return res;
    }
}
