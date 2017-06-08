package strings;

/**
* https://www.interviewbit.com/problems/longest-palindromic-substring/
*/
public class LongestPalindromicSubstringB {
    private int max, start;
    
	public String longestPalindrome(String a) {
	    
	    for (int i = 0; i < a.length(); i++) {
	        expand(a, i, i);
	        expand(a, i, i + 1);
	    }
	    
	    return a.substring(start, start + max);
	}
	
	private void expand(String s, int b, int e) {
	    while(b >= 0 && e < s.length() && s.charAt(b) == s.charAt(e)) {
	        b--;
	        e++;
	    } 
	    
	    if (max < e - b - 1) {
	        max = e - b - 1;
	        start = b + 1;
	    }
	}
}
