package backtracking;

/**
* https://www.interviewbit.com/problems/subset/
*/
public class Subset {
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
	    Collections.sort(a);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    genSubsets(res, a, new ArrayList<>(), 0); 
	    
	    return res;
	}
	
	private void genSubsets(
	    ArrayList<ArrayList<Integer>> res, ArrayList<Integer> set, 
	    ArrayList<Integer> prefix, int start) {

        res.add(new ArrayList<>(prefix));

	    for (int i = start; i < set.size(); i++) {
	        prefix.add(set.get(i));
	        genSubsets(res, set, prefix, i + 1);
	        prefix.remove(prefix.size() - 1);
	    }
	}
}
