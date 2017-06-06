package arrays;

import java.util.ArrayList;

public class KthRowOfPascalsTriangle {
	public ArrayList<Integer> getRow(int a) {
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    res.add(1);
	    if (a == 0)
	        return res;
	    
	    for (int i = 1; i <= a; i++) {
	        ArrayList<Integer> prev = res;
	        res = new ArrayList<Integer>();
	        
	        res.add(1);
	        
	        int idx = 1;
	        while (idx < prev.size()) {
	            res.add(prev.get(idx) + prev.get(idx - 1));
	            idx++;
	        }
	        
	        res.add(1);
	    }
	    
	    return res;
	}
}
