package dynamic_programming;

/**
* https://www.interviewbit.com/problems/repeating-subsequence/
*/
public class RepeatingSubSequence {
    public int anytwo(String str) {
        int lng = str.length();
        int[][] dp = new int[lng + 1][lng + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i != j && str.charAt(i - 1) == str.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else    
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }        
        
        return dp[lng][lng] >= 2 ? 1 : 0;
    }
}
