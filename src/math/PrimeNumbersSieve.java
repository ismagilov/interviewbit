package math;

import java.util.ArrayList;

/**
* https://www.interviewbit.com/problems/prime-numbers/
*/
public class PrimeNumbersSieve {
	public ArrayList<Integer> sieve(int a) {
	    int[] primes = new int[a + 1];
	    for (int i = 0; i <= a; i++)
	        primes[i] = 1;
	    
	    primes[0] = 0;
	    primes[1] = 0;
	    
	    for (int i = 2; i <= Math.sqrt(a); i++) {
	        if (primes[i] == 1) {
	            for (int j = i; i * j <= a; j++)
	                primes[i * j] = 0;
	        }
	    }
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    for (int i = 0; i <= a; i++) 
	        if (primes[i] == 1)
	            res.add(i);
	            
	    return res;
	}
}
