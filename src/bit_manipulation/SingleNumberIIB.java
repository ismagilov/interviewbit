package bit_manipulation;

/**
* https://www.interviewbit.com/problems/single-number-ii/
*/
public class SingleNumberIIB {
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
        int ones = 0, twos = 0, threes = 0;
        
        for (int i = 0; i < a.size(); i++) {
            twos |= ones & a.get(i);
            ones ^= a.get(i);
            
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
    	  
    	return ones;
	}
}
