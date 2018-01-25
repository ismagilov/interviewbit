package greedy;

/**
* https://www.interviewbit.com/problems/majority-element/
*
* Emulate stack, delete pairs of unequal elements.
*/
public class MajorityElementB {
    public int majorityElement(final List<Integer> arr) {
        int top = arr.get(0), size = 1;
        
        for (int i = 1; i < arr.size(); i++) {
            int n = arr.get(i);
            
            if (size == 0) {
                top = n;
                size++;
            } else {
                if (n != top) {
                    size--;
                } else {
                    size++;
                }
            }   
        }
        
        return top;
    }
}
