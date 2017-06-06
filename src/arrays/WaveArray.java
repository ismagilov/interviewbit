package arrays;

import java.util.ArrayList;
import java.util.Comparator;

/**
* https://www.interviewbit.com/problems/wave-array/
*/
public class WaveArray {
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
	    a.sort(Comparator.naturalOrder());
	    
	    int b = 0, e = a.size() - 1;
	    for (int i = 0; i + 1 < a.size(); i += 2) {
	        int tmp = a.get(i + 1);
	        a.set(i + 1, a.get(i));
	        a.set(i, tmp);
	    }
	   
	    return a;     
	}
}
