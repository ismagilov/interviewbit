/**
* https://www.interviewbit.com/problems/window-string/
*/
public class Solution {
	public String minWindow(String S, String T) {
	    HashMap<Character, Integer> ref = new HashMap<>();
	    HashMap<Character, Integer> cur = new HashMap<>();
	    
	    for (Character c : T.toCharArray()) {
	        Integer cnt = ref.getOrDefault(c, 0);
	        cnt++;
	        ref.put(c, cnt);
	    }
	    
	    int p1 = 0, p2 = 0;
	    int lng = Integer.MAX_VALUE;
	    int i1 = S.length(), i2 = S.length();
	    
	    boolean contains = false;
	    while(p1 < S.length() && p2 <= p1) {
	        while (!contains && p1 < S.length()) {
	            char c = S.charAt(p1);
	            cur.put(c, cur.getOrDefault(c, 0) + 1);
	            contains = containsRef(cur, ref);
	            p1++;
	        }
	        
	        while (contains && p2 <= p1) {
	            char c = S.charAt(p2);
	            cur.put(c, cur.get(c) - 1);
	            contains = containsRef(cur, ref);
	            if (!contains && (p1 - p2) < lng) {
	                lng = p1 - p2;
	                i1 = p2;
	                i2 = p1;
	            }
	            p2++;
	        }
	    }
	    
	    return lng != Integer.MAX_VALUE ? S.substring(i1, i2) : "";
	}
	
	private boolean containsRef(HashMap<Character, Integer> cur, HashMap<Character, Integer> ref) {
	    Set<Map.Entry<Character, Integer>> es = ref.entrySet();
	    for (Map.Entry<Character, Integer> e : es) {
	        if (!cur.containsKey(e.getKey()) || cur.get(e.getKey()) < e.getValue())
	            return false;
	    }
	    
	    return true;
	}
}
