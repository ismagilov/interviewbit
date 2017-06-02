package bit_manipulation;

/**
* https://www.interviewbit.com/problems/number-of-1-bits/
*/
public class NumberOf1Bits {
	public int numSetBits(long a) {
	    
	    int cnt = 0;
	    while (a != 0) {
	        a = a & (a - 1);
	        cnt++;
	    }
	    
	    return cnt;
	}
}
