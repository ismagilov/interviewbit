package math;

/**
* https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/
*/
public class SumOfPairwiseHammingDistance {
    private final int M = 1000000007;
    
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int hammingDistance(final List<Integer> arr) {
        int mask = 1;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            long set = 0;
            for (int n : arr) {
                if ((n & mask) == mask)
                    set++;
            }
            
            long unset = arr.size() - set;
            
            sum += (int)((2 * unset * set) % M);
            sum %= M;
            
            mask <<= 1;
        }
        
        return sum;
    }
}
