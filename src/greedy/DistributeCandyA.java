package greedy;

/**
* https://www.interviewbit.com/problems/distribute-candy/
*
* Using two arrays.
*/
public class DistributeCandyA {
    public int candy(ArrayList<Integer> ratings) {
        int[] left = new int[ratings.size()];
        int[] right = new int[ratings.size()];
        
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        for (int i = 1; i < ratings.size(); i++) {
            if (ratings.get(i) > ratings.get(i - 1))
                left[i] = left[i - 1] + 1;
        }
        
        for (int i = ratings.size() - 2; i >= 0; i--) {
            if (ratings.get(i) > ratings.get(i + 1))
                right[i] = right[i + 1] + 1;
        }
        
        int candies = 0;
        for (int i = 0; i < ratings.size(); i++)
            candies += Math.max(left[i], right[i]);
        
        return candies;
    }
}
