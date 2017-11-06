package bit_manipulation;

/**
* https://www.interviewbit.com/problems/divide-integers/
*/
public class DivideIntegersA {
	public int divide(int dividend, int divisor) {
	    if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
	        return Integer.MAX_VALUE;

        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = -1;
            
        long dvd = dividend;
        long dvs = divisor;

        dvd = Math.abs(dvd);
        dvs = Math.abs(dvs);

        long q = 0;
        while (dvd >= dvs) {
            long temp = dvs, multiply = 1;
            while (dvd >= temp << 1) {
                temp <<= 1;
                multiply <<= 1;
            }

            q += multiply;
            dvd -= temp;
        }

        return (int)(sign == 1 ? q : -q);
	}
}
