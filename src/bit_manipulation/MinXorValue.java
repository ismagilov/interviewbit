package bit_manipulation;

import java.util.ArrayList;
import java.util.Comparator;

/**
* https://www.interviewbit.com/problems/min-xor-value/
*/
public class MinXorValue {
    public int findMinXor(ArrayList<Integer> A) {
        A.sort(Comparator.naturalOrder());
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++)
            min = Math.min(min, A.get(i) ^ A.get(i + 1));
        
        return min;
    }
}
