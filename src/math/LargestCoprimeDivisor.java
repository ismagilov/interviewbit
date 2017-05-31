package math;

/**
* https://www.interviewbit.com/problems/largest-coprime-divisor/
*/
public class LargestCoprimeDivisor {
    public int cpFact(int A, int B) {
        int min = Math.min(A, B);

        int res = A;
        int gcd;
        while ((gcd = gcd(res, B)) != 1) {
            res /= gcd;
        }
        
        return res;
    }
    
    public int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }
}
