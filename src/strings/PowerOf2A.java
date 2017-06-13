package strings;

/**
* https://www.interviewbit.com/problems/power-of-2/
*/
public class PowerOf2A {
	public int power(String a) {
	    String po2 = "8";

	    while(po2.length() <= a.length()) {
	        po2 = multiply2(po2);

	        if (po2.compareTo(a) == 0)
	            return 1;
	    }
	    
	    return 0;
	}
	
	private String multiply2(String s) {
	    StringBuilder sb = new StringBuilder();
	    
	    int carry = 0;
	    for (int i = s.length() - 1; i >= 0; i--) {
	        int d = s.charAt(i) - '0';

            int m = d * 2 + carry;
            
	        int res = m % 10;
	        sb.append(res);
	        carry = m / 10;
	    }
	    
	    if (carry == 1)
	        sb.append(carry);

	    return sb.reverse().toString();
	}
}
