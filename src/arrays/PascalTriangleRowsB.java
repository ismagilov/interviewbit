package arrays;

/**
* https://www.interviewbit.com/problems/pascal-triangle-rows/
*
* More clear code, same idea.
*/
public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
	    ArrayList<Integer> row = new ArrayList<>();
	    row.add(1);
	    if (a > 0)
	        res.add(row);
	    
	    for (int i = 1; i < a; i ++) {
	        ArrayList<Integer> prev = res.get(i - 1);
	        
	        ArrayList<Integer> cur = new ArrayList<>();
	        cur.add(1);
	        for (int j = 0; j < prev.size() - 1; j++)
	            cur.add(prev.get(j) + prev.get(j + 1));
	        cur.add(1);
	        
	        res.add(cur);
	    }
	    
	    return res;
	    
	}
}
