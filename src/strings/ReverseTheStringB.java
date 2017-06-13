/**
* https://www.interviewbit.com/problems/reverse-the-string/
*/
public class ReverseTheStringB {
	public String reverseWords(String a) {
	    StringBuilder sb = new StringBuilder();

        int end = a.length() - 1;
        int b = -1, e = -1;
        for (int i = end; i >= 0; i--) {
            if (a.charAt(i) != ' ' && e == -1)
                e = i + 1;
            else if (e != -1 && a.charAt(i) == ' ') {
                b = i + 1;

                if (sb.length() > 0 && b < e)
                    sb.append(' ');    
                sb.append(a.substring(b, e));
                b = -1;
                e = -1;
            }
        }

        // Last string (in order of iteration) ends at the begining os original string
        if (e != -1 && b == -1)
            b = 0;
        if (sb.length() > 0 && b < e)
            sb.append(' ');    
        sb.append(a.substring(b, e));

	    return sb.toString();
	}

}
