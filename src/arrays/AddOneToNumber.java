package arrays;

/**
* https://www.interviewbit.com/problems/add-one-to-number/
*/
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> arr) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int carry = 1;
        for (int i = arr.size() - 1; i >= 0; i--) {
            int v = arr.get(i) + carry;
            int d = v % 10;
            carry = v / 10;
            
            res.add(d);
        }
        
        if (carry == 1)
            res.add(1);
        
        while (res.size() > 0 && res.get(res.size() - 1) == 0)
            res.remove(res.size() - 1);
            
        Collections.reverse(res);
        
        return res;
    }
}
