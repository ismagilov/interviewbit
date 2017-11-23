package strings;

/**
* https://www.interviewbit.com/problems/add-binary-strings/
*/
public class AddBinaryStrings {
	public String addBinary(String a, String b) {
	    StringBuilder sb = new StringBuilder();
	    
	    int i = 0;
	    int carry = 0;
	    while (i < a.length() || i < b.length()) {
	        int da = (i < a.length()) ? Character.digit(a.charAt(a.length() - 1 - i), 10) : 0;
	        int db = (i < b.length()) ? Character.digit(b.charAt(b.length() - 1 - i), 10) : 0;
	        
	        int v = da + db + carry;
	        int d = v % 2;
	        carry = v / 2;

	        sb.append(Character.forDigit(d, 10));
	        
	        i++;
	    }
	    
	    if (1 == carry)
	        sb.append(carry);
	        
	    return sb.reverse().toString();
	}
}
