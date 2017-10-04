package heaps_and_maps;

/**
* https://www.interviewbit.com/problems/ways-to-form-max-heap/
*/ 
public class WaysToFormMaxHeap {
    public int solve(int n) {
        if (n == 0 || n == 1)
            return 1;
        
        int h = (int)(Math.log(n) / Math.log(2)) + 1;
        
        int pow = (int)Math.pow(2, h - 1);
        
        int maxLast = pow;
        int actualLast = n - (pow - 1);
        
        int l;
        if (actualLast >= maxLast / 2)
            l = pow - 1;
        else
            l = pow - 1 - (maxLast / 2 - actualLast);
        
        long subres = ((long)solve(l) * (long)solve(n - 1 - l)) % 1000000007;
        long res = (cnk(l, n - 1) * subres) % 1000000007;
            
        return (int)res;
    }
    
    private long cnk(int k, int n) {
        long res = 1;
        for (long i = k + 1; i <= n; i++) {
            res *= i;
            res /= i - k;
        } 
        
        return res % 1000000007;
    }
}
