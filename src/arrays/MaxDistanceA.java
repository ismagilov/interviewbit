package arrays;

/**
* https://www.interviewbit.com/problems/max-distance/
*/
public class MaxDistanceA {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> arr) {
        if (arr == null || arr.isEmpty())
            return -1;
            
        int[] leftMin = new int[arr.size()];
        int[] rightMax = new int[arr.size()];
        
        leftMin[0] = arr.get(0);
        for (int i = 1; i < arr.size(); i++)
            leftMin[i] = Math.min(arr.get(i), leftMin[i - 1]);
        

        rightMax[arr.size() - 1] = arr.get(arr.size() - 1);
        for (int i = arr.size() - 2; i >= 0; i--)
            rightMax[i] = Math.max(arr.get(i), rightMax[i + 1]);

        int max = 0;
        int i = 0, j = 0;
        while (i < arr.size() && j < arr.size()) {
            if (leftMin[i] <= rightMax[j]) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
            }
        }

        return max;
    }
}
