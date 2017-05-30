package math;

/**
* https://www.interviewbit.com/problems/rearrange-array/
*/
public class RearrangeArray {
	public void arrange(ArrayList<Integer> a) {
	    ArrayList<Integer> b = new ArrayList<>();
	    
	    int n = a.size();
	    for (int i = 0; i < a.size(); i++)
	        a.set(i, a.get(i) + (a.get(a.get(i)) % n) * n);
	        
	    for (int i = 0; i < a.size(); i++)     
	        a.set(i, a.get(i) / n);
	}
}
