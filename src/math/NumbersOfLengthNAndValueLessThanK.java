package math;

import java.util.ArrayList;

/**
* https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/
*/
public class NumbersOfLengthNAndValueLessThanK {
    public int solve(ArrayList<Integer> A, int B, int C) {
        char[] ca = Integer.toString(C).toCharArray();
        int lng = ca.length;

        if (A.size() == 0 || B > ca.length)
            return 0;

        if (B < ca.length) {
            if (A.get(0) == 0 && B > 1)
                return (A.size() - 1) * (int)Math.pow(A.size(), B - 1);
            else 
                return (int)Math.pow(A.size(), B);
        }

        int cntLessOrEq[] = new int[10];
        for (int i = 0; i < A.size(); i++)
            cntLessOrEq[A.get(i)] = 1;

        for (int i = 1; i < cntLessOrEq.length; i++)
            cntLessOrEq[i] = cntLessOrEq[i - 1] + cntLessOrEq[i];

        int dp = 0;
        int hasEqDigitsBefore = 1;
        for (int i = 0; i < ca.length; i++) {
            int d = ca[i] - 48;

            int hasEq = (d > 0) ? cntLessOrEq[d] - cntLessOrEq[d - 1] : cntLessOrEq[d];
            
            int cntLess = (d > 0) ? cntLessOrEq[d - 1] : 0;
            if (i == 0 && B > 1 && cntLessOrEq[0] == 1)
                cntLess--;

            dp = dp * A.size() + hasEqDigitsBefore * cntLess;
            hasEqDigitsBefore *= hasEq;
        }

        return dp;
    }
}
