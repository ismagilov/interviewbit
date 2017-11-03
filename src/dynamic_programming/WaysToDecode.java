package dynamic_programming;

/**
* https://www.interviewbit.com/problems/ways-to-decode/
*/
public class WaysToDecode {
	public int numDecodings(String a) {
	    int dp = 0;
	    int dp1 = 0;
	    int dp2 = 1;
	    
	    for (int i = 0; i < a.length(); i++) {
	        int c1 = Character.digit(a.charAt(i), 10);
	        
	        int c2 = 0;
	        if (i > 0)
	            c2 = Integer.valueOf(a.substring(i - 1, i + 1));

            dp = 0;
            if (1 <= c1 && c1 <= 9)
                dp = dp2;
            if (10 <= c2 && c2 <= 26)
                dp += dp1;

            if (dp == 0)
                return 0;

            dp1 = dp2;
            dp2 = dp;
	    }
	    
	    return dp;
	}
}
