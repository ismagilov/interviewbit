package arrays;

/**
* https://www.interviewbit.com/problems/max-non-negative-subarray/
*/
public class MaxNonNegativeSubArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> arr) {
        ArrayList<Integer> maxSub = new ArrayList<>();
        long maxSum = 0;
        
        ArrayList<Integer> curSub = new ArrayList<>();
        long curMax = 0;
        for (int i = 0; i < arr.size(); i++) {
            int v = arr.get(i);
            if (v >= 0) {
                curMax += v;
                curSub.add(v);
            }
        
            if (v < 0 || i == arr.size() - 1) {
                if(curMax > maxSum) {
                    maxSum = curMax;
                    maxSub = curSub;
                } else if (curMax == maxSum && curSub.size() > maxSub.size()) {
                    maxSub = curSub;
                }

                curSub = new ArrayList<>();
                curMax = 0;
            }
        }

        return maxSub;
    }
}
