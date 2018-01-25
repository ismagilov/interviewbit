package greedy;

/**
* https://www.interviewbit.com/problems/majority-element/
*
* Count elem with max occurences.
*/
public class MajorityElementA {
    public int majorityElement(final List<Integer> arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for (int i = 0; i < arr.size(); i++) { 
            int cnt = hash.getOrDefault(arr.get(i), 0);
            hash.put(arr.get(i), cnt + 1);
        }
        
        Set<Map.Entry<Integer, Integer>> es = hash.entrySet();
        int maxCnt = 0, elem = 0;
        for (Map.Entry<Integer, Integer> e : es) {
            if (e.getValue() > maxCnt) {
                maxCnt = e.getValue();
                elem = e.getKey();
            }
        }
        
        return elem;
    }
}
