package arrays;

import java.util.ArrayList;

/**
* https://www.interviewbit.com/problems/rotate-matrix/
*/
public class RotateMatrix {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    int n = a.size();
	    
	    for (int i = 0; i < n/2; i++) {
	        for (int j = i; j < n - 1 - i; j++) {
	            int tmp = a.get(i).get(j);
	            
	            a.get(i).set(j, a.get(n - 1 - j).get(i));
	            a.get(n - 1 - j).set(i, a.get(n - 1 - i).get(n - 1 - j));
	            a.get(n - 1 - i).set(n - 1 - j, a.get(j).get(n - 1 - i));
	            a.get(j).set(n - 1 - i, tmp);
	        }
	    }
	}
}
