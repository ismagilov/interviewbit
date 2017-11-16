package binary_search;

/**
* https://www.interviewbit.com/problems/search-for-a-range/
*/
public class SearchForARangeC {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> arr, int x) {
	    int b = 0, e = arr.size() - 1;
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    res.add(-1);
	    res.add(-1);

        int first = binarySearch(arr, 0, arr.size() - 1, x);
        if (first == -1)
            return res;
        
        int tmp = first;
        int left = first;
        while (tmp >= 0) {
            left = tmp;
            tmp = binarySearch(arr, 0, tmp - 1, x);
        }    
        
        res.set(0, left);
        
        tmp = first;
        int right = first;
        while (tmp >= 0) {
            right = tmp;
            tmp = binarySearch(arr, tmp + 1, arr.size() - 1, x);
        }
        
        res.set(1, right);

	    return res;
	}
	
	private int binarySearch(List<Integer> arr, int b, int e, int target) {
	    while (b <= e) {
            int mid = b + (e - b) / 2;
            
            if (arr.get(mid) > target) 
                e = mid - 1;
            else if (arr.get(mid) < target)
                b = mid + 1;
            else if (arr.get(mid) == target)
                return mid;
	    }      
	    
	    return -1;
	}
}
