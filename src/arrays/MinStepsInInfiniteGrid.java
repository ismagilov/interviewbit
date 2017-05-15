package arrays;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 */
public class MinStepsInInfiniteGrid {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int steps = 0;

        for (int i = 0; i < X.size() - 1; i++)
            steps += Math.max(Math.abs(X.get(i + 1) - X.get(i)), Math.abs(Y.get(i + 1) - Y.get(i)));

        return steps;
    }
}
