package dynamic_programming;

/**
* https://www.interviewbit.com/problems/unique-paths-in-a-grid/
*/
public class UniquePathsInAGrid {
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
	    if (null == a || 0 == a.size() || 0 == a.get(0).size())
	        return 0;
	   
	    int rs = a.size(), cs = a.get(0).size();
	    
	    int[][] dp = new int[rs][cs];
	    for (int r = 0; r < rs; r++) {
	        for (int c = 0; c < cs; c++) {
	            if (r == 0 && c == 0 && a.get(r).get(c) == 0)
	                dp[r][c] = 1;
	            else if (a.get(r).get(c) == 0) {
	                int fromLeft = (c == 0) ? 0 : dp[r][c - 1];
	                int fromTop = (r == 0) ? 0 : dp[r - 1][c];
                    dp[r][c] = fromLeft + fromTop;
	            } else {
                    dp[r][c] = 0;
                }
	        }
	    }
	    
	    return dp[rs - 1][cs - 1];
	}
}
