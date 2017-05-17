package arrays;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
* https://www.interviewbit.com/problems/set-matrix-zeros/
*/
public class SetMatrixZerosA {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    LinkedHashSet<Integer> rows = new LinkedHashSet<>();
	    LinkedHashSet<Integer> columns = new LinkedHashSet<>();

	    for (int i = 0; i < a.size(); i++) {
    		for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    rows.add(i);
                    columns.add(j);
                }
    		}
	    }

	    for (Integer r : rows)
		for (int j = 0; j < a.get(r).size(); j++)
		    a.get(r).set(j, 0);

	    for (int i = 0; i < a.size(); i++)
		for (Integer c : columns)
		    a.get(i).set(c, 0);
	}
}
