package two_pointers;

/**
* https://www.interviewbit.com/problems/array-3-pointers/
*/
public class Array3Pointers {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> a1, final List<Integer> a2, final List<Integer> a3) {
        int i1 = 0, i2 = 0, i3 = 0;
        int min = Integer.MAX_VALUE;

        while (i1 < a1.size() && i2 < a2.size() && i3 < a3.size()) {
            int v1 = a1.get(i1);
            int v2 = a2.get(i2);
            int v3 = a3.get(i3);

            min = Math.min(min, distance(v1, v2, v3));
            
            if (v1 <= v2 && v1 <= v3) {
                i1++;
            } else if (v2 <= v1 && v2 <= v3) {
                i2++;
            } else { 
                i3++;
            }
        }
        
        return min;
    }

    private int distance(int v1, int v2, int v3) {
        int d1 = Math.abs(v1 - v2);
        int d2 = Math.abs(v2 - v3);
        int d3 = Math.abs(v3 - v1);

        return Math.max(d1, Math.max(d2, d3));
    }
}
