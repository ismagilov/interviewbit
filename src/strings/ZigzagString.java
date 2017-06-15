/**
* https://www.interviewbit.com/problems/zigzag-string/
*/
public class ZigzagString {
	public String convert(String a, int b) {
	    if (b <= 1)
	        return a;
	    
	    StringBuilder[] sbs = new StringBuilder[b];
	    
	    for (int i = 0; i < b; i++)
	        sbs[i] = new StringBuilder();
	   
	    int row = 0;
	    int step = 1;
	    for (int i = 0; i < a.length(); i++) {
	        sbs[row].append(a.charAt(i));
	        
	        if (row == 0)
	            step = 1;
	        else if (row == b - 1)
	            step = -1;
	            
	        row += step;
	    }
	    
	    StringBuilder res = new StringBuilder();
	    for (int i = 0; i < b; i++)
	        res.append(sbs[i]);
	   
	   return res.toString();
	}
}
