package strings;

/**
* https://www.interviewbit.com/problems/longest-palindromic-substring/
*/
public class LongestPalindromicSubstringA {
	public String longestPalindrome(String a) {
	    char[] cs = a.toCharArray();
	    String max = "";
	    for (int i = 0; i < cs.length; i++) {
	        StringBuilder sb = new StringBuilder();
	        for (int j = i; j < cs.length; j++) {
	            sb.append(cs[j]);

	            if (isPalind(sb) && sb.length() > max.length()) 
	                max = sb.toString();
	        }
	    }
	    
	    return max;
	}
	
	private boolean isPalind(StringBuilder sb) {
	    for (int i = 0; i < sb.length() / 2; i++) {
	        if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i))
	            return false;
	    }
	    
	    return true;
	}
}
