package backtracking;

/**
* https://www.interviewbit.com/problems/all-unique-permutations/
*/
public class AllUniquePermutations {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> arr) {
	    Map<Integer, Integer> counts = new TreeMap<>();
	    
	    for (Integer a : arr) {
	        int cnt = counts.getOrDefault(a, 0);
	        cnt++;
	        counts.put(a, cnt);
	    }
	    
	    int[] nums = new int[counts.size()];
	    int[] cnts = new int[counts.size()];
	    Set<Map.Entry<Integer, Integer>> es = counts.entrySet();
	    int i = 0;
	    for (Map.Entry<Integer, Integer> e : es) {
	        nums[i] = e.getKey();
	        cnts[i] = e.getValue();
	        i++;
	    }
	    
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    generatePermutation(nums, cnts, new ArrayList<>(), arr.size(), res);
	    
	    return res;
	}
	
	public void generatePermutation(int[] nums, int[] cnts, ArrayList<Integer> p, int sz, ArrayList<ArrayList<Integer>> res) {
        if (sz == 0) {
            res.add(new ArrayList<>(p));
            return;
        }	    
        
        for (int i = 0; i < nums.length; i++) {
            if (cnts[i] == 0)
                continue;
            
            cnts[i]--;
            p.add(nums[i]);
            generatePermutation(nums, cnts, p, sz - 1, res);
            cnts[i]++;
            p.remove(p.size() - 1);
        }
	}
}
