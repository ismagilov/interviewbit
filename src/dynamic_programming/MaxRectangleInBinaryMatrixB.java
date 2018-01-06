package dynamic_programming;

/**
* https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
*/
public class MaxRectangleInBinaryMatrixB {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> arr) {
        if (arr == null || 
        arr.size() == 0 || 
        arr.get(0) == null || 
        arr.get(0).size() == 0) return 0;

        int max = 0;

        int h = arr.size(), w = arr.get(0).size();
        int[][] dp = new int[h][w]; // Number of continuous 1-s in row i ending in column j
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int v = arr.get(i).get(j);
                
                if (j > 0)
                    dp[i][j] = v == 1 ? dp[i][j - 1] + 1 : 0;
                else
                    dp[i][j] = v;
                
                int row = i;
                int width = dp[i][j];
                while (row >= 0 && dp[row][j] != 0) {
                    width = Math.min(width, dp[row][j]);
                    max = Math.max(max, width * (i - row + 1));
                    
                    row--;
                }
            }
        }

        return max;
    }
}




