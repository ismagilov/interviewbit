package hashing;

import java.util.*;

/**
* https://www.interviewbit.com/problems/anagrams/
*/
public class Anagrams {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> ws) {
	    LinkedHashMap<String, ArrayList<Integer>> groups = new LinkedHashMap<>();
	    
	    for (int i = 0; i < ws.size(); i++) {
	        char[] wa = ws.get(i).toCharArray();
	        Arrays.sort(wa);
	        String str = new String(wa);
	        
	        if (groups.containsKey(str)) {
	            groups.get(str).add(i + 1);    
	        } else {
	            ArrayList<Integer> pos = new ArrayList<>();
	            pos.add(i + 1);
	            groups.put(str, pos);
	        }
	    }
	    
	    Collection<ArrayList<Integer>> vs = groups.values();
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    for (ArrayList<Integer> v : vs) 
	        res.add(v);
	        
	    return res;
	}
}
