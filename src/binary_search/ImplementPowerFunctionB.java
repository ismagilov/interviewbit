package binary_search;

/**
* https://www.interviewbit.com/problems/implement-power-function/
*
* Power without recursion, iterative approach.
*/
public class ImplementPowerFunctionB {
	public int pow(int x, int n, int d) {
	    if (x == 0)
	        return 0;
	        
	    long res = 1;
	    long base = x;
	    while (n > 0) {
            if (n % 2 == 1) {
                res = (res * base) % d;
                n--;
            } else {
                base = (base * base) % d;
                n /= 2;
            }
	    }

	    return res >= 0 ? (int)res : (int)(d + res);
	}
}
