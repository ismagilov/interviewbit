package dynamic_programming;

/**
* https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/
*/
public class BestTimeToBuyAndSellStocksI {
	public int maxProfit(final List<Integer> a) {
	    int min = Integer.MAX_VALUE;
	    
	    int profit = 0;
	    for (int i = 0; i < a.size(); i++) {
	        if (a.get(i) < min)
	            min = a.get(i);
	        else
	            profit = Math.max(profit, a.get(i) - min);
	    }
	    
	    return profit;
	}
}
