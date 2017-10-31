/**
* https://www.interviewbit.com/problems/atoi/
*/
public class Atoi {
	public int atoi(final String str) {
	    if (null == str || str.length() == 0)
	        return 0;
	        
	    char[] chs = str.toCharArray();
	    int i = 0;
	    while (!Character.isDigit(chs[i]) && chs[i] != '-' && chs[i] != '+') {
	        if (Character.isWhitespace(chs[i]))
	            i++;
	        else
	            return 0;
	    }
	    
	    boolean isNegative = false;
	    if (chs[i] == '-') {
	        isNegative = true;
	        i++;
	    } else if (chs[i] == '+') {
	        i++;
	    }

        StringBuilder digits = new StringBuilder();
	    while (i < chs.length && Character.isDigit(chs[i])) {
	        digits.append(chs[i]);
	        i++;
	    }

        int res = 0;
	    for (int j = 0; j < digits.length(); j++) {
	        int d = digits.charAt(j) - '0';
	        
	        if (isNegative) {
	            if (-res < Integer.MIN_VALUE / 10 || 
	                (-res == Integer.MIN_VALUE / 10 && d > (Integer.MIN_VALUE % 10)))
	                return Integer.MIN_VALUE;
	        } else {
	            if (res > Integer.MAX_VALUE / 10 || 
	                (res == Integer.MAX_VALUE / 10 && d > (Integer.MAX_VALUE % 10)))
	                return Integer.MAX_VALUE;
	        }

	        res *= 10;
	        res += d;
	    }
	    
	    return isNegative ? -1 * res : res;
	}
}
