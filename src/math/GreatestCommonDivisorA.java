package math;

/**
* https://www.interviewbit.com/problems/greatest-common-divisor
*/
public class GreatestCommonDivisorA {
	public int gcd(int a, int b) {
	    if (b == 0)
	        return a;
	        
	    if (a % b == 0)
	        return b;
	    else 
	        return gcd(b, a % b);
	}
}

