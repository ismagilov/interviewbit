package hashing;

/**
* https://www.interviewbit.com/problems/longest-substring-without-repeat/
*/
public class LongestSubstringWithoutRepeat {
	public int lengthOfLongestSubstring(String a) {
	    Map<Character, Integer> hash = new HashMap<>();
	    
	    int max = 0;
	    int start = 0;
	    for (int i = 0; i < a.length(); i++) {
	        char ch = a.charAt(i);
	        if (hash.containsKey(ch)) {
	            max = Math.max(max, hash.size());
	            
	            int idx = hash.get(ch);
	            while (start <= idx) {
	                hash.remove(a.charAt(start));
	                start++;
	            }
	        }
	        
	        hash.put(ch, i);
	    }

	    return Math.max(max, hash.size());
	}
}
