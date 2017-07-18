package backtracking;

/**
* https://www.interviewbit.com/problems/gray-code/
*/
public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
	    return generate(n);
	}
	
	private ArrayList<Integer> generate(int n) {
	    if (n == 0) {
	        ArrayList<Integer> initial = new ArrayList<>();
	        initial.add(0);
	        return initial;
	    }
	   
	    ArrayList<Integer> gc = generate(n - 1);
	    
	    for (int i = gc.size() - 1; i >= 0; i--) {
	        int num = gc.get(i);
	        num |= 1 << (n - 1);
	        gc.add(num);
	    }
	    
	    return gc;
	}
}
