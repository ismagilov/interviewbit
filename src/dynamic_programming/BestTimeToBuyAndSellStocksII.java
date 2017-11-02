package dynamic_programming;

/**
* https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/
*/
public class BestTimeToBuyAndSellStocksII {
	public int maxProfit(final List<Integer> a) {
	    int profit = 0;
	    for (int i = 0; i < a.size() - 1; i++) {
	        if (a.get(i) < a.get(i + 1))
	            profit += a.get(i + 1) - a.get(i);
	    }
	    
	    return profit;
	}
}
