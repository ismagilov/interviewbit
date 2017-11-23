package trees;

/**
* https://www.interviewbit.com/problems/inversions/
*
* Used merge sort with inversions counting.
*/
public class InversionsA {
	public int countInversions(ArrayList<Integer> a) {
	    return mergeSort(a, 0, a.size() - 1);
	}
	
	private int mergeSort(ArrayList<Integer> arr, int b, int e) {
	    if (b == e)
	        return 0;
	        
	    int mid = b + (e - b) / 2;
	    
	    int inv = mergeSort(arr, b, mid);
	    inv += mergeSort(arr, mid + 1, e);
	    inv += merge(arr, b, mid, e);
	    
	    return inv;
	}
	
	private int merge(ArrayList<Integer> arr, int b, int mid, int e) {
	    //[b, mid], [mid + 1, e]
	    
	    ArrayList<Integer> merged = new ArrayList<>();
	    int inv = 0;
	    int l = b, r = mid + 1;
	    while (l <= mid && r <= e) {
	        if (arr.get(l) <= arr.get(r)) {
	            merged.add(arr.get(l));
	            l++;
	        } else {
	            merged.add(arr.get(r));
	            r++;
	            
	            inv += mid - l + 1;
	        }
	    }
	    
	    while (l <= mid) {
	        merged.add(arr.get(l));
	        l++;
	    }
	    
        while (r <= e) {
	        merged.add(arr.get(r));
	        r++;
	    }
        
        for (int i = b; i <= e; i++)
            arr.set(i, merged.get(i - b));
            
        return inv;    
	}
}
