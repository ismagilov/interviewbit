import java.util.ArrayList;

/**
* https://www.interviewbit.com/problems/set-matrix-zeros/
*/
public class SetMatrixZerosB {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    boolean zero1Row = false;
	    boolean zero1Col = false;
	    
	    for (int i = 0; i < a.size(); i++) {
	        for (int j = 0; j < a.get(i).size(); j++) {
	            if (i == 0 && a.get(0).get(j) == 0)
	                zero1Row = true;
	                
	            if (j == 0 && a.get(i).get(0) == 0)
	                zero1Col = true;
	                
	            if (a.get(i).get(j) == 0) {
	                a.get(0).set(j, 0);
	                a.get(i).set(0, 0);
	            }
	        }
	    }
	    
	    for (int i = 1; i < a.size(); i++) {
	        for (int j = 1; j < a.get(i).size(); j++) {
	            if (a.get(0).get(j) == 0 || a.get(i).get(0) == 0)
	                a.get(i).set(j, 0);
	        }
	    }
	    
        if (zero1Row == true)
	        for (int i = 0; i < a.get(0).size(); i++)
	            a.get(0).set(i, 0);
	   
        if (zero1Col == true)
            for (int i = 0; i < a.size(); i++)
                a.get(i).set(0, 0);
	}
}
