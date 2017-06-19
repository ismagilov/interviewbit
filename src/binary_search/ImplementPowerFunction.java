package binary_search;

/**
* https://www.interviewbit.com/problems/implement-power-function/
*/
public class ImplementPowerFunction {
	public int pow(int x, int n, int d) {
	    if (x == 0)
	        return 0;
	        
	    if (d == 1)
	        return 0;
	    
	    int res = (int)power(x, n, d);
	    
	    return res > 0 ? res : d + res;
	}
	
	private long power(int x, int n, long d) {
	    if (n == 0)
	        return 1;
	        
	    if (n == 1)
	        return x;
	        
	    long p = power(x, n/2, d);
	    if (n % 2 == 0)
	        return (p * p) % d;
	    else 
	        return (((p * p) % d) * x) % d;
	}
}
