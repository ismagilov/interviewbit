package arrays;

/**
* https://www.interviewbit.com/problems/spiral-order-matrix-ii/
*/
public class SpiralOrderMatrixII {
	public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
	    int t = 0, r = n, l = 0, b = n;
	    int dir = 0; //0 - right, 1 - down, 2 - left, 3 - up
	    
	    ArrayList<ArrayList<Integer>> mx = new ArrayList<>();
	    for (int i = 0; i < n; i++) {
	        ArrayList<Integer> row = new ArrayList<Integer>();
	        
	        for (int j = 0; j < n; j++)
	            row.add(0);
	        
	        mx.add(row);
	    }
	        
	    int val = 0;
	    while (t <= b && l <= r) {
	        if (dir == 0) {
	            for (int i = l; i < r; i++)
	                mx.get(t).set(i, ++val);
	            
	            t++;
	        } else if (dir == 1) {
	            for (int i = t; i < b; i++)
	                mx.get(i).set(r - 1, ++val);
	                
	            r--;
	        } else if (dir == 2) {
	            for (int i = r - 1; i >= l; i--)
	                mx.get(b - 1).set(i, ++val);
	                
	            b--;
	        } else if (dir == 3) {
	            for (int i = b - 1; i >= t; i--)
	                mx.get(i).set(l, ++val);

	            l++;
	        }
	        
	        dir = (dir + 1) % 4;
	    }

	    return mx;
	}
}
