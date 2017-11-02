package dynamic_programming;

/**
* https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/
*
* Common method, works for K buy-sell transactions.
*/
public class BestTimeToBuyAndSellStocksIII {
	public int maxProfit(final List<Integer> prices) {
	    if (null == prices || prices.size() <= 1)
	        return 0;
	    
	    int sz = prices.size();
	    int dp[][] = new int[3][sz];
	    
	    int txNum = 2;
	    int profit = 0;

	    //dp[k][i] = max(dp[k][i - 1], prices[i] - prices[j] + dp[k - 1][j]), 
	    //for all j: [0, i-1]
	    //dp[k][i] = max(dp[k][i - 1], prices[i] + max(dp[k - 1][j] - prices[j])) 
	    for (int k = 1; k <= txNum; k++) {
	        int prevMax = dp[k - 1][0] - prices.get(0);
	        for (int i = 1; i < sz; i++) {
	            dp[k][i] = Math.max(dp[k][i - 1], prices.get(i) + prevMax);
	            prevMax = Math.max(prevMax, dp[k - 1][i] - prices.get(i));
	            
	            profit = Math.max(profit, dp[k][i]);
	        }
	    }
	    
        return profit;
	}
}
