package hashing;

/**
* https://www.interviewbit.com/problems/points-on-the-straight-line/
*/
public class PointsOnTheStraightLine {
	public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
	    int points = x.size();
	    if (points < 2)
	        return points;
	        
	    int res = 0;
	    for (int i = 0; i < points; i++) {
	        HashMap<Double, Integer> slopes = new HashMap<>();
	        int dups = 0;
	        
	        for (int j = 0; j < points; j++) {
	            if (i == j) continue;
	            
	            if (x.get(i) == x.get(j) && y.get(i) == y.get(j)) {
	                dups++;
	                continue;
	            } 
	            
	            double ang = 0;
	            if (x.get(i) == x.get(j))
	                ang = Double.MAX_VALUE;
	            else if (y.get(i) == y.get(j))
	                ang = 0;
	            else
	                ang = (double)(y.get(j) - y.get(i)) / (double)(x.get(j) - x.get(i));

	            slopes.put(ang, slopes.getOrDefault(ang, 0) + 1);
	        }
	        
            int max = 0;
            for (Integer num : slopes.values())
                max = Math.max(max, num);
                
            max += dups + 1;
            
            res = Math.max(res, max);
	    }
	    
	    return res;
	}
}
