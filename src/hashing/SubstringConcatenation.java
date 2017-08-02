package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* https://www.interviewbit.com/problems/substring-concatenation/
*/
public class SubstringConcatenation {
	public ArrayList<Integer> findSubstring(String s, final List<String> l) {
	    ArrayList<Integer> res = new ArrayList<>();
	    if (l.size() == 0)
	        return res;
	    
	    int sz = l.get(0).length();  
	    int lng = sz * l.size();
	    
	    HashMap<String, Integer> words = new HashMap<>();
	    for (String word : l)
            words.put(word, words.getOrDefault(word, 0) + 1);	        
        
	    for (int i = 0; i <= s.length() - lng; i++) {
	        HashMap<String, Integer> subStr = new HashMap<>(words);
	        
	        for (int j = i; j < i + lng; j += sz) {
	            String chunk = s.substring(j, j + sz);
	            
	            if (subStr.containsKey(chunk)) {
	                int n = subStr.get(chunk);
	                if (n == 1)
	                    subStr.remove(chunk);
	                else
	                    subStr.put(chunk, n - 1);
	            }
	        }
	        
	        if (subStr.isEmpty())
                res.add(i);
	    }

	    return res;
	}
}
