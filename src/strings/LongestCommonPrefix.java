package strings;

/**
* https://www.interviewbit.com/problems/longest-common-prefix/
*/
public class LongestCommonPrefix {
	public String longestCommonPrefix(ArrayList<String> a) {
	    if (a.size() == 0)
		return "";

	    String base = a.get(0);

	    int i = 0;
	    boolean found = false;
	    for (i = 0; i < base.length(); i++) {
		for (int j = 1; j < a.size(); j++) {
		    if (i >= a.get(j).length() || a.get(j).charAt(i) != base.charAt(i)) {
			found = true;
			break;
		    }
		}

		if (found)
		    break;
	    }

		return base.substring(0, i);
	}
}

