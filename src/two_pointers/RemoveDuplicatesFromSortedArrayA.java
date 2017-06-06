package two_pointers;

/**
* https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
*/ 
public class RemoveDuplicatesFromSortedArrayA {
	public int removeDuplicates(ArrayList<Integer> a) {
	   int i1 = 0, i2 = 0;
	   
	   int del = Integer.MIN_VALUE;
	   
	   while (i2 < a.size()) {
	       while (i2 < a.size() && a.get(i1).equals(a.get(i2)))
	           i2++;

	       while (i1 < i2 - 1) {
	           a.set(i1, del);
	           i1++;
	       }

	       i1 = i2;
	   }
	   
	   a.removeAll(Arrays.asList(del));
	   
	   return a.size();
	}
}
