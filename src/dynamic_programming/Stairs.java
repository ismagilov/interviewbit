package dynamic_programming;

/**
* https://www.interviewbit.com/problems/stairs/
*/
public class Stairs {
	public int climbStairs(int N) {
	    if (N == 0 || N == 1)
	        return 1;
	        
	    int dp1 = 1;
	    int dp2 = 1;
	    int res = 0;
	    for (int i = 2; i <= N; i++) {
	        res = dp1 + dp2;
	        dp2 = dp1;
	        dp1 = res;
	    }
	    
	    return res;
	}
}
