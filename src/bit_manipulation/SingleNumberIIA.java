package bit_manipulation;

import java.util.List;

/**
* https://www.interviewbit.com/problems/single-number-ii/
*/
public class SingleNumberIIA {
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
	    int[] bitsSum = new int[32];
	    
	    for (Integer e : a) {
	        long l = (long)e;
	        
	        for (int i = 0; i < 32; i++) {
	            bitsSum[i] += l & 1; 
	            l >>= 1;
	        }
	            
	    }
	    
        //System.out.println(Arrays.toString(bitsSum));
        
        long res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= bitsSum[i] % 3;
        }
	    
	    return (int)res;
	}
}
