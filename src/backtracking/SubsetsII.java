/**
* https://www.interviewbit.com/problems/subsets-ii/
*/
public class SubsetsII {
    private final ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
	    Collections.sort(a);

	    genSubsets(a, new ArrayList<>(), 0);
	    
	    return res;    
	}
	
	private void genSubsets(ArrayList<Integer> set, ArrayList<Integer> prefix, int start) {
	    res.add(new ArrayList<>(prefix));
	    
	    for (int i = start; i < set.size(); i++) {
	        if (i > start && set.get(i) == set.get(i - 1))
	            continue;
	            
	        prefix.add(set.get(i));
            genSubsets(set, prefix, i + 1);
	        prefix.remove(prefix.size() - 1);
	    }
	}
}
