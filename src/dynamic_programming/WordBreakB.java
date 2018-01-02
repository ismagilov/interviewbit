package dynamic_programming;

/**
* https://www.interviewbit.com/problems/word-break/
*/
public class WordBreakB {
    public int wordBreak(String s, ArrayList<String> d) {
        int sz = s.length();
        boolean[] dp = new boolean[sz + 1];
        
        dp[0] = true; //dp[i] == true, if s[0...i-1] can be splitted
        for (int i = 1; i <= sz; i++) {
            for (String ds : d) {
                int lng = ds.length();
                if (lng > i) continue;
                
                if (dp[i - lng] == false) continue;

                //"myint": i = 5, ds = "int", lng = 3, dp[2] == true
                //s.substring(2 (== 5 - 3), 5)
                if (ds.equals(s.substring(i - lng, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[sz] ? 1 : 0;
    }
    
    private int wordBreakUsingSet(String s, ArrayList<String> d) {
        HashSet<String> dict = new HashSet<>(d);

        int sz = s.length();
        boolean[] dp = new boolean[sz + 1];

        dp[0] = true;
        for (int j = 1; j <= sz; j++) {
            for (int i = 0; i < j; i++) {
                String sub = s.substring(i, j);
                if (dp[i] && d.contains(sub)) {
                    dp[j] = true;
                    break;
                }
            }
        } 
        
        return dp[sz] ? 1 : 0;
    }
}
