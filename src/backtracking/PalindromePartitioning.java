package backtracking;

/**
* https://www.interviewbit.com/problems/palindrome-partitioning/
*/
public class PalindromePartitioning {
    private final ArrayList<ArrayList<String>> res = new ArrayList<>();

    public ArrayList<ArrayList<String>> partition(String s) {
        if (s == null || s.isEmpty())
            return res;

        ArrayList<String> partition = new ArrayList<>();
        partitionPalindrome(s, 0, partition); 

        return res;
    }

    private void partitionPalindrome(String s, int start, ArrayList<String> partition) {
        if (start == s.length()) {
            res.add(new ArrayList<>(partition));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (isPalindrome(prefix)) {
                partition.add(prefix);
                partitionPalindrome(s, end, partition);
                partition.remove(partition.size() - 1);
            }
        }     
    }

    private boolean isPalindrome(String s) {
        int b = 0, e = s.length() - 1;

        while (b <= e) {
            if (s.charAt(b) != s.charAt(e)) 
                return false;
            b++;
            e--;
        }

        return true;
    }
}
