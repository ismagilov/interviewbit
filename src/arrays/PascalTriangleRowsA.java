package arrays;

import java.util.ArrayList;

/**
* https://www.interviewbit.com/problems/pascal-triangle-rows/
*/
public class PascalTriangleRowsA {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    ArrayList<Integer> row = new ArrayList<>();
	    row.add(1);
	    
	    if (a > 0)
	        res.add(row);
	    
	    for (int i = 1; i < a; i ++) {
	        ArrayList<Integer> prev = res.get(i - 1);
	        ArrayList<Integer> cur = new ArrayList<>();
	        for (int j = 0; j <= prev.size(); j++) {
	            if (j == 0 || j == prev.size())
	                cur.add(1);
	            else {
	                cur.add(prev.get(j) + prev.get(j - 1));
	            }
	        }
	        
	        res.add(cur);
	    }
	    
	    return res;   
	}
}
