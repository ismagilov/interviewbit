package greedy;

/**
* https://www.interviewbit.com/problems/highest-product/
*
* Sorting and max between two triplets.
*/
public class HighestProductA {
    public int maxp3(ArrayList<Integer> arr) {
        arr.sort(Comparator.naturalOrder());

        return Math.max(
            arr.get(0) * arr.get(1) * arr.get(arr.size() - 1), 
            arr.get(arr.size() - 1) * arr.get(arr.size() - 2) * arr.get(arr.size() - 3)
            );
    }
}
