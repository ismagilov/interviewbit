package greedy;

/**
* https://www.interviewbit.com/problems/distribute-candy/
*
* Using one array;
*/
public class DistributeCandyB {
    public int candy(ArrayList<Integer> ratings) {
        int[] candies = new int[ratings.size()];
        
        Arrays.fill(candies, 1);
        
        for (int i = 1; i < ratings.size(); i++) {
            if (ratings.get(i) > ratings.get(i - 1))
                candies[i] = candies[i - 1] + 1;
        }
        
        for (int i = ratings.size() - 2; i >= 0; i--) {
            if (ratings.get(i) > ratings.get(i + 1) && candies[i] <= candies[i + 1])
                candies[i] = candies[i + 1] + 1;
        }
        
        int c = 0;
        for (int i = 0; i < ratings.size(); i++)
            c += candies[i];
        
        return c;
    }
}
