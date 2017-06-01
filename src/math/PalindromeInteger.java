/**
* https://www.interviewbit.com/problems/palindrome-integer/
*/
public class PalindromeInteger {
	public boolean isPalindrome(int a) {
	    if (a < 0)
	        return false;
	    if (a == 0)
	        return true;
	        
	    int lng = (int)(Math.log10(a) + 1);
	    int d = a;
	    int m = (int)Math.pow(10, lng - 1);
	    while (d != 0) {
	        int d1 = d % 10;
            int d2 = d / m;

	        if (d1 != d2)
	            return false;

	        d = (d % m) / 10;
	        m /= 100;
	    }
	    
	    return true;
	}
}
