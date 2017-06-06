package two_pointers;

import java.util.ArrayList;

/**
* https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
*/
public class RemoveDuplicatesFromSortedArrayB {
	public int removeDuplicates(ArrayList<Integer> a) {
        int index = 1;
        
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).intValue() != a.get(i - 1).intValue()) {
                a.set(index, a.get(i));
                index++;
            }    
        }
	   
	   return index;
	}
}
