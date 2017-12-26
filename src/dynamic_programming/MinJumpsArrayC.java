/**
* https://www.interviewbit.com/problems/min-jumps-array/
*
* DP approach, passes timing tests. 
*/
public class MinJumpsArrayC {
    public int jump(ArrayList<Integer> arr) {
        if (arr == null || arr.size() <= 1)
            return 0;
            
        int[] dp = new int[arr.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        int i1 = 0, i2 = 1;
        while (i1 < i2 && i1 < arr.size() && i2 < arr.size()) {
            while (i2 < arr.size() && i2 <= i1 + arr.get(i1)) {
                if (dp[i2] > dp[i1] + 1)
                    dp[i2] = dp[i1] + 1;
                    
                i2++;
            }
            i1++;
        }

        return dp[arr.size() - 1] != Integer.MAX_VALUE ? dp[arr.size() - 1] : -1;
    }
}
