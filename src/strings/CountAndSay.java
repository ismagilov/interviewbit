package strings;

/**
* https://www.interviewbit.com/problems/count-and-say/
*/
public class CountAndSay {
	public String countAndSay(int n) {
	    String res = "1";
	    
	    while (n > 1) {
	        StringBuilder sb = new StringBuilder();
	        int cnt = 0;
	        char digit = '0';
	        
	        for (int i = 0; i < res.length(); i++) {
	            if (res.charAt(i) == digit) {
	                cnt++;
	            } else {
	                if (digit != '0')
	                    sb.append(cnt).append(digit);
	                digit = res.charAt(i);
	                cnt = 1;
	            }
	            
	            if (i == res.length() - 1) {
	                sb.append(cnt).append(digit);
	            }
	        }
	        
	        n--;
	        res = sb.toString();
	    }
	    
	    return res;
	}
}
