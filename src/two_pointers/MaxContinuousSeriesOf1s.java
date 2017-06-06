package two_pointers;

/**
* https://www.interviewbit.com/problems/max-continuous-series-of-1s/
*/
public class MaxContinuousSeriesOf1s {
	public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
	    int maxb = 0, maxe = 0;
	    int max = 0;
	    
	    int i1 = 0, i2 = 0;
	    int zeros = 0;
	    for (i2 = 0; i2 < a.size(); i2++) {
	        if (a.get(i2) == 0)
	            zeros++;
	       
	        if (zeros > b) {
	            if (i2 - i1 > max) {
                    max = i2 - i1;
                    maxb = i1;
                    maxe = i2 - 1;
	            }

    	        while (zeros > b && i1 <= i2) {
    	            if (a.get(i1) == 0)
    	                zeros--;
    	            i1++;
    	        }
	        }
	    }

        if (i2 == a.size() && i2 - i1 > max) {
            max = i2 - i1;
            maxb = i1;
            maxe = i2 - 1;
        }

	    ArrayList<Integer> res = new ArrayList<>();
	    for (int i = maxb; i <= maxe; i++)
	        res.add(i);
	    
	    return res;
	}
}
