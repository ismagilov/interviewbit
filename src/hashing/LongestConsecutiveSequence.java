package hashing;

/**
 * https://www.interviewbit.com/problems/longest-consecutive-sequence
 */
public class LongestConsecutiveSequence {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> arr) {
        HashSet<Integer> nums = new HashSet<>();
        for (Integer n : arr)
            nums.add(n);

        int maxLng = 0;
        for (Integer n : arr) {
            if (nums.contains(n - 1)) continue;
            
            int cnt = 1;
            while (nums.contains(n + 1)) {
                n++;
                cnt++;
            }
            
            maxLng = Math.max(maxLng, cnt);
        }

        return maxLng;
    }
}
