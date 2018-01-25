package greedy;

/**
* https://www.interviewbit.com/problems/highest-product/
*
* One pass solution, gather mins and maxs.
*/
public class HighestProductB {
    public int maxp3(ArrayList<Integer> arr) {
        
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
            
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
