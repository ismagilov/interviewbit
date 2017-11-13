package stacks_and_queues;

/**
* https://www.interviewbit.com/problems/simplify-directory-path/
*/
public class SimplifyDirectoryPath {
	public String simplifyPath(String p) {
	    if (null == p)
	        return "/";
	        
	    String[] pathItems = p.split("/");
	    ArrayDeque<String> s = new ArrayDeque<>();
	    
	    for (String pi : pathItems) {
	        if (pi.equals("..") && s.size() > 0)
	            s.pop();
	        
	        if (!pi.equals("") && !pi.equals(".") && !pi.equals(".."))
	            s.push(pi);
	    }
	    
	    StringJoiner sj = new StringJoiner("/");
	    pathItems = s.toArray(new String[s.size()]);
	    for (int i = pathItems.length - 1; i >= 0; i--)
	        sj.add(pathItems[i]);
	    
	    return "/" + sj.toString();
	}
}
