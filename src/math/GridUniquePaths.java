package math;

/**
* https://www.interviewbit.com/problems/grid-unique-paths/
*/
public class GridUniquePaths {
	public int uniquePaths(int a, int b) {
	   if (a == 0 || b == 0)
	        return 1;
	   
	   // (2, 4) => 4 steps = 1 + 3
	   a--;
	   b--;
	   
	   // Calculate C(a + b, a) = (a + b)! / a! * b!
	   int max = Math.max(a, b);
	   long res = 1;
	   for (int i = max + 1; i <= a + b; i++) {
	       res *= i;
	       res /= i - max;
	   }

	   return (int)res;
	}
}
