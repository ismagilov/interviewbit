/**
* https://www.interviewbit.com/problems/reverse-the-string/
*/
public class ReverseTheStringA {
	public String reverseWords(String a) {
	    StringBuilder sb = new StringBuilder();

        int i = a.length() - 1; 
        while (i >= 0) {
            while (i >= 0 && a.charAt(i) == ' ')
                i--;
            
            StringBuilder w = new StringBuilder();
            while (i >= 0 && a.charAt(i) != ' ') {
                w.append(a.charAt(i));
                i--;
            }
            
            if (sb.length() > 0 && w.length() > 0)
                sb.append(' ');
                
            sb.append(w.reverse().toString());
        }
	    
	    return sb.toString();
	}
}
