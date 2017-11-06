package bit_manipulation;

/**
* https://www.interviewbit.com/problems/divide-integers/
*/
public class DivideIntegersA {
	public int divide(int dividend, int divisor) {
	    if (divisor == 0)
	        return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (divisor == 1)
            return dividend;
        if (divisor == -1)
            return -dividend;
            
	    // d1 / d2 = q
	    long d1 = dividend;
	    long d2 = divisor;
	    long q = 1;

	    int sign = 1;
	    if (d1 < 0) {
	        sign = -1;
	        d1 = -d1;
	    }
	    if (d2 < 0) {
	        sign *= -1;
	        d2 = -d2;
	    }

	    if (d2 > d1)
	        return 0;

	    long tempDivisor = d2;
	    while ((tempDivisor << 1) < d1) {
	        tempDivisor <<= 1;
	        q <<= 1;
	    }
	    while (tempDivisor + d2 <= d1) {
	        tempDivisor += d2;
	        q += 1;
	    }

        return (int)(q * sign);
	}
}
