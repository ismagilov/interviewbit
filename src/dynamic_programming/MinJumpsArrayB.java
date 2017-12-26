package dynamic_programming;

/**
* https://www.interviewbit.com/problems/min-jumps-array/
*
* DP approach.
*/
public class MinJumpsArrayB {
    public int jump(ArrayList<Integer> arr) {
        if (arr == null || arr.size() <= 1)
            return 0;
            
        int[] dp = new int[arr.size()];
        for (int i = 0; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;
        
        dp[0] = 0;    
        for (int i = 0; i < arr.size() && dp[i] != Integer.MAX_VALUE; i++) {
            for (int jmp = 1; jmp <= arr.get(i) && i + jmp < arr.size(); jmp++) {
                if (dp[i + jmp] > dp[i] + 1) 
                    dp[i + jmp] = dp[i] + 1;
            }
        }
        
        return dp[arr.size() - 1] != Integer.MAX_VALUE ? dp[arr.size() - 1] : -1;
    }
}
