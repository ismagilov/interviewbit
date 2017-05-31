package math;

/**
* https://www.interviewbit.com/problems/reverse-integer/
*/
public class ReverseInteger {
	public int reverse(int a) {
	    int sign = 1;
	    long res = 0;
	    
	    if (a < 0) {
	        sign = -1;
	        a = -a;
	    }
	    
	    int v = a;
	    while (v != 0) {
	        int d = v % 10;
	        v /= 10;
	        res = res * 10 + d;
	    }
	    
	    //2147483647
	    //-2147483648
	    if (res >= Integer.MAX_VALUE)
	        return 0;

	    return sign * (int)res;
	}
}
