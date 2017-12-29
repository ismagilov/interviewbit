package two_pointers;

/**
* https://www.interviewbit.com/problems/3-sum-zero/
*/
public class 3SumZero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        list.sort(Comparator.naturalOrder());
        
        for (int i = 0; i < list.size() - 2; i++) {
            if (i > 0 && list.get(i).intValue() == list.get(i - 1).intValue()) continue;
            
            int j = i + 1, k = list.size() - 1;
            
            while (j < k) {
                int sum = list.get(i) + list.get(j) + list.get(k);
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    
                    
                    ArrayList<Integer> t = new ArrayList();
                    t.add(list.get(i));
                    t.add(list.get(j));
                    t.add(list.get(k));
                    res.add(t);
                    
                    j++;
                    k--;
                    while (j < k && list.get(j) == list.get(j - 1))
                        j++;
                    while (j < k && list.get(k) == list.get(k + 1))
                        k--;
                }
            }
        }
        
        return res;
    }
}
