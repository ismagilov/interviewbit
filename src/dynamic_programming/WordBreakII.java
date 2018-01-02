package dynamic_programming;

/**
* https://www.interviewbit.com/problems/word-break-ii/
*
* Backtracking with memorization. It is not classic DP solution.
*/
public class WordBreakII {
    private final HashMap<Integer, ArrayList<String>> dp = new HashMap<>();
    
    public ArrayList<String> wordBreak(String s, ArrayList<String> dict) {
        return wordBreak(s, 0, dict);
    }

    private ArrayList<String> wordBreak(String s, int start, ArrayList<String> dict) {
        if (start == s.length()) {
            ArrayList<String> r = new ArrayList<>();
            r.add("");
            
            return r;
        }
        
        if (dp.containsKey(start))
            return dp.get(start);
        
        ArrayList<String> parts = new ArrayList<>();
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            int lng = end - start + 1;

            for (String dictWord : dict) {
                if (dictWord.equals(word)) {
                    List<String> rightParts = wordBreak(s, end, dict);

                    for (String rp : rightParts)
                         parts.add(word + (rp.length() > 0 ? " " : "") + rp);   

                    break;
                }
            }
        }
        
        dp.put(start, parts);
        
        return parts;
    }
}
