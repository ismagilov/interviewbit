package backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
* https://www.interviewbit.com/problems/permutations/
*/
public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    Collections.sort(a);
	    
	    return generate(a, 0);
	}
	
	private  ArrayList<ArrayList<Integer>> generate(ArrayList<Integer> digits, int start) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    
	    if (start == digits.size() - 1) {
	        res.add(new ArrayList<>(digits));
	        return res;
	    }
	    
	    for (int i = start; i < digits.size(); i++) {
           digits = swap(digits, start, i);
	       res.addAll(generate(digits, start + 1));
           digits = swap(digits, start, i);
	    } 
	    
	    return res;
	}
	
	private ArrayList<Integer> swap(ArrayList<Integer> arr, int i, int j) {
	    int temp = arr.get(i);
	    arr.set(i, arr.get(j));
	    arr.set(j , temp);
	    
	    return arr;
	}
}
