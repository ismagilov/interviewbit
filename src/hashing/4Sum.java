package hashing;

/**
* https://www.interviewbit.com/problems/4-sum/
*
* Solution doesn't pass Efficiency tests on InterviewBit. But passes all tests on LeetCode.
*/
public class 4Sum {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> ints, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ints.sort(Comparator.naturalOrder());

        for (int i = 0; i < ints.size() - 3; i++) {
            if (i != 0 && ints.get(i) == ints.get(i - 1)) continue; 
            for (int j = i + 1; j < ints.size() - 2; j++) {
                if (j != i + 1 && ints.get(j) == ints.get(j - 1)) continue;
                int k = j + 1;
                int l = ints.size() - 1;
                
                //i, j, k, l;
                int s1 = ints.get(i) + ints.get(j);
                while (k < l) {
                    int s2 = ints.get(k) + ints.get(l);
                    
                    if (s1 + s2 > target)
                        l--;
                    else if (s1 + s2 < target)
                        k++;
                    else {
                        ArrayList<Integer> q = new ArrayList<>();
                        q.add(ints.get(i));
                        q.add(ints.get(j));
                        q.add(ints.get(k));
                        q.add(ints.get(l));
                        res.add(q);
                        
                        k++; l--;
                        
                        while (l > k && ints.get(l) == ints.get(l + 1))
                            l--;
                        
                        while (k < l && ints.get(k) == ints.get(k - 1))
                            k++;
                    }
                }
            } 
        } 
        
        return res;
    }
}
