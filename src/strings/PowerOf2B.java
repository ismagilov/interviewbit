/**
* https://www.interviewbit.com/problems/power-of-2/
*/
public class PowerOf2B {
	public int power(String a) {
        if (a.compareTo("1") == 0)
            return 0;
        
        String div2 = a;
        while (div2.compareTo("1") != 0 && (div2.charAt(div2.length() - 1) - '0') % 2 == 0) {
            div2 = divide(div2, 2);
        }
        
        if (div2.compareTo("1") == 0)
            return 1;
        else 
            return 0;
	}
	
	private String divide(String s, int divisor) {
	    StringBuilder sb = new StringBuilder();
	    
	    int rem = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int d = s.charAt(i) - '0';
            
            int v = d + rem * 10;

	        int res = v / divisor;
	        rem = v % divisor;
	        
	        sb.append(res);
	    }
	    
	    while (sb.charAt(0) == '0')
	        sb.deleteCharAt(0);

	    return sb.toString();
	}
}
