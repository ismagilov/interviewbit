package strings;

/**
* https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
*
* Non optimal solution: O(N^2), can be O(N)?...
*/
public class MinimumCharactersRequiredToMakeAStringPalindromicA {
    private int max;

    public int solve(String A) {
        for (int i = 0; i < A.length() / 2  + 1; i++) {
            expand(A, i, i);
            expand(A, i, i + 1);
        }

        return A.length() - max;
    }

    private void expand(String A, int b, int e) {
        boolean found = false;
        
        while (b >= 0 && e < A.length() && A.charAt(b) == A.charAt(e)) {
            if (b == 0) {
                found = true;
                break;
            }
            
            b--;
            e++;
        }

        if (found)
            max = Math.max(max, e - b + 1);
    }
}
