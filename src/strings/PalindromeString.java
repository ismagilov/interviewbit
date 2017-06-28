package strings;

/**
* https://www.interviewbit.com/problems/palindrome-string/
*/
public class PalindromeString {
	public int isPalindrome(String s) {
	    int i = 0, j = s.length() - 1;
        
        while (i <= j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
                
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return 0;
            
            i++;
            j--;
        }
        
        return 1;
	}
}
