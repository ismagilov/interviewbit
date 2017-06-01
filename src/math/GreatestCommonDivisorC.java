package math;

/**
* https://www.interviewbit.com/problems/greatest-common-divisor/
*/
public class GreatestCommonDivisorC {
	public int gcd(int a, int b) {
	    if (a == 0)
	        return b;
	    if (b == 0)
	        return a;
	        
	    return gcdBinary(a, b, 1);
	}
	
	public int gcdBinary(int a, int b, int res) {
	    if (a == b)
	        return res * a;
	        
	    if (a % 2 == 0 && b % 2 == 0)
	        return gcdBinary(a / 2, b / 2, res * 2);
	    else if (a % 2 == 0)
	        return gcdBinary(a / 2, b, res);
  	    else if (b % 2 == 0)
	        return gcdBinary(a, b / 2, res);
        else if (a > b)
            return gcdBinary(a - b, b, res);
        else
            return gcdBinary(a, b - a, res);
	}
}
