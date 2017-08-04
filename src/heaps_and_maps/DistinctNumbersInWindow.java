package heaps_and_maps;

/**
* https://www.interviewbit.com/problems/distinct-numbers-in-window/
*/
public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k > arr.size())
            return res;

        HashMap<Integer, Integer> cnts = new HashMap<>();
        int unique = 0;
        for (int i = 0; i < k; i++) {
            int n = arr.get(i);
            if (cnts.containsKey(n)) {
                cnts.put(n, cnts.get(n) + 1);
            } else {
                unique++;
                cnts.put(n, 1);
            }
        }
        res.add(unique);
        
        for (int i = k; i < arr.size(); i++) {
            int del = arr.get(i - k);
            int num = cnts.get(del);
            if (num == 1) {
                unique--;
                cnts.remove(del);
            } else {
                cnts.put(del, num - 1);
            }
            
            int add = arr.get(i);
            if (cnts.containsKey(add)) {
                cnts.put(add, cnts.get(add) + 1);
            } else {
                unique++;
                cnts.put(add, 1);
            }
            
            res.add(unique);
        }
     
        return res;   
    }
}
