package dynamic_programming;

/**
* https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
*
* Using classic dp[].
*/
public class Solution {
	public int adjacent(ArrayList<ArrayList<Integer>> arr) {
	    if (null == arr || arr.isEmpty() || arr.get(0).size() == 0)
	        return 0;
	    int lng = arr.get(0).size();
        int[] dp = new int[lng + 2];
        
        dp[0] = 0;
        dp[1] = 0;
	    for (int i = 0; i < lng; i++) {
	        dp[i + 2] = Math.max(
	                    dp[i + 1], 
	                    dp[i] + Math.max(arr.get(0).get(i), arr.get(1).get(i)));
	    }
	    
	    return dp[lng + 1];
	}
}
