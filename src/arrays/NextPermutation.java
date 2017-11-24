package arrays;

/**
* https://www.interviewbit.com/problems/next-permutation/
*/
public class NextPermutation {
	public void nextPermutation(ArrayList<Integer> a) {
	    int i = a.size() - 1;
	    while (i > 0 && a.get(i) < a.get(i - 1))
	        i--;
	    
	    //9 8 7 6 => i == 0 => only reverse
	    
	    if (i > 0) {
            int j = a.size() - 1;
            while (j > i - 1 && a.get(j) < a.get(i - 1))
                j--;
           
            int tmp = a.get(i - 1);
            a.set(i - 1, a.get(j));
            a.set(j, tmp);
	    }
	    
	    List<Integer> suffix = a.subList(i, a.size());
	    Collections.reverse(suffix);
	}
}
