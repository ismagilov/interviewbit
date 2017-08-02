package two_pointers;

import java.util.ArrayList;

/**
* https://www.interviewbit.com/problems/minimize-the-absolute-difference/
*/
public class MinimizeTheAbsoluteDifference {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int res = Integer.MAX_VALUE;
        
        int ia = 0;
        int ib = 0; 
        int ic = 0;
        
        while (ia < A.size() && ib < B.size() && ic < C.size()) {
            int a = A.get(ia);
            int b = B.get(ib);
            int c = C.get(ic);
            
            int min = Math.min(c, Math.min(a, b));
            int max = Math.max(c, Math.max(a, b));
            res = Math.min(res, Math.abs(max - min));
            
            if (a <= b && a < c)
                ia++;
            else if (b <= c && b < a)
                ib++;
            else if (c <= a && c < b)
                ic++;
            else if (a == c && a == b)
                ia++;
        }

        return res;
    }
}
