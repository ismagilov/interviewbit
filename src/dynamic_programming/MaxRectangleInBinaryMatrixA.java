package dynamic_programming;

/**
* https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
*
* Solution is based on calculating max histogram rectangle. 
* DP is used to some extent when building histogram in row to row traversal.
*/
public class MaxRectangleInBinaryMatrixA {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> arr) {
        if (arr == null || 
        arr.size() == 0 || 
        arr.get(0) == null || 
        arr.get(0).size() == 0) return 0;

        int max = 0;

        int h = arr.size(), w = arr.get(0).size();
        int[] row = new int[w];

        for (ArrayList<Integer> r : arr) {
            for (int i = 0; i < w; i++) {
                if (r.get(i) == 0)
                    row[i] = 0;
                else
                    row[i]++;
            }

            max = Math.max(max, maxArea(row));
        }

        return max;
    }

    private int maxArea(int[] a) {
        Deque<Integer> q = new ArrayDeque<>();

        int max = 0;

        int i = 0;
        while (i < a.length) {
            if (q.isEmpty() || a[i] >= a[q.peek()]) {
                q.push(i);
                i++;
            } else {
                int h = a[q.pop()];

                int right = i;
                if (q.isEmpty()) {
                    max = Math.max(max, h * right);
                } else {
                    int left = q.peek();
                    max = Math.max(max, h * (right - left - 1));
                }
            }
                    
        }

        int right = a.length;
        while (!q.isEmpty()) {
            int h = a[q.pop()];

            if (q.isEmpty()) {
                max = Math.max(max, h * right);
            } else {
                int left = q.peek();
            max = Math.max(max, h * (right - left - 1));
            }
        }

        return max; 
    }
}




