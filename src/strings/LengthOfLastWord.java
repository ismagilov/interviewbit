package strings;

/**
* https://www.interviewbit.com/problems/length-of-last-word/
*/
public class LengthOfLastWord {
	public int lengthOfLastWord(final String a) {
	    int lng = 0;
	    
	    for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == ' ' && lng > 0)
	            break;
	        if (a.charAt(i) != ' ')
	            lng++;
	    }
	    
	    return lng;
	}
}
