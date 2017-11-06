package bit_manipulation;

/**
* https://www.interviewbit.com/problems/divide-integers/
*
* Only bits approach.
*
*/
public class DivideIntegersB {
	public int divide(int dividend, int divisor) {
	    int sign = 1;
	    if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
	        sign = -1;

	    long d1 = dividend;
	    long d2 = divisor;
	    d1 = Math.abs(d1);
	    d2 = Math.abs(d2);
	    
	    long res = 0;
	    long q = 0;
	    for (int i = 31; i >= 0; i--) {
	        if (res + (d2 << i) <= d1) {
	            res += d2 << i;
	            q |= 1L << i;
	        }
	    }

        q *= sign;
        
        if (Integer.MIN_VALUE <= q && q <= Integer.MAX_VALUE)
            return (int)q;
        else
            return Integer.MAX_VALUE;
	}
}
