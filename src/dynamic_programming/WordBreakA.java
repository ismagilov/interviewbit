package dynamic_programming;

/**
* https://www.interviewbit.com/problems/word-break/
*
* Straightforward DP solution. Exceed time limit.
*/
public class WordBreakA {
    public int wordBreak(String s, ArrayList<String> d) {
        HashSet<String> dict = new HashSet<>(d);

        int sz = s.length();
        boolean[][] dp = new boolean[sz][sz];

        for (int l = 1; l <= sz; l++) {
            for (int i = 0; i <= sz - l; i++) {
                int j = i + l - 1;
                
                if (d.contains(s.substring(i, j + 1))) {
                    dp[i][j] = true;
                    continue;
                }
            
                for (int k = i; k < j; k++) {
                    if (dp[i][k] && dp[k + 1][j]) {
                        dp[i][j] = true;
                        break;
                    }        
                }
            }
        }

        return dp[0][sz - 1] ? 1 : 0;
    }
}
